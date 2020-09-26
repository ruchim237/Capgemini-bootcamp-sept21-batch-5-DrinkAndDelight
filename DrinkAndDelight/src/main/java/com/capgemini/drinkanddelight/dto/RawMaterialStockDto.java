package com.capgemini.drinkanddelight.dto;

import java.util.Date;

public class RawMaterialStockDto {

    private String stockId;
    private String orderId;
    private String name;
    private double price_per_unit;
    private double quantityValue;
    private double quantityUnit;
    private double price;
    private String warehouseId;
    private Date deliveryDate;
    private Date manuDate;
    private Date expiryDate;
    private String qualityCheck;
    private Date processDate;

    public String getStockId() {
        return stockId;
    }
    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
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
    public double getQuantityUnit() {
        return quantityUnit;
    }
    public void setQuantityUnit(double quantityUnit) {
        this.quantityUnit = quantityUnit;
    }
    public double getPrice_per_unit() {
        return price_per_unit;
    }
    public void setPrice_per_unit(double price_per_unit) {
        this.price_per_unit = price_per_unit;
    }
    public String getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    public double getQuantityValue() {
        return quantityValue;
    }
    public void setQuantityValue(double quantityValue) {
        this.quantityValue = quantityValue;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getManuDate() {
        return manuDate;
    }
    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getQualityCheck() {
        return qualityCheck;
    }
    public void setQualityCheck(String qualityCheck) {
        this.qualityCheck = qualityCheck;
    }
    public Date getProcessDate() {
        return processDate;
    }
    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }


}
