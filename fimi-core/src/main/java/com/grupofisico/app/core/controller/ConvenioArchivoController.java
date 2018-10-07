package com.grupofisico.app.core.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grupofisico.app.core.dao.ConvenioArchivoRepository;
import com.grupofisico.app.core.entity.ConvenioArchivo;
import com.grupofisico.app.util.GoogleDrive;

@RestController
@RequestMapping(value = "/api")
public class ConvenioArchivoController {

	@Autowired
	private ConvenioArchivoRepository archivoRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/convenioarchivo")
	public ResponseEntity<String> addConvenioArchivo(@RequestParam("file") MultipartFile file) {
		String id = "";
		
		try {
			File archivo = new File(file.getOriginalFilename());
			archivo.createNewFile();
		    FileOutputStream fos = new FileOutputStream(archivo);
		    fos.write(file.getBytes());
		    fos.close();
			GoogleDrive gd = new GoogleDrive();
			id = gd.upload(archivo);
			archivo.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<String>(id, HttpStatus.CREATED);

	}

	@CrossOrigin
	@GetMapping(value = "/convenioarchivo/{id}")
	public OutputStream getArchivo(@PathVariable("id") Long id) {
		OutputStream file = null;
		Optional<ConvenioArchivo> ca = archivoRepository.findById(id);
		if (ca.isPresent()) {
			try {
				GoogleDrive gd = new GoogleDrive();
				file = gd.download(ca.orElseGet(null).getDrive());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}
}
