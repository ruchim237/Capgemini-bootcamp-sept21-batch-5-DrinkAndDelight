package com.capgemini.drinkanddelight.dto;

public class SupplierDto {
    private int supplierId;
    private String supplierName;
    private String supplierAddress;
    private int supplierPhoneNo;


    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getSupplierAddress() {
        return supplierAddress;
    }
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
    public int getSupplierPhoneNo() {
        return supplierPhoneNo;
    }
    public void setSupplierPhoneNo(int supplierPhoneNo) {
        this.supplierPhoneNo = supplierPhoneNo;
    }

}
