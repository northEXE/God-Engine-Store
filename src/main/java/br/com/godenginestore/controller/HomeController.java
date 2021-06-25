package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home/")
public class HomeController {
	
	@RequestMapping(path = "/")
	public String index() {
		return "home";
	}
}
