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

import com.grupofisico.app.core.dao.RubroRepository;
import com.grupofisico.app.core.entity.Rubro;

@RestController
@RequestMapping(value = "/api")
public class RubroController {
	
	@Autowired
	private RubroRepository rubroRepository;

	@CrossOrigin
	@GetMapping(value = "/rubros")
	public ResponseEntity<List<Rubro>> getRubros() {
		List<Rubro> rubros = (List<Rubro>) rubroRepository.findAll();
		if (rubros.isEmpty()) {
			return new ResponseEntity<List<Rubro>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Rubro>>(rubros, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/rubro/{id}")
	public ResponseEntity<?> getRubro(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Rubro>>(rubroRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/rubro")
	public ResponseEntity<Rubro> addMoneda(@RequestBody Rubro rubro) {
		Rubro flag = rubroRepository.save(rubro);
		if (flag == null) {
			return new ResponseEntity<Rubro>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Rubro>(rubro, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/rubro/{id}")
	public ResponseEntity<Rubro> deleteMoneda(@PathVariable("id") long id) {
		
		rubroRepository.deleteById(id);
        return new ResponseEntity<Rubro>(HttpStatus.NO_CONTENT);
	}
}
