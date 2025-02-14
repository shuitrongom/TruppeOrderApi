package com.trupper.order.api.converter;

import org.springframework.stereotype.Component;

import com.trupper.order.api.dto.SucursalDTO;
import com.trupper.order.api.entity.Sucursal;

@Component
public class SucursalConverter extends AbstracConvert<Sucursal, SucursalDTO> {

	@Override
	public SucursalDTO fromEntity(Sucursal entity) {
		if(entity==null) return null;
		return SucursalDTO.builder()
				.sucursalId(entity.getSucursalId())
				.nombre(entity.getNombre())
				.build();
	}

	@Override
	public Sucursal fromDTO(SucursalDTO dto) {
		if(dto==null) return null;
		return Sucursal.builder()
				.sucursalId(dto.getSucursalId())
				.nombre(dto.getNombre())
				.build();
	}

}
