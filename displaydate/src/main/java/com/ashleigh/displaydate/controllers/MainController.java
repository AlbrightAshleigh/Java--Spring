package com.ashleigh.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("")
		public String index(){
			return "index.jsp";
	}
	@RequestMapping("time")
		public String time(Model model){
			Date myTime = new Date();
			SimpleDateFormat time_format = new SimpleDateFormat("hh:mm a");
			String time = time_format.format(myTime);
			model.addAttribute("time", time);
			return "timetemplate.jsp";
	}
	@RequestMapping("date")
		public String date(Model model){
			Date myDate = new Date();
			SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
			String date = date_format.format(myDate);
			model.addAttribute("date", date);
			return "datetemplate.jsp";
}

}
