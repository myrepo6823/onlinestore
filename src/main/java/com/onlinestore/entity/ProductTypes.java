package com.onlinestore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductTypes implements Serializable{
	
	private static final long serialVersionUID = 189013457L;
	
	@Id
	private String productTypeCode ;
	private String parentProductTypeCode ;
	private String productTypeDes ;
	
	public String getProductTypeCode() {
		return productTypeCode;
	}
	public void setProductTypeCode(String productTypeCode) {
		this.productTypeCode = productTypeCode;
	}
	public String getParentProductTypeCode() {
		return parentProductTypeCode;
	}
	public void setParentProductTypeCode(String parentProductTypeCode) {
		this.parentProductTypeCode = parentProductTypeCode;
	}
	public String getProductTypeDes() {
		return productTypeDes;
	}
	public void setProductTypeDes(String productTypeDes) {
		this.productTypeDes = productTypeDes;
	}

}
