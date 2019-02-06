package com.llb.epoch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.llb.epoch.model.Produto;
import com.llb.epoch.model.TipoProduto;
import com.llb.epoch.repository.Produtos;
import com.llb.epoch.service.ProdutoService;
import com.llb.epoch.storage.FotoStorage;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/produto/ListagemProdutos");
		mv.addObject("produtos", produtos.findAll());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(Produto p) {
		ModelAndView mv = new ModelAndView ("produto/CadastroProduto");
		mv.addObject("tipos", TipoProduto.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Produto p, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(p);
		}
		produtoService.salvar(p);
		attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:/produtos/novo");
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView visualizarProduto(@PathVariable("codigo") Produto produto) {
		ModelAndView mv = new ModelAndView("/produto/VisualizacaoProduto");
		if (produto.temFoto())
			produto.setUrl(fotoStorage.getUrl(produto.getFoto()));
		mv.addObject("produto", produto);
		return mv;
	}
}
