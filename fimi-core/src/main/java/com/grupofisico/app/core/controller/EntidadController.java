package com.grupofisico.app.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.EntidadRepository;
import com.grupofisico.app.core.entity.Entidad;

@RestController
@RequestMapping(value = "/api")
public class EntidadController {
	@Autowired
	private EntidadRepository entidadRepository;
	
	@CrossOrigin
	@GetMapping(value = "/entidades")
	public ResponseEntity<List<Entidad>> getEntidades() {
		List<Entidad> entidads = (List<Entidad>) entidadRepository.findAll();
		if (entidads.isEmpty()) {
			return new ResponseEntity<List<Entidad>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Entidad>>(entidads, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/entidad/{id}")
	public ResponseEntity<?> getEntidad(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Entidad>>(entidadRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/entidad")
	public ResponseEntity<Entidad> addMoneda(@RequestBody Entidad entidad) {
		Entidad flag = entidadRepository.save(entidad);
		if (flag == null) {
			return new ResponseEntity<Entidad>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Entidad>(entidad, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/entidad/{id}")
	public ResponseEntity<Entidad> deleteMoneda(@PathVariable("id") long id) {
		
		entidadRepository.deleteById(id);
        return new ResponseEntity<Entidad>(HttpStatus.NO_CONTENT);
	}

}
