package com.grupofisico.app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupofisico.app.core.dao.UsuarioRepository;
import com.grupofisico.app.core.entity.Usuario;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuario;

	@CrossOrigin
	@GetMapping(value = "/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> Usuarios = (List<Usuario>) usuario.findAll();
		if (Usuarios.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Usuario>>(Usuarios, HttpStatus.OK);
	}

}
