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
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.services.MarcaService;
import br.com.godenginestore.services.ModeloService;

@Controller
@RequestMapping(path = "/{idMarca}/modelo/")
public class ModeloController {

	@Autowired
	ModeloService modeloService;

	@Autowired
	MarcaService marcaService;

	@RequestMapping(path = "/form")
	public ModelAndView modeloForm(@PathVariable Integer idMarca) {
		ModelAndView model = new ModelAndView("forms/modeloForm");
		Modelo modelo = new Modelo();
		Marca marca = marcaService.buscarPorId(idMarca);
		modelo.setMarca(marca);
		
		model.addObject("modelo", modelo);

		return model;
	}

	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarModelo(@PathVariable Integer idMarca, Modelo modelo) {
		ModelAndView model = new ModelAndView("redirect:/marca/");
		modeloService.cadastrarModelo(modelo);
		marcaService.addModeloNaMarca(idMarca, modelo);

		return model;
	}
	
	@GetMapping(path = "/listarModelos")
	public ModelAndView listarModelosDaMarca(@PathVariable Integer idMarca) {
		ModelAndView model = new ModelAndView("modelo");
		List<Modelo> modelos = marcaService.getModelosDaMarca(idMarca);
		model.addObject("modelos", modelos);
		
		return model;
	}
	
	@GetMapping(path = "/{idModelo}/detalharModelo")
	public ModelAndView detalharModelo(@PathVariable Integer idModelo) {
		ModelAndView model = new ModelAndView("appends/modeloDetalhe");
		Modelo modelo = modeloService.buscarPorId(idModelo);
		model.addObject("modelo", modelo);
		
		return model;
	}

	@RequestMapping("{idModelo}")
	public ModelAndView editarModelo(@PathVariable Integer idModelo) {
		Modelo modelo = modeloService.buscarPorId(idModelo);
		ModelAndView model = new ModelAndView("forms/modeloForm");
		model.addObject("modelo", modelo);

		return model;
	}

}
