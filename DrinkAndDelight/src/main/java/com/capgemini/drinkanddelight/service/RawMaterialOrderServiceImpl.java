package com.capgemini.drinkanddelight.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.drinkanddelight.dao.IRawMaterialOrderDao;

@Service      
@Transactional
public class RawMaterialOrderServiceImpl implements IRawMaterialOrderService{
	
    @Autowired
    private IRawMaterialOrderDao dao;

	
}
