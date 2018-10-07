package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.EstadoCivilRepository;
import com.grupofisico.app.core.entity.EstadoCivil;

@RestController
@RequestMapping(value = "/api")
public class EstadoCivilController {

	@Autowired
	private EstadoCivilRepository estadoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/estados")
	public ResponseEntity<List<EstadoCivil>> getEstadoCivil() {
		List<EstadoCivil> estados = (List<EstadoCivil>) estadoRepository.findAll();
		if (estados.isEmpty()) {
			return new ResponseEntity<List<EstadoCivil>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<EstadoCivil>>(estados, HttpStatus.OK);
	}
	
	
	
}
