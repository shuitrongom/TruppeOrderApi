package com.trupper.order.api.validator;

import com.trupper.order.api.entity.Sucursal;
import com.trupper.order.api.exception.ValidateServicesException;

public class SucursalValidator {
	
	public static void validator(Sucursal sucursal) {
		if(sucursal.getNombre()==null || sucursal.getNombre().isEmpty()) {
			throw new ValidateServicesException("El nombre es reqerido");
		}
		if(sucursal.getNombre().length()>50) {
			throw new ValidateServicesException("El nombre de la sucursal es muy grande");
		}
	}

}
