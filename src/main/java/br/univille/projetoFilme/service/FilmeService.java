package br.univille.projetoFilme.service;

import java.util.List;


import org.springframework.stereotype.Service;

import br.univille.projetoFilme.model.Filme;

@Service
public interface FilmeService {
	
	List<Filme> getall();

	void save(Filme filme);
	
	void remove(Filme filme);
	
	Filme findById(long id);

}
