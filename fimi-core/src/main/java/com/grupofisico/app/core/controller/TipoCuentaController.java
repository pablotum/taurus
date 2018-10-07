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

import com.grupofisico.app.core.dao.TipoCuentaRepository;
import com.grupofisico.app.core.entity.TipoCuenta;


@RestController
@RequestMapping(value = "/api")
public class TipoCuentaController {

	@Autowired
	private TipoCuentaRepository tipoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/tipocuentas")
	public ResponseEntity<List<TipoCuenta>> getTipoCuentas() {
		List<TipoCuenta> tipocuentas = (List<TipoCuenta>) tipoRepository.findAll();
		if (tipocuentas.isEmpty()) {
			return new ResponseEntity<List<TipoCuenta>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<TipoCuenta>>(tipocuentas, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/tipocuenta/{id}")
	public ResponseEntity<?> getTipoCuenta(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<TipoCuenta>>(tipoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/tipocuenta")
	public ResponseEntity<TipoCuenta> addTipoCuenta(@RequestBody TipoCuenta tipocuenta) {
		TipoCuenta flag = tipoRepository.save(tipocuenta);
		if (flag == null) {
			return new ResponseEntity<TipoCuenta>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<TipoCuenta>(tipocuenta, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/tipocuenta/{id}")
	public ResponseEntity<TipoCuenta> deleteTipoCuenta(@PathVariable("id") long id) {
		
		tipoRepository.deleteById(id);
        return new ResponseEntity<TipoCuenta>(HttpStatus.NO_CONTENT);
	}
}
