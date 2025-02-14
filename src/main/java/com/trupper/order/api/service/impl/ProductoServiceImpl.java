package com.trupper.order.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trupper.order.api.entity.Producto;
import com.trupper.order.api.exception.GeneralServicesException;
import com.trupper.order.api.exception.NoDataFoundException;
import com.trupper.order.api.exception.ValidateServicesException;
import com.trupper.order.api.repository.ProductoRepository;
import com.trupper.order.api.service.ProductoService;
import com.trupper.order.api.validator.ProductoValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		try {
			return repository.findAll();
		} catch (NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByProductoId(Integer productoId) {
		try {
			return repository.findByProductoId(productoId);
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findByOrdenId(Integer ordenId) {
		try {
			return repository.findByOrdenId(ordenId);
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(int productoId) {
		try {			
			Producto productoOP = repository.findById(productoId).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			return productoOP;
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		try {
			ProductoValidator.validator(producto);
			Producto productoOP = repository.save(producto);
			return productoOP;
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional
	public Producto update(Producto producto) {
		try {
			ProductoValidator.validator(producto);
			Producto productoOP = repository.findById(producto.getProductoId()).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			productoOP.setCodigo(producto.getCodigo());
			productoOP.setDescripcion(producto.getDescripcion());
			productoOP.setPrecio(producto.getPrecio());
			return productoOP;
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}
	
	@Override
	@Transactional
	public Producto updateForCodigo(Producto producto) {
		try {
			ProductoValidator.validator(producto);
			Producto productoOP = repository.findByCodigo(producto.getCodigo());
			if(productoOP==null) {
				throw new ValidateServicesException("El codigo es requerido");
			}
			productoOP.setCodigo(producto.getCodigo());
			productoOP.setDescripcion(producto.getDescripcion());
			productoOP.setPrecio(producto.getPrecio());
			return productoOP;
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional
	public void delete(int productoId) {
		try {
			Producto productoOP = repository.findById(productoId).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			repository.delete(productoOP);
		} catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
		
	}

}
