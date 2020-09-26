package com.capgemini.drinkanddelight.dto;

import com.capgemini.drinkanddelight.entity.Supplier;

import java.util.Date;

public class StockAndSupplierDto {

    private String orderId;
    private String name;
    private Date deliveryDate;
    private Supplier supplier;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }



}
