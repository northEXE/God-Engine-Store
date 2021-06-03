package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/peca/")
public class PecaController {

	@RequestMapping(path = "/")
	public String index() {
		return "peca";
	}
}
