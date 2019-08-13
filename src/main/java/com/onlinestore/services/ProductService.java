package com.onlinestore.services;

import java.util.List;
import java.util.Optional;

import com.onlinestore.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Optional<Product> findOne(Long id);

	Product save(Product product);

	List<Product> search(String keyWord);

}
