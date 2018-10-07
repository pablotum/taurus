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

import com.grupofisico.app.core.dao.ConvenioRepository;
import com.grupofisico.app.core.entity.Convenio;

@RestController
@RequestMapping(value = "/api")
public class ConvenioController {
	
	@Autowired
	private ConvenioRepository convenioRepositoy;
	
	@CrossOrigin
	@GetMapping(value = "/convenios")
	public ResponseEntity<List<Convenio>> getConvenios() {
		List<Convenio> convenios = (List<Convenio>) convenioRepositoy.findAll();
		if (convenios.isEmpty()) {
			return new ResponseEntity<List<Convenio>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Convenio>>(convenios, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/convenio/{id}")
	public ResponseEntity<?> getConvenio(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Convenio>>(convenioRepositoy.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/convenio")
	public ResponseEntity<Convenio> addConvenio(@RequestBody Convenio convenio) {
		Convenio flag = convenioRepositoy.save(convenio);
		if (flag == null) {
			return new ResponseEntity<Convenio>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Convenio>(convenio, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/convenio/{id}")
	public ResponseEntity<Convenio> deleteConvenio(@PathVariable("id") long id) {
		
		convenioRepositoy.deleteById(id);
        return new ResponseEntity<Convenio>(HttpStatus.NO_CONTENT);
	}

}
