package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.PlayList;
import com.tunehub.entities.Songs;
import com.tunehub.services.PlaylistService;
import com.tunehub.services.SongService;


@Controller
public class PlaylistController {
	@Autowired
	PlaylistService playser;

	@Autowired
	SongService songser;

	@GetMapping("/createplaylist")
	public String createPlayList(Model model) {
		// Fetching the songs using song service
		List<Songs> songslist = songser.getAllSongs();
		// Adding the songs in the model
		model.addAttribute("songslist", songslist);
		// Sending create playlist
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String playList(@ModelAttribute PlayList playlist) {
		System.out.println(playlist);
		// adding playlist
		playser.addPlayList(playlist);
		// update song table
		List<Songs> songlist = playlist.getSong();
		// Traverse list
		for (Songs s : songlist) {
			s.getPlaylist().add(playlist);
			songser.updateSong(s);
		}
		return "playlistsuccess";
	}
	
	@GetMapping("/viewplaylist")
	public String viewPlayList(Model model) {
		List<PlayList> playlist=playser.fetchPlayList();
		model.addAttribute("playlist", playlist);
		System.out.println(playlist);
		return "viewplaylist";
	}
	

}
