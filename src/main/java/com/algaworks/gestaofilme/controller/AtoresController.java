package com.algaworks.gestaofilme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.gestaofilme.model.Ator;
import com.algaworks.gestaofilme.repository.Atores;


@Controller
@RequestMapping("/atores")
public class AtoresController {
	
	@Autowired
	private Atores atores;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaAtores");
		mv.addObject("atores",atores.findAll());
	return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmAtores");
		mv.addObject(new Ator());
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView salvar(@Validated Ator ator, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("FrmAtores");
		mv.addObject("atores", atores.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.atores.save(ator);
			return new ModelAndView("redirect:atores");
		}catch(Exception e){return mv;}
		
	}
	
	@RequestMapping(value ="/excluir/{idAtor}")
	public String excluirAtorByPathVariable(@PathVariable Long idAtor, HttpServletRequest request, 
					HttpServletResponse response) {
		this.atores.delete(idAtor);
		return "redirect:/atores";
	}
	
	@RequestMapping("/alterar/{idAtor}")
	public ModelAndView alterarAtorByPathVariable(@PathVariable Long idAtor, HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("FrmAtores");
		mv.addObject("atores",atores.findAll());
		Ator ator = atores.findOne(idAtor);
		mv.addObject(ator);
		return mv;
	}
	
	@RequestMapping(value="{idAtor}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idAtor, RedirectAttributes attributes) {
		atores.delete(idAtor);
		attributes.addFlashAttribute("mensagem", "Ator excluído com sucesso!");
		return "redirect:/atores";
	}

}
