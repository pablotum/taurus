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

import com.grupofisico.app.core.dao.CuentaBancariaRepository;
import com.grupofisico.app.core.entity.CuentaBancaria;

@RestController
@RequestMapping(value = "/api")
public class CuentaBancariaController {

	@Autowired
	private CuentaBancariaRepository cuentaRepository;
	
	@CrossOrigin
	@GetMapping(value = "/cuentabancarias")
	public ResponseEntity<List<CuentaBancaria>> getCuentaBancarias() {
		List<CuentaBancaria> cuentabancarias = (List<CuentaBancaria>) cuentaRepository.findAll();
		if (cuentabancarias.isEmpty()) {
			return new ResponseEntity<List<CuentaBancaria>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<CuentaBancaria>>(cuentabancarias, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/cuentabancaria/{id}")
	public ResponseEntity<?> getCuentaBancaria(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<CuentaBancaria>>(cuentaRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/cuentabancaria")
	public ResponseEntity<CuentaBancaria> addCuentaBancaria(@RequestBody CuentaBancaria cuentabancaria) {
		CuentaBancaria flag = cuentaRepository.save(cuentabancaria);
		if (flag == null) {
			return new ResponseEntity<CuentaBancaria>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<CuentaBancaria>(cuentabancaria, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/cuentabancaria/{id}")
	public ResponseEntity<CuentaBancaria> deleteCuentaBancaria(@PathVariable("id") long id) {
		
		cuentaRepository.deleteById(id);
        return new ResponseEntity<CuentaBancaria>(HttpStatus.NO_CONTENT);
	}
}
