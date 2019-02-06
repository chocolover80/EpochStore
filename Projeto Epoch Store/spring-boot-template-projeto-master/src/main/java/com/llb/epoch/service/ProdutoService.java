package com.llb.epoch.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.llb.epoch.model.Produto;
import com.llb.epoch.repository.Produtos;
import com.llb.epoch.storage.FotoStorage;
import com.llb.epoch.storage.FotoStorageS3;

@Service
public class ProdutoService {
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	public void salvar (Produto p) {
		//Aqui vão as regras de negócio
		this.produtos.save(p);
	}
	
	public String salvarFoto(Long codigo, MultipartFile foto) {
		Produto produto = produtos.findOne(codigo);
		String nomeFoto = foto.getOriginalFilename(), formato = "";
		if (nomeFoto.contains(".jpeg") || nomeFoto.contains(".JPEG")) {
			formato = ".jpeg";
		}else if (nomeFoto.contains(".png") || nomeFoto.contains(".PNG")) {
			formato = ".png";
		}else if (nomeFoto.contains(".jpg") || nomeFoto.contains(".JPG")) {
			formato = ".jpg";
		}
		nomeFoto = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(Calendar.getInstance().getTime())+formato;
		nomeFoto = fotoStorage.salvar(foto, nomeFoto);
		produto.setFoto(nomeFoto);
		produtos.save(produto);
		return fotoStorage.getUrl(nomeFoto);
	}
	
}
