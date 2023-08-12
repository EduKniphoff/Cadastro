package br.com.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AplicaçãoController {
	
	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	
}
