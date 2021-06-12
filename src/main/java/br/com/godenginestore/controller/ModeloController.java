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

import br.com.godenginestore.model.Marca;
import br.com.godenginestore.model.Modelo;
import br.com.godenginestore.model.Motor;
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
		List<Motor> motores = modeloService.listarMotoresParaCadastroModelo();
		
		model.addObject("modelo", modelo);
		model.addObject("motores", motores);
		

		return model;
	}

	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarModelo(@PathVariable Integer idMarca, @RequestParam Integer idMotor, Modelo modelo) {
		ModelAndView model = new ModelAndView("redirect:/marca/");
		modeloService.cadastrarModelo(modelo);
		modeloService.addModeloNaMarca(idMarca, modelo);
		modeloService.addMotorDoModelo(idMotor, modelo);

		return model;
	}
	
	@PostMapping(path = "/{idModelo}/salvarAlteracoes")
	public ModelAndView salvarAlteracoesModelo(@PathVariable Integer idMarca, @PathVariable Integer idModelo, Modelo modeloModificado) {
		ModelAndView model = new ModelAndView("redirect:/{idMarca}/modelo/listarModelos");
		modeloService.editarModeloNaMarca(idMarca, idModelo, modeloModificado);
		
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

	@RequestMapping("/{idModelo}/editar")
	public ModelAndView editarModelo(@PathVariable Integer idModelo) {
		Modelo modelo = modeloService.buscarPorId(idModelo);
		ModelAndView model = new ModelAndView("constraintEdit/modeloForm");
		model.addObject("modelo", modelo);

		return model;
	}
	
	@RequestMapping(path = "/{idModelo}/excluir")
	public ModelAndView excluirModelo(@PathVariable Integer idMarca, @PathVariable Integer idModelo) {
		modeloService.deleteModeloDaMarca(idMarca, idModelo);
		ModelAndView model = new ModelAndView("redirect:/{idMarca}/modelo/listarModelos");
		
		return model;
	}

}
