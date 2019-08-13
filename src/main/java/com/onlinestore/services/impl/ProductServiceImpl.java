/**
 * 
 */
package com.onlinestore.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.entity.Product;
import com.onlinestore.repository.ProductRepository;
import com.onlinestore.services.ProductService;

/**
 * @author anoop
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {

		List<Product> productList =  productRepository.findAll();

		return productList.stream().filter(Product::isActive).collect(Collectors.toList());
	}

	@Override
	public Optional<Product> findOne(Long id) {

		return productRepository.findById(id);
	}

	@Override
	public Product save(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> search(String keyWord) {
		
		List<Product> productList =  productRepository.findByTitleContaining(keyWord);
		
		return productList.stream().filter( Product::isActive).collect(Collectors.toList());
	}

}
