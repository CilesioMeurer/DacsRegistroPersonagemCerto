package br.univille.projetoFilme.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetoFilme.model.Filme;
import br.univille.projetoFilme.repository.FilmeRepository;
import br.univille.projetoFilme.service.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService{
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Override
	public List<Filme> getall() {
		return filmeRepository.findAll();
	}

	@Override
	public void save(Filme filme) {
		filmeRepository.save(filme);
		
	}
	
	@Override
	public void remove(Filme filme) {
		filmeRepository.delete(filme);
	}

	@Override
	public Filme findById(long id) {
		Optional<Filme> retorno = filmeRepository.findById(id);
		if(retorno.isPresent())
			return retorno.get();
		return null;
	}

}
