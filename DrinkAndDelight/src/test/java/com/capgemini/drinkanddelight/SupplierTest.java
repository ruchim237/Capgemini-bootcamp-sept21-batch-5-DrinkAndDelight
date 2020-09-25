package com.capgemini.drinkanddelight;

import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.drinkanddelight.dao.ISupplierDao;
import com.capgemini.drinkanddelight.entity.Supplier;
import com.capgemini.drinkanddelight.service.SupplierServiceImpl;

@SpringBootTest
public class SupplierTest {
	@Mock
	private ISupplierDao dao;
	@InjectMocks
	private SupplierServiceImpl service;
	
	/*
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	*/
	
	@Test
	public void testaddSupplier()
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierId(12);
		supplier.setSupplierName("MRroy");
		supplier.setSupplierAddress("bhopal");
		supplier.setSupplierPhoneNo(1999999991);
		supplier.setSupplierEmail("roy@gamil.com");
		service.addSupplier(supplier);
		Mockito.verify(dao, Mockito.times(1)).save(supplier);
    }

}
