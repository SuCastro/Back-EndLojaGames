package com.exercicio.LojaGames.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name= "produto")
public class ProdutoModel { 

	@Id // INORMANDO QUE É O ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // USADO JUNTO COM ID //IDENTITY É AUTO INCRMENT// PRIMARY KEY
	private Long id;

	@NotNull // NÃO RECEBER VALOR NULO
	@Size(min = 5, max = 100) // PARAMETROS DE QUANTIDADE CARACTER
	private String nome;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List <CategoriaModel>categoriaModel;

	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CategoriaModel> getCategoria() {
		return categoriaModel;
	}

	public void setCategoria(List<CategoriaModel> categoria) {
		this.categoriaModel = categoria;
	}	
}