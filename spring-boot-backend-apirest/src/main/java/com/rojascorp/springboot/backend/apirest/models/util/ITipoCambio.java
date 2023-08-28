package com.rojascorp.springboot.backend.apirest.models.util;

import com.rojascorp.springboot.backend.apirest.models.entity.Moneda;

public interface ITipoCambio {

	Moneda realizarCambioDivisa(Moneda moneda);
}
