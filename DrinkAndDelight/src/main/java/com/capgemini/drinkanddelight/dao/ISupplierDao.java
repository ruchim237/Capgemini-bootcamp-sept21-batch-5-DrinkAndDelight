package com.capgemini.drinkanddelight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.drinkanddelight.entity.Supplier;

public class ISupplierDao {
	@Repository
	public interface SupplierDao extends JpaRepository<Supplier, Integer> {

	}
}
