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

import com.grupofisico.app.core.dao.PuestoRepository;
import com.grupofisico.app.core.entity.Puesto;

@RestController
@RequestMapping(value = "/api")
public class PuestoController {

	@Autowired
	private PuestoRepository puestoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/puestos")
	public ResponseEntity<List<Puesto>> getPuestos() {
		List<Puesto> puestos = (List<Puesto>) puestoRepository.findAll();
		if (puestos.isEmpty()) {
			return new ResponseEntity<List<Puesto>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Puesto>>(puestos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/puesto/{id}")
	public ResponseEntity<?> getPuesto(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Puesto>>(puestoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/puesto")
	public ResponseEntity<Puesto> addMoneda(@RequestBody Puesto puesto) {
		Puesto flag = puestoRepository.save(puesto);
		if (flag == null) {
			return new ResponseEntity<Puesto>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Puesto>(puesto, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/puesto/{id}")
	public ResponseEntity<Puesto> deleteMoneda(@PathVariable("id") long id) {
		
		puestoRepository.deleteById(id);
        return new ResponseEntity<Puesto>(HttpStatus.NO_CONTENT);
	}
}
