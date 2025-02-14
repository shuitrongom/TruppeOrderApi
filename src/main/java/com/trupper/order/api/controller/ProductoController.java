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

import com.trupper.order.api.converter.ProductoConverter;
import com.trupper.order.api.dto.ProductoDTO;
import com.trupper.order.api.entity.Producto;
import com.trupper.order.api.service.ProductoService;
import com.trupper.order.api.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@Autowired
	private ProductoConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<ProductoDTO>> findAll(@RequestParam(value = "productoId",required = false,defaultValue = "") Integer productoId,
			@RequestParam(value = "ordenId",required = false,defaultValue = "") Integer ordenId){
		
		List<Producto> productos;
		if(productoId==null && ordenId==null) {
			productos = service.findAll();
		}else if(productoId==null){
			productos = service.findByOrdenId(ordenId);
		}else {
			productos = service.findByProductoId(productoId);
		}
		
		List<ProductoDTO> productoDTOs = converter.fromEntity(productos);
		return new WrapperResponse(true,"SUCCESS", productoDTOs).createResponse(HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WrapperResponse<ProductoDTO>> findById(@PathVariable("id") int id){
		Producto producto = service.findById(id);
		ProductoDTO productoDTO = converter.fromEntity(producto);
		return new WrapperResponse<ProductoDTO>(true,"SUCCESS", productoDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO productoDTO){
		Producto productoReg = service.save(converter.fromDTO(productoDTO));
		ProductoDTO productoRegDTO = converter.fromEntity(productoReg);
		return new WrapperResponse(true,"SUCCESS", productoRegDTO).createResponse(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductoDTO> update(@PathVariable("id") int id, @RequestBody ProductoDTO productoDTO){
		Producto productoReg = service.update(converter.fromDTO(productoDTO));
		ProductoDTO productoRegDTO = converter.fromEntity(productoReg);
		return new WrapperResponse(true,"SUCCESS", productoRegDTO).createResponse(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductoDTO> delete(@PathVariable("id") int id){
		service.delete(id);
		return new WrapperResponse(true,"SUCCESS", null).createResponse(HttpStatus.OK);

	}


}
