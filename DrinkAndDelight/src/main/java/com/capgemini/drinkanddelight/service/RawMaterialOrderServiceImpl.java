package com.capgemini.drinkanddelight.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
	public RawMaterialOrderEntity updateRawMaterialOrder(Integer orderId, String deliveryStatus) {
		Optional<RawMaterialOrderEntity> optional= IRawMaterialOrderDao.findById(orderId);
		 if(optional.isPresent())
		 {
			 RawMaterialOrderEntity order = optional.get();
			 order.setOrderId(orderId);
			 order.setDeliveryStatus(deliveryStatus);
			 return order;
		 }
		 throw new RawMaterialOrderNotFoundException("Order Id doesn't exist");		
		
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
