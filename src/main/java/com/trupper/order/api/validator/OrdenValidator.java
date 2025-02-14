package com.trupper.order.api.validator;

import com.trupper.order.api.entity.Orden;
import com.trupper.order.api.exception.ValidateServicesException;

public class OrdenValidator {
	
	public static void validator(Orden orden) {
		if(orden.getOrdenId()==0) {
			throw new ValidateServicesException("El nombre de la sucursal no existe");
		}
		if(orden.getTotal()<0) {
			throw new ValidateServicesException("EL total debe ser mayor que 0");

		}
	}

}
