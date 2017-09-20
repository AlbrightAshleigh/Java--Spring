package com.ashleigh.manytomany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashleigh.manytomany.models.Category;
import com.ashleigh.manytomany.services.CategoryService;
import com.ashleigh.manytomany.services.ProductService;

@Controller
@RequestMapping("/")
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService){
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("categoryForm")
	public String categoryForm(@ModelAttribute("category") Category category){
		return "newproduct";
	}
	@PostMapping("new/category")
	public String createCategory(@ModelAttribute("category") Category category, BindingResult result, RedirectAttributes flash ){
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs",result.getAllErrors());
			return "redirect:/new/category";
		}
		categoryService.addCategory(category);
		return "redirect:/";
	}
	
	@RequestMapping("category/{id}")
	public String categoryPage(Model model, @PathVariable("id") Long id){
		model.addAttribute("category", categoryService.findCategoryById(id));
		model.addAttribute("products", productService.allProducts());
		return "displaycategory";
		
	}

}
