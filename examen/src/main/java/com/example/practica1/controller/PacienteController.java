package com.example.practica1.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.practica1.model.Paciente;
import com.example.practica1.serviceImpl.PacienteService;
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

@Autowired
	private PacienteService pacienteservice;
		@PostMapping("/crear")
		public ResponseEntity<Paciente> save(@RequestBody Paciente Paciente) {
			try {
				Paciente u = pacienteservice.create(new Paciente(Paciente.getIdpaciente(), Paciente.getDni(), Paciente.getNombre(), Paciente.getApellidos(), Paciente.getDireccion(),Paciente.getTelefono()));
			    return new ResponseEntity<>(u,HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/listar")
		public ResponseEntity<List<Paciente>> gePost(){
			try {
				List<Paciente> list = new ArrayList<>();
				list = pacienteservice.readAll();
				if(list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list, HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/read/{id}")
		public ResponseEntity<Paciente> getUser(@PathVariable("id") long id){
			Paciente paciente = pacienteservice.read(id);
				if(paciente.getIdpaciente()>0) {
					return new ResponseEntity<>(paciente, HttpStatus.OK);
				}else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} 
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
			try {
				pacienteservice.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@PutMapping("/update/{id}")
		public ResponseEntity<Paciente> update(@RequestBody Paciente paciente, @PathVariable("id") long id){
			try {
				Paciente pp = pacienteservice.read(id);
				if(pp.getIdpaciente()>0) {
					pp.setDni(paciente.getDni());
					pp.setNombre(paciente.getNombre());
					pp.setApellidos(paciente.getApellidos());
					pp.setDireccion(paciente.getDireccion());
					pp.setTelefono(paciente.getTelefono());
					
					return new ResponseEntity<>(pacienteservice.create(pp),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}			

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
