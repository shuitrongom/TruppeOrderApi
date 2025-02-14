package com.trupper.order.api.validator;

import com.trupper.order.api.entity.Producto;
import com.trupper.order.api.exception.ValidateServicesException;

public class ProductoValidator {

	public static void validator(Producto producto ) {
		if(producto.getOrdenId()==0) {
			throw new ValidateServicesException("No existe una orden activa");
		}
		if(producto.getCodigo()== null || producto.getCodigo().isEmpty()) {
			throw new ValidateServicesException("El codigo es requerido");
		}
		if(producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
			throw new ValidateServicesException("La descripcion es requerida");
		}
		if(producto.getPrecio()<0) {
			throw new ValidateServicesException("El precio debe ser mayor que 0");

		}
	}
}
