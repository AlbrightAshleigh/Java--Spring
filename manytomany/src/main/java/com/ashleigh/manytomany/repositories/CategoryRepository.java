package com.ashleigh.manytomany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashleigh.manytomany.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
