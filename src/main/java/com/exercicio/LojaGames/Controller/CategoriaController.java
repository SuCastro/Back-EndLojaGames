package com.exercicio.LojaGames.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.exercicio.LojaGames.Repository.CategoriaRepository;
import com.exercicio.LojaGames.Model.CategoriaModel;

public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;

	@GetMapping // SE A REQUISICAO FOR GET IRA ASIONAR ESSE MÉTODO
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<CategoriaModel>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		
	}

	@PostMapping  // SALVAR
	public ResponseEntity<CategoriaModel> post(@RequestBody CategoriaModel postagem) { //FARA UM PEDIDO PELO BODY
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	@PutMapping //ATUALIZAR
	public ResponseEntity<CategoriaModel> put(@RequestBody CategoriaModel postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	@DeleteMapping ("/{id}") //DELETAR
	public void delete(@PathVariable long id)
	{
		repository.deleteById(id);
	} 	
}