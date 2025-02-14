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

import com.trupper.order.api.converter.OrdenConverter;
import com.trupper.order.api.dto.OrdenDTO;
import com.trupper.order.api.dto.SucursalDTO;
import com.trupper.order.api.entity.Orden;
import com.trupper.order.api.service.OrdenService;
import com.trupper.order.api.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/orden")
public class OrdenController {
	
	@Autowired
	private OrdenService service;
	
	@Autowired
	private OrdenConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<OrdenDTO>> findAll(@RequestParam(value = "ordenId",required = false,defaultValue = "") Integer ordenId,
			@RequestParam(value = "sucursalId",required = false,defaultValue = "") Integer sucursalId){
		
		List<Orden> ordens;
		if(ordenId==null && sucursalId==null) {
			ordens = service.findAll();
		}else if(ordenId==null){
			ordens = service.findBySucursalId(sucursalId);
		}else {
			ordens = service.findByOrdenId(ordenId);
		}
		List<OrdenDTO> ordenDTO = converter.fromEntity(ordens);
		return new WrapperResponse(true,"SUCCESS", ordenDTO).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<OrdenDTO>> findById(@PathVariable("id") int id){
		Orden orden = service.findById(id);
		OrdenDTO ordenDTO = converter.fromEntity(orden);
		return new WrapperResponse<OrdenDTO>(true,"SUCCESS", ordenDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<OrdenDTO> create(@RequestBody OrdenDTO ordenDTO){
		Orden ordenReg = service.save(converter.fromDTO(ordenDTO));
		OrdenDTO ordenRegDTO = converter.fromEntity(ordenReg);
		return new WrapperResponse(true,"SUCCESS", ordenRegDTO).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<OrdenDTO> update(@PathVariable("id") int id, @RequestBody OrdenDTO ordenDTO){
		Orden ordenReg = service.save(converter.fromDTO(ordenDTO));
		OrdenDTO ordenRegDTO = converter.fromEntity(ordenReg);
		return new WrapperResponse(true,"SUCCESS", ordenRegDTO).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<OrdenDTO> delete(@PathVariable("id") int id){
		service.delete(id);
		return new WrapperResponse(true,"SUCCESS", null).createResponse(HttpStatus.OK);
	}

}
