package com.rojascorp.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rojascorp.springboot.backend.apirest.models.entity.Moneda;

public interface IClienteDao extends CrudRepository<Moneda, Long>{

}
