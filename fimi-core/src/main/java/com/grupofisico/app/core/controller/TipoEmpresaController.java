package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.TipoEmpresaRepository;
import com.grupofisico.app.core.entity.TipoEmpresa;

@RestController
@RequestMapping(value = "/api")
public class TipoEmpresaController {
	@Autowired
	private TipoEmpresaRepository tipoEmpresaRepository; 

	@CrossOrigin
	@GetMapping(value = "/tiposempresa")
	public ResponseEntity<List<TipoEmpresa>> getTiposEmpresa() {
		List<TipoEmpresa> tiposEmpresa = (List<TipoEmpresa>) tipoEmpresaRepository.findAll();
		if (tiposEmpresa.isEmpty()) {
			return new ResponseEntity<List<TipoEmpresa>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<TipoEmpresa>>(tiposEmpresa, HttpStatus.OK);
	}
}
