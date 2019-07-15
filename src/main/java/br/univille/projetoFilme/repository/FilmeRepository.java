package br.univille.projetoFilme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projetoFilme.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme,Long>{
	Filme findByPersonagem(String personagem);
}
