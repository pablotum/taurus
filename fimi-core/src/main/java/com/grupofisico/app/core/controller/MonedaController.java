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

import com.grupofisico.app.core.dao.MonedaRepository;
import com.grupofisico.app.core.entity.Moneda;

@RestController
@RequestMapping(value = "/api")
public class MonedaController {

	@Autowired
	private MonedaRepository monedaRepository;

	@CrossOrigin
	@GetMapping(value = "/monedas")
	public ResponseEntity<List<Moneda>> getUsuarios() {
		List<Moneda> monedas = (List<Moneda>) monedaRepository.findAll();
		if (monedas.isEmpty()) {
			return new ResponseEntity<List<Moneda>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Moneda>>(monedas, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/moneda/{id}")
	public ResponseEntity<?> getMoneda(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Moneda>>(monedaRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/moneda")
	public ResponseEntity<Moneda> addMoneda(@RequestBody Moneda moneda) {
		Moneda flag = monedaRepository.save(moneda);
		if (flag == null) {
			return new ResponseEntity<Moneda>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Moneda>(moneda, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/moneda/{id}")
	public ResponseEntity<Moneda> deleteMoneda(@PathVariable("id") long id) {
		
		monedaRepository.deleteById(id);
        return new ResponseEntity<Moneda>(HttpStatus.NO_CONTENT);
	}
}
