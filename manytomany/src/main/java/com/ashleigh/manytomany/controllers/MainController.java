package com.ashleigh.manytomany.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashleigh.manytomany.models.Category;
import com.ashleigh.manytomany.models.Product;
import com.ashleigh.manytomany.services.CategoryService;
import com.ashleigh.manytomany.services.ProductService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public MainController(ProductService productService, CategoryService categoryService){
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("")
	public String index(@ModelAttribute("product") Product product){
		return "index";
	}
	
	@PostMapping("new/product")
	public String createCategory(@ModelAttribute("product") Product product, BindingResult result, RedirectAttributes flash ){
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs",result.getAllErrors());
			return "redirect:/new/product";
		}
		productService.addProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("product/{id}")
	public String productDisplay(Model model, @PathVariable("id") Long id){
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("categories", categoryService.allCategories());
		return "displayproduct";
	}
	
	@PostMapping("product/add/{id}")
	public String addCatToProd(@PathVariable("id") Long id, @RequestParam("category") Long categoryId){
		Product product = productService.findProductById(id);
		Category category = categoryService.findCategoryById(categoryId);
		List<Category> categories= (List<Category>) product.getCategories();
		
		categories.add(category);
		product.setCategories(categories);
		productService.update(product);
		
		
		
		return "redirect:/product/"+id;
		
		
	}


}
