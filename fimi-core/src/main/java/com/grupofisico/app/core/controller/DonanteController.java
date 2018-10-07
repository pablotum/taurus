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

import com.grupofisico.app.core.dao.DonanteRepository;
import com.grupofisico.app.core.entity.Donante;

@RestController
@RequestMapping(value = "/api")
public class DonanteController {

	@Autowired
	private DonanteRepository donanteRepository;
	
	@CrossOrigin
	@GetMapping(value = "/donantes")
	public ResponseEntity<List<Donante>> getDonantes() {
		List<Donante> donantes = (List<Donante>) donanteRepository.findAll();
		if (donantes.isEmpty()) {
			return new ResponseEntity<List<Donante>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Donante>>(donantes, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/donante/{id}")
	public ResponseEntity<?> getDonante(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Donante>>(donanteRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/donante")
	public ResponseEntity<Donante> addMoneda(@RequestBody Donante donante) {
		Donante flag = donanteRepository.save(donante);
		if (flag == null) {
			return new ResponseEntity<Donante>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Donante>(donante, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/donante/{id}")
	public ResponseEntity<Donante> deleteMoneda(@PathVariable("id") long id) {
		
		donanteRepository.deleteById(id);
        return new ResponseEntity<Donante>(HttpStatus.NO_CONTENT);
	}
}
