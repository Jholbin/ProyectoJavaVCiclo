package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Product;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String frmLogin(Model model) {
		model.addAttribute("subTitle", "Iniciar sesión");
		model.addAttribute("style", "../../css/style.css");
		
		Product objPro = new Product();
		model.addAttribute("objPro", objPro);
		
		return "user/login";
	}
	
}
