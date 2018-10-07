package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.ProfesionRepository;
import com.grupofisico.app.core.entity.Profesion;

@RestController
@RequestMapping(value = "/api")
public class ProfesionController {

	@Autowired
	private ProfesionRepository profesionRepository;
	
	@CrossOrigin
	@GetMapping(value = "/profesiones")
	public ResponseEntity<List<Profesion>> getProfesiones() {
		List<Profesion> profesions = (List<Profesion>) profesionRepository.findAll();
		if (profesions.isEmpty()) {
			return new ResponseEntity<List<Profesion>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Profesion>>(profesions, HttpStatus.OK);
	}
}
