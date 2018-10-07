package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.UsoCuentaRepository;
import com.grupofisico.app.core.entity.UsoCuenta;

@RestController
@RequestMapping(value = "/api")
public class UsoCuentaController {

	@Autowired
	private UsoCuentaRepository usoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/usoscuenta")
	public ResponseEntity<List<UsoCuenta>> getUso() {
		List<UsoCuenta> uso = (List<UsoCuenta>) usoRepository.findAll();
		if (uso.isEmpty()) {
			return new ResponseEntity<List<UsoCuenta>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<UsoCuenta>>(uso, HttpStatus.OK);
	}
}
