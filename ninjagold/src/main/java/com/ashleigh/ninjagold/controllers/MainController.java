package com.ashleigh.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
	ArrayList<String> activities = new ArrayList<String>();
	
	@RequestMapping("")
	public String index(HttpSession session){
		if(session.getAttribute("gold")==null){
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activities")==null){
			session.setAttribute("activities", activities);
		}
		return ("index");
	}
	@RequestMapping (path="process/{building}", method= RequestMethod.POST)
	public String gold(HttpSession session, @PathVariable String building){
		
		Date date = new Date();
		Integer gold = (Integer) session.getAttribute("gold");
		
		if(building.equals("farm")){
			Integer winnings= 10;
			String message = "Won " + winnings + " at the farm.";
			activities.add(message);
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold+winnings);
			
		}
		else if(building.equals("house")){
			Integer winnings= 5;
			String message = "Won" + winnings + "at the house.";
			activities.add(message);
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold+winnings);
			
		}
		else if(building.equals("cave")){
			Integer winnings= 7;
			String message = "Won" + winnings + "at the cave.";
			activities.add(message);
			session.setAttribute("activities", activities);
			session.setAttribute("gold", gold+winnings);
			
		}
		else if(building.equals("casino")){
			Random random = new Random();
			Integer chance= random.nextInt(2-1+1)+1;
			if(chance == 1){
				Integer winnings= 50;
				String message = "Won" + winnings + "at the casino.";
				activities.add(message);
				session.setAttribute("activities", activities);
				session.setAttribute("gold", gold+winnings);
			}
			else if(chance == 2){
				Integer winnings= 50;
				String message = "Lost" + winnings + "at the casino.";
				activities.add(message);
				session.setAttribute("activities", activities);
				session.setAttribute("gold", gold-winnings);
				
			}
			
			
		}
		
		
		return "redirect:/";
	}
	
}
