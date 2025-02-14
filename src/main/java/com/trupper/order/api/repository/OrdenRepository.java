package com.trupper.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trupper.order.api.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
	
	Orden findByOrdenId(Integer ordenId);
	Orden findBySucursalId(Integer sucursalId);

}
