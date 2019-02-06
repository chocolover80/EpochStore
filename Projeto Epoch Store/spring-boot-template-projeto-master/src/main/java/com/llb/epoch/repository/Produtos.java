package com.llb.epoch.repository;

import java.util.List;

import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.llb.epoch.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long>{

//exemplo de como criar queries abaixo
//	@Query(value = "select * from tbproduto WHERE nome like %?1%", nativeQuery = true)
//	//@Query("SELECT p FROM Produto p WHERE p.nome like ?1%")
//    
//	public List<Produto> todosPorX(String pNome);
}
