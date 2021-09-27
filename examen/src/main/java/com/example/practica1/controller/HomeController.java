package com.example.practica1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
@GetMapping("/")
public String mensaje() {
	return "Bienvenidos al Crud de PACIENTE";
	
}
}