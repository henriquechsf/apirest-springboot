package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")

// anotation do Swagger
@Api(value = "API REST Produtos")
// libera o dominio que vai acessar a API
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	// busca todos os produtos
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
	// busca produto por id
	// {id} argumento enviado na url
	@ApiOperation(value = "Retorna um produto único")
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}
	
	// salva produto
	@ApiOperation(value = "Salva um produto")
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// apaga produto
	@ApiOperation(value = "Deleta um produto")
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	// atualiza produto
	@ApiOperation(value = "Atualiza um produto")
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
