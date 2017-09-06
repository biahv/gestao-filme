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

import com.algaworks.gestaofilme.model.Atores;
import com.algaworks.gestaofilme.repository.Ator;



@Controller
@RequestMapping("/atores")
public class AtoresController {
	
	@Autowired
	private Ator ator;
	
	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaAtores");
		mv.addObject("ator",ator.findAll());
	return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmAtores");
		mv.addObject(new Atores());
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView salvar(@Validated Atores atores, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("FrmAtores");
		mv.addObject("ator", ator.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.ator.save(atores);
			return new ModelAndView("redirect:atores");
		}catch(Exception e){return mv;}
		
	}
	
	
	@RequestMapping(value ="/excluir/{idAtores}")
	public String excluirAtoresByPathVariable(@PathVariable Long idAtores, HttpServletRequest request, 
					HttpServletResponse response) {
		this.ator.delete(idAtores);
		return "redirect:/atores";
	}
	
	@RequestMapping("/alterar/{idAtores}")
	public ModelAndView alterarAtoresByPathVariable(@PathVariable Long idAtores, HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("FrmAtores");
		mv.addObject("ator",ator.findAll());
		Atores atores = ator.findOne(idAtores);
		mv.addObject(ator);
		return mv;
	}
	
	@RequestMapping(value="{idAtores}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idAtores, RedirectAttributes attributes) {
		ator.delete(idAtores);
		attributes.addFlashAttribute("mensagem", "Ator excluído com sucesso!");
		return "redirect:/atores";
	}

}
