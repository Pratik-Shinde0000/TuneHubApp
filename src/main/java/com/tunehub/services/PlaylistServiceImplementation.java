package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunehub.entities.PlayList;
import com.tunehub.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService{
	@Autowired
	PlaylistRepository playrepo;

	@Override
	public void addPlayList(PlayList playList) {
		playrepo.save(playList);
	}

	@Override
	public List<PlayList> fetchPlayList() {
		return playrepo.findAll();
	}

	
	
	

}
