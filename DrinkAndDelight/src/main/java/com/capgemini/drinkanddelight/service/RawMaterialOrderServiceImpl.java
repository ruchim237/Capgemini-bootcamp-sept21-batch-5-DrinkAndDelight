package com.capgemini.drinkanddelight.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.drinkanddelight.dao.IRawMaterialOrderDao;
import com.capgemini.drinkanddelight.entity.RawMaterialOrderEntity;
import com.capgemini.drinkanddelight.exception.RawMaterialOrderNotFoundException;

@Service      
@Transactional
public class RawMaterialOrderServiceImpl implements IRawMaterialOrderService{
	
    @Autowired
    private IRawMaterialOrderDao IRawMaterialOrderDao;

    
	@Override
	public RawMaterialOrderEntity addRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrder) {
		Date date = new Date();
	    rawMaterialOrder.setDateOfOrder(date);
		Calendar calendar=Calendar.getInstance();
	    calendar.add(Calendar.DAY_OF_MONTH,7);
		Date deliveryDate=calendar.getTime();
	    rawMaterialOrder.setDateOfDelivery(deliveryDate);			        
		double pricePerUnit = rawMaterialOrder.getPricePerUnit();
		double quantityValue = rawMaterialOrder.getQuantityValue();
		double totalPrice = pricePerUnit * quantityValue;
		rawMaterialOrder.setTotalPrice(totalPrice);
		return	IRawMaterialOrderDao.save( rawMaterialOrder);
	}

	
	@Override
	public RawMaterialOrderEntity getRawMaterialOrder(int orderId) {
		return IRawMaterialOrderDao.findById(orderId).get();
	}

	
	@Override
	public RawMaterialOrderEntity updateRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrder) {
		RawMaterialOrderEntity updateOrders =IRawMaterialOrderDao.save(rawMaterialOrder);
		    if(updateOrders!=null)
			{
			return IRawMaterialOrderDao.save(rawMaterialOrder);		
			}
			else
			{
			throw new RawMaterialOrderNotFoundException("OrderId  does not exist.");
			}
		 }

	
	@Override
	public List<RawMaterialOrderEntity> displayRawMaterialOrder() {
		List<RawMaterialOrderEntity> orders=  IRawMaterialOrderDao.findAll();
        return orders;
	}

	
	@Override
	public void cancelOrder(int orderId) {
		IRawMaterialOrderDao.deleteById(orderId);
		
	}

	
}
