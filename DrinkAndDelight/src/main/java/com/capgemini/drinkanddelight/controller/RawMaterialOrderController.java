package com.capgemini.drinkanddelight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.drinkanddelight.entity.RawMaterialOrderEntity;
import com.capgemini.drinkanddelight.service.RawMaterialOrderServiceImpl;
/*
 * 
 * @Author
 * RUCHI MISHRA
 */
@RestController
//@CrossOrigin(origins="http://localhost:4200")
//maps HTTP request with a path to a controller method
@RequestMapping(value = "/rawmaterial") 
public class RawMaterialOrderController {
	
	 @Autowired
		private RawMaterialOrderServiceImpl service;

	 /**
		 * method name: addRawMaterialOrder
		 * method desc: to add a object of RawMaterialOrderEntity class by passing object by calling the method of service class.
		 * parameters:  RawMaterialOrderEntity class type-rawMaterialOrder
		 * returns:     RawMaterialOrder 
		 * method type: post
		 * author name: Ruchi
		 */ 
	 @RequestMapping(value="/orders",method=RequestMethod.POST) 
		public RawMaterialOrderEntity addRawMaterialOrder(@RequestBody RawMaterialOrderEntity rawMaterialOrder) {
			return service.addRawMaterialOrder(rawMaterialOrder);
		}
	 
	 
	 @GetMapping(value="/orders")
		public List<RawMaterialOrderEntity> listOfOrders(){
			return service.displayRawMaterialOrder();
		}

	 
	 @DeleteMapping(value="/orders/{orderId}")
	    public boolean cancelOrder(@PathVariable("orderId") int orderId) {
		  service.cancelOrder(orderId);
		  return true;
	   }

	 
	 @GetMapping(value="/orders/{orderId}")
		public RawMaterialOrderEntity getRawMaterialOrder(@PathVariable("orderId") int orderId){
		 RawMaterialOrderEntity rawMaterialOrder=service.getRawMaterialOrder(orderId);
	           return rawMaterialOrder;
		}

	 
	 @PutMapping(value="/orders")
		public RawMaterialOrderEntity updateOrders(@RequestParam("orderId") int orderId,@RequestParam("deliveryStatus") String deliveryStatus) {
		 RawMaterialOrderEntity rawMaterialOrder=service.updateRawMaterialOrder(orderId, deliveryStatus);
		 return rawMaterialOrder;		
			}

}
