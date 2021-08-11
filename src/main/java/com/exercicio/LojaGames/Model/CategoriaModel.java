package com.exercicio.LojaGames.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {


		@Id // INORMANDO QUE É O ID
		@GeneratedValue(strategy = GenerationType.IDENTITY) // USADO JUNTO COM ID //IDENTITY É AUTO INCRMENT// PRIMARY KEY
		private long id;

		@NotBlank // NÃO RECEBER VALOR NULO
		@Size(min = 5, max = 100) // PARAMETROS DE QUANTIDADE CARACTER
		private String titulo;

		@NotBlank // NÃO RECEBER VALOR NULO
		@Size(min = 10, max = 100) // PARAMETROS DE QUANTIDADE CARACTER
		private String descricao;

		// INTERACAO COM AS TABELAS PRODUTOMODEL E CATEGORIAMODEL
		@ManyToOne
		@JsonIgnoreProperties("Categoria")
		private ProdutoModel produto;
		
		public long getId() { 
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public ProdutoModel getProduto() {
			return produto;
		}

		public void setProduto(ProdutoModel produto) {
			this.produto = produto;
		}				
}