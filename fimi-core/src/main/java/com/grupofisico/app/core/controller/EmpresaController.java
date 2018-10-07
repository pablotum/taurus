package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.EmpresaRepository;
import com.grupofisico.app.core.entity.Empresa;

@RestController
@RequestMapping(value = "/api")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresa;
	
	@CrossOrigin
	@GetMapping(value = "/empresas")
	public ResponseEntity<List<Empresa>> getUsuarios() {
		List<Empresa> Empresas = (List<Empresa>) empresa.findAll();
		if (Empresas.isEmpty()) {
			return new ResponseEntity<List<Empresa>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Empresa>>(Empresas, HttpStatus.OK);
	}
}
