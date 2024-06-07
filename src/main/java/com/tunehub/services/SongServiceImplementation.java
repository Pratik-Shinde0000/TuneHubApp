package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Songs;
import com.tunehub.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository songrepo;

	@Override
	public String addSong(Songs song) {
		songrepo.save(song);
		return "Song added and saved";
	}

	@Override
	public boolean nameExists(String name) {
		if (songrepo.findByName(name) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Songs> getAllSongs() {
		List<Songs> songs=songrepo.findAll();
		return songs;
	}

	@Override
	public void updateSong(Songs song) {
		songrepo.save(song);
	}

}
