package com.ashleigh.lookify.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashleigh.lookify.models.Song;
import com.ashleigh.lookify.services.SongService;


@Controller
@RequestMapping("/")
public class MainController {
	
	private final SongService songService;
	
	public MainController(SongService songService){
		this.songService = songService;
	}
	
	@RequestMapping("")
	public String index(HttpSession session){
		session.setAttribute("searchval", null);
		return "index";
	}
	
	@RequestMapping("dashboard")
	public String dashboard(Model model, HttpSession session){
		ArrayList<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "lookifydashboard";
	}
	
	@RequestMapping("songs")
	public String toptensongs(){
		return "lookifysongs";
	}
	
	@RequestMapping("songs/new")
		public String newSong(@ModelAttribute("song") Song song){
			return "createsong";
	}
	@PostMapping("songs/new")
	public String addSong(@ModelAttribute("song") Song song, BindingResult result, RedirectAttributes flash ){
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs",result.getAllErrors());
			return "redirect:/songs/new";
		}
		songService.addSong(song);
		return "redirect:/dashboard";
}
	
	@RequestMapping("songs/needTo")
	public String songsByID(){
		return "songbyid";
	}
	
	@RequestMapping("songs/updateThis")
	public String songsByName(){
		return "songbyname";
	}
	@RequestMapping(value="songs/delete/{id}")
	public String destorySong(@PathVariable Long id){
		songService.destroySong(id);
		return "redirect:/dashboard";
	}

	@RequestMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model){
		Song song = songService.findSongById(id);
		if(song != null){
			model.addAttribute("song", song);
			return "editSong";
		}else{
			return "redirect:/songs";
		}
		
	}
	@RequestMapping("songs/{id}")
	public String findSongByIndex(@PathVariable Long id, Model model){
		Song song = songService.findSongById(id);
		model.addAttribute("song", song);
		return "songbyid";
	}
	@RequestMapping("topten")
		public String topTen(Model model){
			model.addAttribute("songs", songService.topten());
			return "topten";
		}
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public String search(@RequestParam(value="search") String search, HttpSession session) {
		session.setAttribute("searchitem", search);
		return "redirect:/dashboard";
	}
	
   
}
