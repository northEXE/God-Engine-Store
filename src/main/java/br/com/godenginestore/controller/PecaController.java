package br.com.godenginestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.godenginestore.model.Peca;
import br.com.godenginestore.model.TipoPeca;
import br.com.godenginestore.services.PecaService;
import br.com.godenginestore.services.TipoPecaService;

@Controller
@RequestMapping(path = "/peca/")
public class PecaController {
	
	@Autowired
	PecaService pecaService;
	
	@Autowired
	TipoPecaService tipoPecaService;
	
	@RequestMapping(path = "/form")
	public ModelAndView pecaForm() {
		ModelAndView model = new ModelAndView("forms/pecaForm");
		Peca peca = new Peca();
		List<TipoPeca> tiposDePecas = tipoPecaService.listarTodosOsTipos();
		model.addObject("peca", peca);
		model.addObject("tiposDePecas", tiposDePecas);
		
		return model;
	}
	
	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarPeca(@RequestParam Integer idTipoPeca, Peca peca) {
		ModelAndView model = new ModelAndView("redirect:/peca/listarPecas");
		pecaService.cadastrarPeca(peca);
		pecaService.inserirTipoPeca(peca, idTipoPeca);
		
		return model;
	}
	
	@GetMapping(path = "/listarPecas")
	public ModelAndView listarTodasAsPecas() {
		ModelAndView model = new ModelAndView("peca");
		List<Peca> todasAsPecas = pecaService.listarTodasAsPecas();
		model.addObject("todasAsPecas", todasAsPecas);
		
		return model;
	}
	
	@GetMapping(path = "/{idTipoPeca}/listarPecas-Tipo")
	public ModelAndView listarPecasPorTipo(@PathVariable Integer idTipoPeca) {
		ModelAndView model = new ModelAndView("peca");
		List<Peca> todasAsPecas = pecaService.buscarPorTipo(idTipoPeca);
		model.addObject("todasAsPecas", todasAsPecas);
		
		return model;
	}
	
	
}
