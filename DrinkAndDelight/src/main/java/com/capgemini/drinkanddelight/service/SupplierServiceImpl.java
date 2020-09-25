package com.capgemini.drinkanddelight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.drinkanddelight.dao.ISupplierDao;
import com.capgemini.drinkanddelight.entity.Supplier;

@Service
@Transactional
public class SupplierServiceImpl implements ISupplierService {
	@Autowired
	ISupplierDao dao;

	@Override
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return dao.save(supplier);
	}

	@Override
	public Supplier fetchSupplierById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Supplier> fetchAllSuppliers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	

	
}
