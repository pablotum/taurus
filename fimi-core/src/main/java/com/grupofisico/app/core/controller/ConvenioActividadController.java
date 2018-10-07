package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.ConvenioActividadRepository;
import com.grupofisico.app.core.entity.ConvenioActividad;

@RestController
@RequestMapping(value = "/api")
public class ConvenioActividadController {

	@Autowired
	private ConvenioActividadRepository actividadRepository;
	
	@CrossOrigin
	@GetMapping(value = "/actividades")
	public ResponseEntity<List<ConvenioActividad>> getConvenios() {
		List<ConvenioActividad> convenios = (List<ConvenioActividad>) actividadRepository.actividades();
		if (convenios.isEmpty()) {
			return new ResponseEntity<List<ConvenioActividad>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ConvenioActividad>>(convenios, HttpStatus.OK);
	}
}
