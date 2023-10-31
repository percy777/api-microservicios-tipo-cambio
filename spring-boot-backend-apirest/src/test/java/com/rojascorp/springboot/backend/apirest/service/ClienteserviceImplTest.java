package com.rojascorp.springboot.backend.apirest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rojascorp.springboot.backend.apirest.models.dao.IClienteDao;
import com.rojascorp.springboot.backend.apirest.models.entity.Moneda;
import com.rojascorp.springboot.backend.apirest.models.service.ClienteserviceImpl;

@ExtendWith(MockitoExtension.class)
class ClienteserviceImplTest {
	
	@Mock
    private IClienteDao iClienteDao;
	
	@InjectMocks
    private ClienteserviceImpl clienteserviceImpl;

	@Test
	void testBuscarxId() {
		
		Moneda objetoSimulado = Moneda.builder()
				.id(2L)
				.createAt(null)
				.monedaCambio(3500)
				.monedaDestino("DOLARES")
				.monedaOrigen("SOLES")
				.monto(1000)
				.tipoCambio(3.5).build();
		
		Optional<Moneda> objetoSimulado2 = Optional.of(objetoSimulado);
		
		Moneda esperado = Moneda.builder()
				.id(2L)
				.createAt(null)
				.monedaCambio(3500)
				.monedaDestino("DOLARES")
				.monedaOrigen("SOLES")
				.monto(1000)
				.tipoCambio(3.5).build();
		
		Mockito.when(iClienteDao.findById(2L)).thenReturn(objetoSimulado2);			
		
		Moneda resultado = clienteserviceImpl.buscarPorId(2L);
		
		Assertions.assertEquals(esperado.getMonto(), resultado.getMonto());
		
		Mockito.verify(iClienteDao).findById(2L);
	}

}
