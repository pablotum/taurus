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

import com.grupofisico.app.core.dao.CuentaContableRepository;
import com.grupofisico.app.core.entity.CuentaContable;

@RestController
@RequestMapping(value = "/api")
public class CuentaContableController {

	@Autowired
	private CuentaContableRepository cuentaContableRepository;
	
	@CrossOrigin
	@GetMapping(value = "/cuentascontables")
	public ResponseEntity<List<CuentaContable>> getCuentaContable() {
		List<CuentaContable> cuentas = (List<CuentaContable>) cuentaContableRepository.findAll();
		if (cuentas.isEmpty()) {
			return new ResponseEntity<List<CuentaContable>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<CuentaContable>>(cuentas, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/cuentacontable/{id}")
	public ResponseEntity<?> getCuentaContable(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<CuentaContable>>(cuentaContableRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/cuentacontable")
	public ResponseEntity<CuentaContable> addMoneda(@RequestBody CuentaContable cuenta) {
		CuentaContable flag = cuentaContableRepository.save(cuenta);
		if (flag == null) {
			return new ResponseEntity<CuentaContable>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<CuentaContable>(cuenta, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/cuentacontable/{id}")
	public ResponseEntity<CuentaContable> deleteMoneda(@PathVariable("id") long id) {
		
		cuentaContableRepository.deleteById(id);
        return new ResponseEntity<CuentaContable>(HttpStatus.NO_CONTENT);
	}
}
