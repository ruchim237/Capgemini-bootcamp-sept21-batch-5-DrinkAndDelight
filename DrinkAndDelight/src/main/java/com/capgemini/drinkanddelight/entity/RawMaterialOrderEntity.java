package com.capgemini.drinkanddelight.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //indicates that this class is an entity class
@Table(name = "RawMaterialOrders") 
public class RawMaterialOrderEntity {
	    @Id    
	    private  Integer  orderId;
	    private String name;
	    private String supplierId;
	    private double quantityValue;
	    private String quantityUnit;
	    private Date dateOfOrder;
	    private Date dateOfDelivery;
	    private double pricePerUnit;
	    private double totalPrice;
	    private String  deliveryStatus;
	    
		public RawMaterialOrderEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public RawMaterialOrderEntity(Integer orderId, String name, String supplierId, double quantityValue,
				String quantityUnit, Date dateOfOrder, Date dateOfDelivery, double pricePerUnit, double totalPrice,
				String deliveryStatus) {
			super();
			this.orderId = orderId;
			this.name = name;
			this.supplierId = supplierId;
			this.quantityValue = quantityValue;
			this.quantityUnit = quantityUnit;
			this.dateOfOrder = dateOfOrder;
			this.dateOfDelivery = dateOfDelivery;
			this.pricePerUnit = pricePerUnit;
			this.totalPrice = totalPrice;
			this.deliveryStatus = deliveryStatus;
		}

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSupplierId() {
			return supplierId;
		}

		public void setSupplierId(String supplierId) {
			this.supplierId = supplierId;
		}

		public double getQuantityValue() {
			return quantityValue;
		}

		public void setQuantityValue(double quantityValue) {
			this.quantityValue = quantityValue;
		}

		public String getQuantityUnit() {
			return quantityUnit;
		}

		public void setQuantityUnit(String quantityUnit) {
			this.quantityUnit = quantityUnit;
		}

		public Date getDateOfOrder() {
			return dateOfOrder;
		}

		public void setDateOfOrder(Date dateOfOrder) {
			this.dateOfOrder = dateOfOrder;
		}

		public Date getDateOfDelivery() {
			return dateOfDelivery;
		}

		public void setDateOfDelivery(Date dateOfDelivery) {
			this.dateOfDelivery = dateOfDelivery;
		}

		public double getPricePerUnit() {
			return pricePerUnit;
		}

		public void setPricePerUnit(double pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getDeliveryStatus() {
			return deliveryStatus;
		}

		public void setDeliveryStatus(String deliveryStatus) {
			this.deliveryStatus = deliveryStatus;
		}

		@Override
		public String toString() {
			return "RawMaterialOrderEntity [orderId=" + orderId + ", name=" + name + ", supplierId=" + supplierId
					+ ", quantityValue=" + quantityValue + ", quantityUnit=" + quantityUnit + ", dateOfOrder="
					+ dateOfOrder + ", dateOfDelivery=" + dateOfDelivery + ", pricePerUnit=" + pricePerUnit
					+ ", totalPrice=" + totalPrice + ", deliveryStatus=" + deliveryStatus + "]";
		}

	    
}
