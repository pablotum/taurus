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

import com.grupofisico.app.core.dao.ClasificacionCuentaRepository;
import com.grupofisico.app.core.entity.ClasificacionCuenta;

@RestController
@RequestMapping(value = "/api")
public class ClasificacionCuentaController {

	@Autowired
	private ClasificacionCuentaRepository clasificacionRepository;
	
	@CrossOrigin
	@GetMapping(value = "/clasificacioncuentas")
	public ResponseEntity<List<ClasificacionCuenta>> getClasificacion() {
		List<ClasificacionCuenta> clasificacioncuentas = (List<ClasificacionCuenta>) clasificacionRepository.findAll();
		if (clasificacioncuentas.isEmpty()) {
			return new ResponseEntity<List<ClasificacionCuenta>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<ClasificacionCuenta>>(clasificacioncuentas, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/clasificacioncuenta/{id}")
	public ResponseEntity<?> getClasificacionCuenta(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<ClasificacionCuenta>>(clasificacionRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/clasificacioncuenta")
	public ResponseEntity<ClasificacionCuenta> addClasificacionCuenta(@RequestBody ClasificacionCuenta clasificacioncuenta) {
		ClasificacionCuenta flag = clasificacionRepository.save(clasificacioncuenta);
		if (flag == null) {
			return new ResponseEntity<ClasificacionCuenta>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<ClasificacionCuenta>(clasificacioncuenta, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/clasificacioncuenta/{id}")
	public ResponseEntity<ClasificacionCuenta> deleteClasificacionCuenta(@PathVariable("id") long id) {
		
		clasificacionRepository.deleteById(id);
        return new ResponseEntity<ClasificacionCuenta>(HttpStatus.NO_CONTENT);
	}
}
