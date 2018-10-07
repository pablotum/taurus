package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.SexoRepository;
import com.grupofisico.app.core.entity.Sexo;

@RestController
@RequestMapping(value = "/api")
public class SexoController {

	@Autowired
	private SexoRepository sexoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/sexos")
	public ResponseEntity<List<Sexo>> getSexos() {
		List<Sexo> sexos = (List<Sexo>) sexoRepository.findAll();
		if (sexos.isEmpty()) {
			return new ResponseEntity<List<Sexo>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Sexo>>(sexos, HttpStatus.OK);
	}
}
