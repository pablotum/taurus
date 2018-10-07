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

import com.grupofisico.app.core.dao.ContactoRepository;
import com.grupofisico.app.core.entity.Contacto;

@RestController
@RequestMapping(value = "/api")
public class ContactoController {

	@Autowired
	private ContactoRepository contactoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/contactos")
	public ResponseEntity<List<Contacto>> getContactos() {
		List<Contacto> contactos = (List<Contacto>) contactoRepository.findAll();
		if (contactos.isEmpty()) {
			return new ResponseEntity<List<Contacto>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Contacto>>(contactos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/contacto/{id}")
	public ResponseEntity<?> getContacto(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<Contacto>>(contactoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/contacto")
	public ResponseEntity<Contacto> addMoneda(@RequestBody Contacto contacto) {
		Contacto flag = contactoRepository.save(contacto);
		if (flag == null) {
			return new ResponseEntity<Contacto>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Contacto>(contacto, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/contacto/{id}")
	public ResponseEntity<Contacto> deleteMoneda(@PathVariable("id") long id) {
		
		contactoRepository.deleteById(id);
        return new ResponseEntity<Contacto>(HttpStatus.NO_CONTENT);
	}

}
