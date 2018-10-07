package com.grupofisico.app.core.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.grupofisico.app.core.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByUsuario(String usuario);

}
