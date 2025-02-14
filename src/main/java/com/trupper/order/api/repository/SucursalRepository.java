package com.trupper.order.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trupper.order.api.entity.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
	
		List<Sucursal> findByNombre(String nombre);

}
