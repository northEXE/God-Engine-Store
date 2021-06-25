package br.com.godenginestore.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin/")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@RequestMapping(path = "/")
	public String adminIndex() {
		return "adminIndex";
	}
}
