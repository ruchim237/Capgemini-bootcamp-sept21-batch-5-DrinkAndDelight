package com.capgemini.drinkanddelight.service;

import com.capgemini.drinkanddelight.entity.RawMaterialStockEntity;

import java.util.Date;
import java.util.List;

public interface IRawMaterialService {
    RawMaterialStockEntity addStock(RawMaterialStockEntity stock);
    RawMaterialStockEntity trackRawMaterialOrder(String orderId);
    boolean validateManufacturingDate(Date manuDate);
    boolean validateExpiryDate(Date expiryDate);
    List<RawMaterialStockEntity> fetchAllStock();
    //String updateRawMaterialStock(RawMaterialStockEntity stock, Date newDate);
    String updateRawMaterialStock(String orderId, Date date);

}
