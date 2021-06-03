package br.com.godenginestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.services.MarcaService;

@Controller
@RequestMapping(path = "/marca/")
public class MarcaController {
	
	@Autowired
	MarcaService marcaService;
	
	@GetMapping(path = "/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("marca");
		List<Marca> marcas = marcaService.getTodasMarcas();
		model.addObject("marcas", marcas);
		
		return (model);
	}
	
	@RequestMapping(path = "/form")
	public ModelAndView marcaForm() {
		ModelAndView model = new ModelAndView("forms/marcaForm");
		model.addObject("marca", new Marca());
		return model;
	}
	
	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarMarca(Marca marca) {
		marcaService.cadastrarMarca(marca);
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	
	@RequestMapping("{idMarca}")
	public ModelAndView alterarMarca(@PathVariable Integer idMarca) {
		Marca marca = marcaService.buscarPorId(idMarca);
		ModelAndView model = new ModelAndView("forms/marcaForm");
		model.addObject("marca", marca);
		
		return model;
	}
	
	@RequestMapping(path="/excluir/{idMarca}")
	public ModelAndView excluirMarca(@PathVariable Integer idMarca) {
		marcaService.removerMarca(idMarca);
		ModelAndView model = new ModelAndView("redirect:/marca/");
		return model;
	}
}