package com.trupper.order.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trupper.order.api.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	List<Producto> findByProductoId(Integer productoId);
	List<Producto> findByOrdenId(Integer sucursalId);

}
