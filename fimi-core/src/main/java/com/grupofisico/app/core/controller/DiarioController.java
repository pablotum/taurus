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

import com.grupofisico.app.core.dao.DiarioRepository;
import com.grupofisico.app.core.entity.Diario;

@RestController
@RequestMapping(value = "/api")
public class DiarioController {
	
	@Autowired
	private DiarioRepository diarioRepository;
	
	@CrossOrigin
	@GetMapping(value = "/diarios")
	public ResponseEntity<List<Diario>> getDiarios() {
		List<Diario> diarios = (List<Diario>) diarioRepository.findAll();
		if (diarios.isEmpty()) {
			return new ResponseEntity<List<Diario>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Diario>>(diarios, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/diario/{id}")
	public ResponseEntity<?> getDiario(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Diario>>(diarioRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/diario")
	public ResponseEntity<Diario> addDIario(@RequestBody Diario diario) {
		Diario flag = diarioRepository.save(diario);
		if (flag == null) {
			return new ResponseEntity<Diario>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Diario>(diario, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/diario/{id}")
	public ResponseEntity<Diario> deleteDiario(@PathVariable("id") long id) {
		
		diarioRepository.deleteById(id);
        return new ResponseEntity<Diario>(HttpStatus.NO_CONTENT);
	}

}
