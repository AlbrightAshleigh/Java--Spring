package com.ashleigh.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("")
	public String index(){
		return "index";
	}

	@RequestMapping("m/{chapter}/0483/{assignmentNumber}")
	public String view(){
		
			return "assignment";
		
		}
	
		
	@RequestMapping("m/{chaptr}/0553/{assignmentNumber}")
	public String views(){
		
			return "lesson";
	
				
			}
	}

