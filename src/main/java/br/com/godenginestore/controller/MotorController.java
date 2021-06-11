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
import br.com.godenginestore.model.Motor;
import br.com.godenginestore.services.MarcaService;
import br.com.godenginestore.services.MotorService;

@Controller
@RequestMapping(path = "/{idMarca}/motor/")
public class MotorController {

	@Autowired
	MarcaService marcaService;

	@Autowired
	MotorService motorService;

	@RequestMapping(path = "/form")
	public ModelAndView motorForm(@PathVariable Integer idMarca) {
		ModelAndView model = new ModelAndView("forms/motorForm");
		Motor motor = new Motor();
		Marca marca = marcaService.buscarPorId(idMarca);
		motor.setFabricante(marca);

		model.addObject("motor", motor);
		return model;
	}

	@PostMapping(path = "/cadastrar")
	public ModelAndView cadastrarMotor(@PathVariable Integer idMarca, Motor motor) {
		ModelAndView model = new ModelAndView("redirect:/marca/");
		motorService.cadastrarMotor(motor);
		motorService.addMotorNaMarca(idMarca, motor);

		return model;
	}

	@GetMapping(path = "/listarMotores-Marca")
	public ModelAndView listarMotoresDaMarca(@PathVariable Integer idMarca) {
		ModelAndView model = new ModelAndView("motor");
		List<Motor> motores = motorService.getMotoresDaMarca(idMarca);
		model.addObject("motores", motores);

		return model;
	}
	
	@GetMapping(path = "{idMotor}/detalharMotor")
	public ModelAndView detalharMotor(@PathVariable Integer idMotor) {
		ModelAndView model = new ModelAndView("appends/motorDetalhe");
		Motor motor = motorService.buscarMotorPorId(idMotor);
		model.addObject("motor", motor);
		
		return model;
	}
	
}
