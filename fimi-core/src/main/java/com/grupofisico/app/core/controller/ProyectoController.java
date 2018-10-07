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

import com.grupofisico.app.core.dao.ProyectoRepository;
import com.grupofisico.app.core.entity.Proyecto;

@RestController
@RequestMapping(value = "/api")
public class ProyectoController {
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/proyectos")
	public ResponseEntity<List<Proyecto>> getProyectos() {
		List<Proyecto> proyectos = (List<Proyecto>) proyectoRepository.findAll();
		if (proyectos.isEmpty()) {
			return new ResponseEntity<List<Proyecto>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Proyecto>>(proyectos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/proyecto/{id}")
	public ResponseEntity<?> getProyecto(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Proyecto>>(proyectoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/proyecto")
	public ResponseEntity<Proyecto> addMoneda(@RequestBody Proyecto proyecto) {
		Proyecto flag = proyectoRepository.save(proyecto);
		if (flag == null) {
			return new ResponseEntity<Proyecto>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/proyecto/{id}")
	public ResponseEntity<Proyecto> deleteMoneda(@PathVariable("id") long id) {
		
		proyectoRepository.deleteById(id);
        return new ResponseEntity<Proyecto>(HttpStatus.NO_CONTENT);
	}

}
