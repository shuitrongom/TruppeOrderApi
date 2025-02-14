package com.trupper.order.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trupper.order.api.entity.Sucursal;
import com.trupper.order.api.exception.GeneralServicesException;
import com.trupper.order.api.exception.NoDataFoundException;
import com.trupper.order.api.exception.ValidateServicesException;
import com.trupper.order.api.repository.SucursalRepository;
import com.trupper.order.api.service.SucursalService;
import com.trupper.order.api.validator.SucursalValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	private SucursalRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Sucursal> findAll() {
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
	public List<Sucursal> findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		}catch (ValidateServicesException | NoDataFoundException e) {
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
	public Sucursal findById(int sucursalId) {
		try {			
			Sucursal sucursalop = repository.findById(sucursalId).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			return sucursalop;
		}catch (ValidateServicesException | NoDataFoundException e) {
			log.info(e.getMessage(),e);
			throw e;		
			}
		catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServicesException(e.getMessage(),e);		
			}
	}

	@Override
	@Transactional()
	public Sucursal save(Sucursal sucursal) {
		try {
			SucursalValidator.validator(sucursal);
			Sucursal sucursalop = repository.save(sucursal);
			return sucursalop;
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
	@Transactional()
	public Sucursal update(Sucursal sucursal) {
		try {
			SucursalValidator.validator(sucursal);
			Sucursal sucursalop = repository.findById(sucursal.getSucursalId()).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			sucursalop.setNombre(sucursal.getNombre());
			return sucursalop;
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
	@Transactional()
	public void delete(int sucursalId) {
		try {
			Sucursal sucursal = repository.findById(sucursalId).orElseThrow(()-> new NoDataFoundException("No existe el registro con ese ID"));
			repository.delete(sucursal);
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
