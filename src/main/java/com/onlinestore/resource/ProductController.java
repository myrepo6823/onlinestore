package com.onlinestore.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.mapper.ProductEntityToModelMapper;
import com.onlinestore.model.Product;
import com.onlinestore.services.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/onlinestore")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "View the List of products", response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "OK"),
		    @ApiResponse(code = 500, message = "Internal Error Happend while Fetching the product")
		})
	@GetMapping("/products")
	public List<Product> getProductList() {

		return  productService.findAll().stream().map( ProductEntityToModelMapper::map).collect(Collectors.toList());

	}
	
	@ApiOperation(value = "View the details of the a particular product", response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "OK"),
		    @ApiResponse(code = 500, message = "Internal Error Happend while Fetching the product")
		})

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") Long id) {

		Optional<com.onlinestore.entity.Product> searchResult = productService.findOne(id);

		if (searchResult.isPresent()) {

			return  ProductEntityToModelMapper.map(searchResult.get());
		}

		return null;
	}

	@ApiOperation(value = "View the list of products which satisfying the search criteria.Search will apply only on the title", response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "OK"),
		    @ApiResponse(code = 500, message = "Internal Error Happend while Fetching the product")
		})

	@GetMapping(value = "/searchProduct/{keyword}")
	public List<Product> searchProduct(@PathVariable String keyword) {

		return productService.search(keyword).stream().map( ProductEntityToModelMapper::map).collect(Collectors.toList());
	}

}
