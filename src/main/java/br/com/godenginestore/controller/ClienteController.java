package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cliente/")
public class ClienteController {
	
	@RequestMapping(path = "/")
	public String index() {
		return "cliente";
	}
}
