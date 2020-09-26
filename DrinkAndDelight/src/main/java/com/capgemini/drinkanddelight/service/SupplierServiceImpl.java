package com.capgemini.drinkanddelight.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.drinkanddelight.exception.InvalidArgumentException;
import com.capgemini.drinkanddelight.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.drinkanddelight.dao.ISupplierDao;
import com.capgemini.drinkanddelight.entity.Supplier;

@Service
@Transactional
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier addSupplier(Supplier supplier) {
		supplier = dao.save(supplier);
		return supplier;
	}

	@Override
	public Supplier fetchSupplierById(int id) {
		if(id==0) {
			throw new InvalidArgumentException("Invlaid Supplier Id");
		}
		Optional<Supplier> optional = dao.findById(id);
		//Supplier supplier = null;
		if(optional.isPresent()) {
			Supplier supplier = optional.get();
			return supplier;
		}
		//return supplier;
		throw new SupplierNotFoundException("Supplier not found");
	}

	@Override
	public List<Supplier> fetchAllSuppliers() {
		List<Supplier>supplierList = dao.findAll();
		return supplierList;
	}

}
