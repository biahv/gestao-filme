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

import com.algaworks.gestaofilme.model.Filme;
import com.algaworks.gestaofilme.repository.Filmes;



@Controller
@RequestMapping("/filmes")
public class FilmesController {
	
	@Autowired
	private Filmes filmes;

	@GetMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("LisFilme");
		mv.addObject("filmes",filmes.findAll());
	return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("FrmFilme");
		mv.addObject(new Filme());
		return mv;
	}
	
	@PostMapping("")
	public ModelAndView salvar(@Validated Filme filme, Errors erros, RedirectAttributes redirectAttributes){
		ModelAndView mv = new ModelAndView("FrmFilme");
		mv.addObject("festas", filmes.findAll());
		if(erros.hasErrors()){
			return mv;
		}
		try{
			this.filmes.save(filme);
			return new ModelAndView("redirect:filmes");
		}catch(Exception e){return mv;}
		
	}
	
	@RequestMapping(value ="/excluir/{idFilme}")
	public String excluirFilmeByPathVariable(@PathVariable Long idFilme, HttpServletRequest request, 
					HttpServletResponse response) {
		this.filmes.delete(idFilme);
		return "redirect:/filmes";
	}
	
	@RequestMapping("/alterar/{idFilme}")
	public ModelAndView alterarFilmeByPathVariable(@PathVariable Long idFilme, HttpServletRequest request, 
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("FrmFilme");
		mv.addObject("filmes",filmes.findAll());
		Filme filme = filmes.findOne(idFilme);
		mv.addObject(filme);
		return mv;
	}
	
	@RequestMapping(value="{idFilme}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long idFilme, RedirectAttributes attributes) {
		filmes.delete(idFilme);
		attributes.addFlashAttribute("mensagem", "Filme excluído com sucesso!");
		return "redirect:/filmes";
	}

}
