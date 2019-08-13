package com.onlinestore.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.onlinestore.entity.Product;
import com.onlinestore.repository.ProductRepository;
import com.onlinestore.services.ProductService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductServiceImplTest {

	@Autowired
	private ProductService productService ;
	
	@Autowired
	private ProductRepository productRepository;

	@TestConfiguration
    static class ProductServiceImplTestContextConfiguration {
  
        @Bean
        public ProductService employeeService() {
            return new ProductServiceImpl();
        }
    }
 
	@Test
	public void testFindAll() {
		
		List<Product> products = productService.findAll() ;
		assertEquals(5, products.size());
	}

	@Test
	public void testFindOne() {
	
		Optional<Product> searchResult = productService.findOne(1l) ;
		Product product = null ;
		
		if (searchResult.isPresent()) {

			product = searchResult.get();
		}
		
		assertNotNull(product);
	}

	@Test
	public void testSearch() {
		
		List<Product> searchResult = productService.search("Cricket") ;
		assertEquals(2, searchResult.size());
	}

}
