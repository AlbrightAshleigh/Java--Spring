package com.ashleigh.ninjadojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.ashleigh.ninjadojo.models.Ninja;
import com.ashleigh.ninjadojo.services.DojoService;
import com.ashleigh.ninjadojo.services.NinjaService;

@Controller
@RequestMapping("/")
public class NinjaController {
	
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}

	@RequestMapping("new/ninja")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model){
		model.addAttribute("dojos", dojoService.getAll());
		return"ninjaform";
	}
	
	@PostMapping("newninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, RedirectAttributes flash){
		if(result.hasErrors()){
			flash.addFlashAttribute("errs", result.getAllErrors());
			return "redirect:/ninjas/new";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
}
