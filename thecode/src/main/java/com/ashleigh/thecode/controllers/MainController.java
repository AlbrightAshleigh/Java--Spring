package com.ashleigh.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")

public class MainController {
	@RequestMapping("")
	public String index(@ModelAttribute("errors")String errors){
		return "index";
	}
	@RequestMapping(path="guess", method= RequestMethod.POST)
	public String guess(@RequestParam(value="guess") String guess, RedirectAttributes redirectAttributes){
		if(guess.equals("bushido")){
			return "secret";
		}
		else{
			redirectAttributes.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";
		}
	}
}
