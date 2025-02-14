package com.trupper.order.api.converter;

import org.springframework.stereotype.Component;

import com.trupper.order.api.dto.OrdenDTO;
import com.trupper.order.api.entity.Orden;

@Component
public class OrdenConverter extends AbstracConvert<Orden, OrdenDTO> {

	@Override
	public OrdenDTO fromEntity(Orden entity) {
		if(entity==null) return null;
		return OrdenDTO.builder()
				.sucursalId(entity.getSucursalId())
				.fecha(entity.getFecha())
				.total(entity.getTotal())
				.build();
	}

	@Override
	public Orden fromDTO(OrdenDTO dto) {
		if(dto==null) return null;
		return Orden.builder()
				.sucursalId(dto.getSucursalId())
				.fecha(dto.getFecha())
				.total(dto.getTotal())
				.build();
	}
	
}
