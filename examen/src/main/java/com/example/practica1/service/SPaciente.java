package com.example.practica1.service;

import java.util.List;

import com.example.practica1.model.Paciente;

public interface SPaciente {
	Paciente create(Paciente u);
	List<Paciente> readAll();
	Paciente read(Long id);
	void delete(Long id);
	Paciente update(Paciente al);
}
