package com.grupofisico.app.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.grupofisico.app.core.entity.ConvenioActividad;

public interface ConvenioActividadRepository extends CrudRepository<ConvenioActividad, Long> {

	@Query("SELECT p FROM ConvenioActividad p where cast(p.fecha as date) between cast(now() as date)-15 and cast(now() as date)+15")
    public List<ConvenioActividad> actividades();
}
