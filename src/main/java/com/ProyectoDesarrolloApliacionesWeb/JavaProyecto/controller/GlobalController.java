package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {
	@ModelAttribute
	public void addTitle(Model model) {
		model.addAttribute("title", "Proyecto Java Final");
	}
}
