package com.ashleigh.ninjadojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashleigh.ninjadojo.models.Dojo;
import com.ashleigh.ninjadojo.services.DojoService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private final DojoService dojoService;
	
	public MainController(DojoService dojoService){
		this.dojoService = dojoService;
	}
	
	
@RequestMapping("")
public String index(@ModelAttribute("dojo") Dojo dojo ){
	return "index";
}

@PostMapping("new/dojo")
public String newDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult result, RedirectAttributes flash){
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs",result.getAllErrors());
			return "redirect:/new/dojo";
		}
		dojoService.addDojo(dojo);
		return "redirect:/";
	}
	
}


