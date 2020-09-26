package com.capgemini.drinkanddelight.service;

import java.util.List;
import com.capgemini.drinkanddelight.entity.RawMaterialOrderEntity;

public interface IRawMaterialOrderService {
	public RawMaterialOrderEntity addRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrder);
	public RawMaterialOrderEntity getRawMaterialOrder(int orderId);
	public void cancelOrder(int orderId);
	public RawMaterialOrderEntity updateRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrder);
	public List<RawMaterialOrderEntity> displayRawMaterialOrder();
}
