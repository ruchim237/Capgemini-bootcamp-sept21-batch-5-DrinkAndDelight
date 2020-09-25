package com.capgemini.drinkanddelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.Supplier;

	@Repository
	public interface ISupplierDao extends JpaRepository<Supplier, Integer> {

	}
