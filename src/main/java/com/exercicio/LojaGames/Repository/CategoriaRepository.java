package com.exercicio.LojaGames.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exercicio.LojaGames.Model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> { 
	
	//BUSCA TUDO QUE CONTÉM EM TÍTULO 
	//IGNORANDO MAIUSCULAS E MINUSCULAS OU SEJA PATRONIZANDO TUDO PARA MINUSCULAS
	public List<CategoriaModel> findAllByTituloContainingIgnoreCase(String titulo); 
}