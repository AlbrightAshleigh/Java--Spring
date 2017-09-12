package com.ashleigh.queries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("")
	public String index(){
		return "index";
	}
	@RequestMapping("search")
	public String results(Model model,@RequestParam(value="name", defaultValue="Hooman") String name, @RequestParam(value="lname", defaultValue="Hooman") String lname ){
		model.addAttribute("name", name);
		model.addAttribute("lname", lname);
		return "query";
	}
}
