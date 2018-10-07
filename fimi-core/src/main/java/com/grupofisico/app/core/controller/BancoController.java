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

import com.grupofisico.app.core.dao.BancoRepository;
import com.grupofisico.app.core.entity.Banco;

@RestController
@RequestMapping(value = "/api")
public class BancoController {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/bancos")
	public ResponseEntity<List<Banco>> getBancos() {
		List<Banco> bancos = (List<Banco>) bancoRepository.findAll();
		if (bancos.isEmpty()) {
			return new ResponseEntity<List<Banco>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Banco>>(bancos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/banco/{id}")
	public ResponseEntity<?> getBanco(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Banco>>(bancoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/banco")
	public ResponseEntity<Banco> addMoneda(@RequestBody Banco banco) {
		Banco flag = bancoRepository.save(banco);
		if (flag == null) {
			return new ResponseEntity<Banco>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Banco>(banco, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/banco/{id}")
	public ResponseEntity<Banco> deleteMoneda(@PathVariable("id") long id) {
		
		bancoRepository.deleteById(id);
        return new ResponseEntity<Banco>(HttpStatus.NO_CONTENT);
	}

}
