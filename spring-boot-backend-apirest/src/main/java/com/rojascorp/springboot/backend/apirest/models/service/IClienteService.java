package com.rojascorp.springboot.backend.apirest.models.service;

import java.util.List;

import com.rojascorp.springboot.backend.apirest.models.entity.Moneda;

public interface IClienteService {
	
	public List<Moneda> listar();
	
	public Moneda buscarPorId(long id);
	
	public Moneda guardar(Moneda moneda);
	
	public void borrar(long id);
}