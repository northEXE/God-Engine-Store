package br.com.godenginestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/motor/")
public class MotorController {

	@RequestMapping(path = "/")
	public String index() {
		return "motor";
	}
}
