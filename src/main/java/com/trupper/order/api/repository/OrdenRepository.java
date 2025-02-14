package com.trupper.order.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trupper.order.api.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
	
	List<Orden> findByOrdenId(Integer ordenId);
	List<Orden> findBySucursalId(Integer sucursalId);

}
