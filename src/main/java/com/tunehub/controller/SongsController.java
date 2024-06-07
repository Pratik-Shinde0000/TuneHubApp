package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tunehub.entities.Songs;
import com.tunehub.services.SongService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongsController {
	@Autowired
	SongService songser;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song) {
		boolean songStatus = songser.nameExists(song.getName());
		if (songStatus == false) {
			songser.addSong(song);
			return "songsuccess";
		} else {
			return "songfailed";
		}
	}

	@GetMapping("/map-displaysongs")
	public String getMethodName(Model model) {
		List<Songs> listsongs = songser.getAllSongs();
		model.addAttribute("songs", listsongs);
		return "displaysongs";
	}

	@GetMapping("/viewSongs")
	public String viewCustomerSongs(Model model) {
		boolean primeCustomerStatus = true;
		if (primeCustomerStatus == true) {
			List<Songs> listsongs = songser.getAllSongs();
			model.addAttribute("songs", listsongs);
			return "displaysongs";
		} else {
			return "makepayment";
		}
	}

}
