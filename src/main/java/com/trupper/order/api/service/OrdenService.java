package com.trupper.order.api.service;

import java.util.List;

import com.trupper.order.api.entity.Orden;


public interface OrdenService {
	public List<Orden> findAll();
	public List<Orden> findByOrdenId(Integer ordenId);
	public List<Orden> findBySucursalId(Integer sucursalId);
	public Orden findById(int ordenId);
	public Orden save(Orden orden);
	public Orden update(Orden orden);
	public void delete(int ordenId);

}
