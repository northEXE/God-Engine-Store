package br.com.godenginestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.godenginestore.model.TipoPeca;
import br.com.godenginestore.services.TipoPecaService;

@Controller
@RequestMapping(path = "/tipoPeca/")
public class TipoPecaController {
	
	@Autowired
	TipoPecaService tipoPecaService;
	
	@RequestMapping(path = "/form")
	public ModelAndView tipoPecaForm() {
		ModelAndView model = new ModelAndView("forms/tipoPecaForm");
		TipoPeca tipoPeca = new TipoPeca();
		model.addObject("tipoPeca", tipoPeca);
		
		return model;
	}
	
	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrar(TipoPeca tipoPeca) {
		ModelAndView model = new ModelAndView("redirect:/");
		tipoPecaService.cadastrarTipoDePeca(tipoPeca);
		
		return model;
	}
	
}
