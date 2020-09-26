package com.capgemini.drinkanddelight.service;

import java.util.List;

import com.capgemini.drinkanddelight.entity.Supplier;

public interface ISupplierService {
	Supplier addSupplier(Supplier supplier);
	Supplier fetchSupplierById(int id);
	List<Supplier> fetchAllSuppliers();
}

