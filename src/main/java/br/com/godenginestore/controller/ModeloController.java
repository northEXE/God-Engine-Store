package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/modelo/")
public class ModeloController {

	@RequestMapping(path = "/")
	public String index() {
		return "modelo";
	}
}
