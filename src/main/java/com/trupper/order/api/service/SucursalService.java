package com.trupper.order.api.service;

import java.util.List;

import com.trupper.order.api.entity.Sucursal;

public interface SucursalService {
	public List<Sucursal> findAll();
	public List<Sucursal> findByNombre(String nombre);
	public Sucursal findById(int sucursalId);
	public Sucursal save(Sucursal sucursal);
	public Sucursal update(Sucursal sucursal);
	public void delete(int sucursalId);

}
