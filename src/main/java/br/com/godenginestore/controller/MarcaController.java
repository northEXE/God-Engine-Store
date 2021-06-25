package br.com.godenginestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.services.MarcaService;

@Controller
@RequestMapping(path = "admin/marca/")
@PreAuthorize("hasRole('ADMIN')")
public class MarcaController {
	
	@Autowired
	MarcaService marcaService;
	
	@GetMapping(path = "/")
	public ModelAndView index(@RequestParam(required=false) String erro) {
		ModelAndView model = new ModelAndView("marca");
		List<Marca> marcas = marcaService.getTodasAsMarcas();
		model.addObject("marcas", marcas);
		model.addObject("erro", erro);
		
		return model;
	}
	
	@RequestMapping(path = "/form")
	public ModelAndView marcaForm() {
		ModelAndView model = new ModelAndView("forms/marcaForm");
		model.addObject("marca", new Marca());
		
		return model;
	}
	
	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarMarca(Marca marca) {
		Boolean itsOk = marcaService.cadastrarMarca(marca);
		ModelAndView model = new ModelAndView("redirect:/marca/");
		if(itsOk == false) {
			String erro = "Esta marca já foi cadastrada!";
			model.addObject("erro", erro);
		}
		return model;
	}
	
}
