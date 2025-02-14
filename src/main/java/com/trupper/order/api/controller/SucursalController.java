package com.trupper.order.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trupper.order.api.converter.SucursalConverter;
import com.trupper.order.api.dto.SucursalDTO;
import com.trupper.order.api.entity.Sucursal;
import com.trupper.order.api.service.SucursalService;
import com.trupper.order.api.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/sucursal")
public class SucursalController {
	
	@Autowired
	private SucursalService service;
	
	@Autowired
	private SucursalConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<SucursalDTO>> findAll(@RequestParam(value = "nombre",required = false,defaultValue = "") String nombre){
		
		List<Sucursal> sucursals;
		if(nombre==null) {
			sucursals = service.findAll();
		}else {
			sucursals = service.findByNombre(nombre);
		}
		List<SucursalDTO> sucursalDTO = converter.fromEntity(sucursals);
		return new WrapperResponse(true,"SUCCESS", sucursalDTO).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<SucursalDTO>> findById(@PathVariable("id") int id){
		Sucursal sucursal = service.findById(id);
		SucursalDTO sucursalDTO = converter.fromEntity(sucursal);
		return new WrapperResponse<SucursalDTO>(true,"SUCCESS", sucursalDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<SucursalDTO> create(@RequestBody SucursalDTO sucursalDTO){
		Sucursal sucursalReg = service.save(converter.fromDTO(sucursalDTO));
		SucursalDTO sucursalRegDTO = converter.fromEntity(sucursalReg);
		return new WrapperResponse(true,"SUCCESS", sucursalRegDTO).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SucursalDTO> update(@PathVariable("id") int id, @RequestBody SucursalDTO sucursalDTO){
		Sucursal sucursalReg = service.save(converter.fromDTO(sucursalDTO));
		SucursalDTO sucursalRegDTO = converter.fromEntity(sucursalReg);
		return new WrapperResponse(true,"SUCCESS", sucursalRegDTO).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SucursalDTO> delete(@PathVariable("id") int id){
		service.delete(id);
		return new WrapperResponse(true,"SUCCESS", null).createResponse(HttpStatus.OK);
	}
}
