package com.example.controller;

import com.example.dto.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllTheProducts() {
		return productService.getProducts();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}
}