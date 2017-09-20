package com.ashleigh.manytomany.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ashleigh.manytomany.models.Product;
import com.ashleigh.manytomany.repositories.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	public void update(Product product) {
		productRepository.save(product);
		
	}
	
	public ArrayList<Product> allProducts(){
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	public void addProduct(Product product){
		productRepository.save(product);
	}
	
	public Product findProductById(Long id) {
		return productRepository.findOne(id);
	}

}
