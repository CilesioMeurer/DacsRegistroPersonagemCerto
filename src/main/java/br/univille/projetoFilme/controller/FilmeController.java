package br.univille.projetoFilme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetoFilme.model.Filme;
import br.univille.projetoFilme.service.FilmeService;
	
@Controller
@RequestMapping("/filme")
public class FilmeController {
	
	@Autowired
	private FilmeService service;
	
	@GetMapping()
	public ModelAndView index() {
		return new ModelAndView("filme/index","filmes",service.getall());
		
	}	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Filme filme) {
		return new ModelAndView("filme/form");
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid Filme filme) {
		service.save(filme);
		return new ModelAndView("redirect:/filme");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Filme filme) {
		return new ModelAndView("filme/form","filme",filme);
		
	}
	
	@GetMapping(value="/remover/{id}")
	public ModelAndView remove(@PathVariable("id") Filme filme) {
		service.remove(filme);
		return new ModelAndView("redirect:/filme");
	}
 }
	


	
