package com.trupper.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trupper.order.api.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	Producto findByProductoId(Integer productoId);
	Producto findByOrdenId(Integer sucursalId);
	Producto findByCodigo(String codigo);

}
