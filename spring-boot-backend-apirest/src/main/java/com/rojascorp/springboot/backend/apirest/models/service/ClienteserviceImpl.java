package com.rojascorp.springboot.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rojascorp.springboot.backend.apirest.models.dao.IClienteDao;
import com.rojascorp.springboot.backend.apirest.models.entity.Moneda;
import com.rojascorp.springboot.backend.apirest.models.util.ITipoCambio;
import com.rojascorp.springboot.backend.apirest.models.util.Utilitario;

import jakarta.transaction.Transactional;

@Service
public class ClienteserviceImpl implements IClienteService, ITipoCambio {

	@Autowired
	private IClienteDao iClienteDao; 
	
	@Override
	@Transactional
	public List<Moneda> listar() {
		// TODO Auto-generated method stub
		return (List<Moneda>) iClienteDao.findAll();
	}

	@Override
	@Transactional
	public Moneda buscarPorId(long id) {
		// TODO Auto-generated method stub
		return iClienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Moneda guardar(Moneda moneda) {
		// TODO Auto-generated method stub
		Moneda monedas = new Moneda();
		monedas = this.realizarCambioDivisa(moneda);
		monedas = iClienteDao.save(moneda);
		return monedas;
	}

	@Override
	@Transactional
	public void borrar(long id) {
		// TODO Auto-generated method stub
		iClienteDao.deleteById(id);
	}

	@Override
	@Transactional
	public Moneda realizarCambioDivisa(Moneda moneda) {
		// TODO Auto-generated method stub
		double montoCambiado = 0;
		double tipoCambio = 0;
		
		List<Moneda> tiposCambio = (List<Moneda>) iClienteDao.findAll();
		
		
		    if(Utilitario.SOL.equalsIgnoreCase(moneda.getMonedaDestino())) {
				
				tipoCambio = tiposCambio.stream()
									.filter(tipo -> Utilitario.SOL.equalsIgnoreCase(tipo.getMonedaDestino()))
							        .findFirst()
							        .map(Moneda::getTipoCambio)
							        .orElse(tipoCambio);
		    	montoCambiado = moneda.getMonto() * tipoCambio;
				
				
			}else if(Utilitario.USD.equalsIgnoreCase(moneda.getMonedaDestino())) {
				
				tipoCambio = tiposCambio.stream()
									.filter(tipo -> Utilitario.USD.equalsIgnoreCase(tipo.getMonedaDestino()))
							        .findFirst()
							        .map(Moneda::getTipoCambio)
							        .orElse(tipoCambio);
				montoCambiado = moneda.getMonto()*tipoCambio;
				
			}else if(Utilitario.EUR.equalsIgnoreCase(moneda.getMonedaDestino())) {
				tipoCambio = tiposCambio.stream()
									.filter(tipo -> Utilitario.EUR.equalsIgnoreCase(tipo.getMonedaDestino()))
							        .findFirst()
							        .map(Moneda::getTipoCambio)
							        .orElse(tipoCambio);
				montoCambiado = moneda.getMonto()*tipoCambio;
			}else if(Utilitario.YEN.equalsIgnoreCase(moneda.getMonedaDestino())) {
				tipoCambio = tiposCambio.stream()
									.filter(tipo -> Utilitario.YEN.equalsIgnoreCase(tipo.getMonedaDestino()))
							        .findFirst()
							        .map(Moneda::getTipoCambio)
							        .orElse(tipoCambio);
				montoCambiado = moneda.getMonto()*tipoCambio;
			}
			
		moneda.setMonedaCambio(montoCambiado);
		moneda.setTipoCambio(tipoCambio);
		
		return moneda;
	}

}
