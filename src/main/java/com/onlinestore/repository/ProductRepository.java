package com.onlinestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByTitleContaining(String keyword);

}
