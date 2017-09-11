package com.ashleigh.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/")
public class HomeController{
	@RequestMapping ("")
	public String index(){
		return "index.html";
	}
	@RequestMapping("myprojects")
	public String projects(){
		return "projects.html";
	}
	@RequestMapping("me")
	public String aboutme(){
		return "aboutme.html";
	}

}
