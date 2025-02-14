package com.trupper.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
	
	private int productoId;
	private int ordenId;
	private String codigo;
	private String descripcion;
	private float precio;

}
