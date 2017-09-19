package com.ashleigh.ninjadojo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashleigh.ninjadojo.models.Dojo;
import com.ashleigh.ninjadojo.services.DojoService;


@Controller
@RequestMapping("/")
public class DojoController {
	
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService){
		this.dojoService = dojoService;
	}
	
	@RequestMapping("dojos/{id}")
	public String displayDojo(@PathVariable Long id, Model model){
		System.out.println("made it!");
		Dojo dojo = dojoService.getOneById(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "dojo";
		
	}

}
