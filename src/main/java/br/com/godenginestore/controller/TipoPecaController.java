package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/tipoPeca/")
public class TipoPecaController {
	
	@RequestMapping(path = "/")
	public String index() {
		return "tipoPeca";
	}
}
