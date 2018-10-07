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

import com.grupofisico.app.core.dao.PeriodoRepository;
import com.grupofisico.app.core.entity.Periodo;

@RestController
@RequestMapping(value = "/api")
public class PeriodoDetalle {
	@Autowired
	private PeriodoRepository periodoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/periodos")
	public ResponseEntity<List<Periodo>> getPeriodos() {
		List<Periodo> periodos = (List<Periodo>) periodoRepository.findAll();
		if (periodos.isEmpty()) {
			return new ResponseEntity<List<Periodo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Periodo>>(periodos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/periodo/{id}")
	public ResponseEntity<?> getPeriodo(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Periodo>>(periodoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/periodo")
	public ResponseEntity<Periodo> addPeriodo(@RequestBody Periodo periodo) {
		Periodo flag = periodoRepository.save(periodo);
		if (flag == null) {
			return new ResponseEntity<Periodo>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Periodo>(periodo, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/periodo/{id}")
	public ResponseEntity<Periodo> deletePeriodo(@PathVariable("id") long id) {
		
		periodoRepository.deleteById(id);
        return new ResponseEntity<Periodo>(HttpStatus.NO_CONTENT);
	}

}
