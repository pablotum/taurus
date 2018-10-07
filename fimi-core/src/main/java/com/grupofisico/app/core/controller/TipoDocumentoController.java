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

import com.grupofisico.app.core.dao.TipoDocumentoRepository;
import com.grupofisico.app.core.entity.TipoDocumento;

@RestController
@RequestMapping(value = "/api")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoRepository tipoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/tipodocumentos")
	public ResponseEntity<List<TipoDocumento>> getTipoDocumento() {
		List<TipoDocumento> tipodocumentos = (List<TipoDocumento>) tipoRepository.findAll();
		if (tipodocumentos.isEmpty()) {
			return new ResponseEntity<List<TipoDocumento>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<TipoDocumento>>(tipodocumentos, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/tipodocumento/{id}")
	public ResponseEntity<?> getTipoDocumento(@PathVariable("id") long id) {

		
		return new ResponseEntity<Optional<TipoDocumento>>(tipoRepository.findById(id), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/tipodocumento")
	public ResponseEntity<TipoDocumento> addMoneda(@RequestBody TipoDocumento tipodocumento) {
		TipoDocumento flag = tipoRepository.save(tipodocumento);
		if (flag == null) {
			return new ResponseEntity<TipoDocumento>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<TipoDocumento>(tipodocumento, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/tipodocumento/{id}")
	public ResponseEntity<TipoDocumento> deleteMoneda(@PathVariable("id") long id) {
		
		tipoRepository.deleteById(id);
        return new ResponseEntity<TipoDocumento>(HttpStatus.NO_CONTENT);
	}

}
