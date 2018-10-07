package com.grupofisico.app.core.dao;

import org.springframework.data.repository.CrudRepository;

import com.grupofisico.app.core.entity.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
