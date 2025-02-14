package com.trupper.order.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trupper.order.api.entity.Orden;
import com.trupper.order.api.entity.Sucursal;
import com.trupper.order.api.exception.GeneralServicesException;
import com.trupper.order.api.exception.NoDataFoundException;
import com.trupper.order.api.exception.ValidateServicesException;
import com.trupper.order.api.repository.OrdenRepository;
import com.trupper.order.api.repository.SucursalRepository;
import com.trupper.order.api.service.OrdenService;
import com.trupper.order.api.validator.OrdenValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrdenService {

	@Autowired
	OrdenRepository repository;
	
	@Autowired
	SucursalRepository sucursalRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Orden> findAll() {
		try {
			return repository.findAll();
		}  catch (NoDataFoundException e) {
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
	public Orden findByOrdenId(Integer ordenId) {
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
	public Orden findBySucursalId(Integer sucursalId) {
		try {
			return repository.findBySucursalId(sucursalId);
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
	public Orden findById(int ordenId) {
		try {			
			Orden ordenOP = repository.findById(ordenId).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			return ordenOP;
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
	public Orden save(Orden orden) {
		try {
			OrdenValidator.validator(orden);
			Optional<Sucursal> sucursal = sucursalRepository.findById(orden.getSucursalId());
			if(sucursal.isEmpty()) {
				throw new ValidateServicesException("La sucursal no se ha dado de alta");
			}
			Orden ordenOP = repository.save(orden);
			return ordenOP;
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
	public Orden update(Orden orden) {
		try {
			OrdenValidator.validator(orden);
			Orden ordenOP = repository.findById(orden.getOrdenId()).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			ordenOP.setFecha(orden.getFecha());
			ordenOP.setTotal(orden.getTotal());
			return ordenOP;
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
	public void delete(int ordenId) {
		try {
			Orden ordenOP = repository.findById(ordenId).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			repository.delete(ordenOP);
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
