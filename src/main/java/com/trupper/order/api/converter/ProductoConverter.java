package com.trupper.order.api.converter;

import org.springframework.stereotype.Component;

import com.trupper.order.api.dto.ProductoDTO;
import com.trupper.order.api.entity.Producto;

@Component
public class ProductoConverter extends AbstracConvert<Producto, ProductoDTO> {

	@Override
	public ProductoDTO fromEntity(Producto entity) {
		if(entity==null) return null;
		return ProductoDTO.builder()
				.productoId(entity.getProductoId())
				.ordenId(entity.getOrdenId())
				.codigo(entity.getCodigo())
				.descripcion(entity.getDescripcion())
				.precio(entity.getPrecio())
				.build();
	}

	@Override
	public Producto fromDTO(ProductoDTO dto) {
		if(dto==null) return null;
		return Producto.builder()
				.productoId(dto.getProductoId())
				.ordenId(dto.getOrdenId())
				.codigo(dto.getCodigo())
				.descripcion(dto.getDescripcion())
				.precio(dto.getPrecio())
				.build();
	}

}
