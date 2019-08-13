package com.onlinestore.mapper;

import com.onlinestore.model.Product;

public class ProductEntityToModelMapper {
	
	private ProductEntityToModelMapper() {
		
	}
	public static Product   map(  com.onlinestore.entity.Product product ) {
		
		Product productResult = new Product() ;
		productResult.setActive(product.isActive());
		productResult.setCategory(product.getCategory());
		productResult.setDescription(product.getDescription());
		productResult.setId(product.getId());
		productResult.setInStockNumber(product.getInStockNumber());
		productResult.setListPrice(product.getListPrice());
		productResult.setOurPrice(product.getOurPrice());
		productResult.setShippingWeight(product.getShippingWeight());
		productResult.setTitle(product.getTitle());
		
		return productResult ;
	}

}
