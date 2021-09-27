package com.example.practica1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica1.model.Paciente;
import com.example.practica1.repository.PacienteRepository;
import com.example.practica1.service.SPaciente;

@Service
public class PacienteService implements SPaciente{

@Autowired
	private PacienteRepository pacienteRepository;

@Override
public Paciente create(Paciente u) {
	// TODO Auto-generated method stub
	return pacienteRepository.save(u);
}

@Override
public List<Paciente> readAll() {
	// TODO Auto-generated method stub
	return pacienteRepository.findAll();
}

@Override
public Paciente read(Long id) {
	// TODO Auto-generated method stub
	return pacienteRepository.findById(id).get();
}

@Override
public void delete(Long id) {
	// TODO Auto-generated method stub
	pacienteRepository.deleteById(id);
}

@Override
public Paciente update(Paciente al) {
	// TODO Auto-generated method stub
	return pacienteRepository.save(al);
}

}
