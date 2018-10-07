package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.PaisRepository;
import com.grupofisico.app.core.entity.Pais;

@RestController
@RequestMapping(value = "/api")
public class PaisController  {
	
	@Autowired
	private PaisRepository pais;
	
	@CrossOrigin
	@GetMapping(value = "/paises")
	public ResponseEntity<List<Pais>> getPaises() {
		List<Pais> paises = (List<Pais>) pais.findAll();
		if (paises.isEmpty()) {
			return new ResponseEntity<List<Pais>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	}

	
}
