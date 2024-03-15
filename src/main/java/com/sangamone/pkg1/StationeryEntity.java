package com.sangamone.pkg1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sales")
public class StationeryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transId;
	private int salesamt=0;
	private String shopName,location,yearmonth;
	public int getTransId() {
		return transId;
	}
	public int getSalesamt() {
		return salesamt;
	}
	public void setSalesamt(int salesamt) {
		this.salesamt = salesamt;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getYearmonth() {
		return yearmonth;
	}
	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}
	
	

}
