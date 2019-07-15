package br.univille.projetoFilme.api;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projetoFilme.model.Filme;
import br.univille.projetoFilme.service.FilmeService;

@RestController
@RequestMapping("/api/filmes")
public class FilmeControllerAPI {
	@Autowired
	private FilmeService service;
	
	@GetMapping
	public ResponseEntity<List<Filme>> listarFilmes(){
		List<Filme> lista = new ArrayList<Filme>();
		try {
			lista = service.getall();
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<List<Filme>>(lista,HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Filme filme){
		service.save(filme);
		return ResponseEntity.ok().build();
	}
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Filme filme){
		Filme filmeAtual = service.findById(id);
		if(filmeAtual != null) {
			filmeAtual.setPersonagem(filme.getPersonagem());
			filmeAtual.setObra(filme.getObra());
			filmeAtual.setGenero(filme.getGenero());
			service.save(filmeAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Filme filmeAtual = service.findById(id);
		if(filmeAtual != null) {
			service.remove(filmeAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	

}
