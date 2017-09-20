package com.ashleigh.manytomany.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ashleigh.manytomany.models.Category;
import com.ashleigh.manytomany.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository = categoryRepository;
	}
	
	public ArrayList<Category> allCategories(){
		return (ArrayList<Category>) categoryRepository.findAll();
	}
	
	public void addCategory(Category category){
		categoryRepository.save(category);
	}
	public Category findCategoryById(Long id){
		return categoryRepository.findOne(id);
	}

}
