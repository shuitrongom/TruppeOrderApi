package com.trupper.order.api.service;

import java.util.List;

import com.trupper.order.api.entity.Producto;

public interface ProductoService {
	public List<Producto> findAll();
	public Producto findByProductoId(Integer codigo);
	public Producto findByOrdenId(Integer ordenId);
	public Producto findById(int productoId);
	public Producto save(Producto producto);
	public Producto update(Producto producto);
	public Producto updateForCodigo(Producto producto);
	public void delete(int productoId);

}
