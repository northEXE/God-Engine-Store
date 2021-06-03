package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/carro/")
public class CarroController {
	
	@RequestMapping(path = "/")
	public String index() {
		return "carro";
	}
	
	@RequestMapping(path = "/carroCadastro/")
	public String carroCadastro() {
		return "carroCadastro";
	}
}
