package com.ashleigh.manytomany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashleigh.manytomany.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{

}
