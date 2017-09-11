package com.ashleigh.controllerpractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	public String index(){
		return "forward:/index.html";
	}

}
