package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.FlujoCuentaRepository;
import com.grupofisico.app.core.entity.FlujoCuenta;

@RestController
@RequestMapping(value = "/api")
public class FlujoCuentaController {


	@Autowired
	private FlujoCuentaRepository flujoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/flujoscuenta")
	public ResponseEntity<List<FlujoCuenta>> getUsuarios() {
		List<FlujoCuenta> flujo = (List<FlujoCuenta>) flujoRepository.findAll();
		if (flujo.isEmpty()) {
			return new ResponseEntity<List<FlujoCuenta>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<FlujoCuenta>>(flujo, HttpStatus.OK);
	}
}
