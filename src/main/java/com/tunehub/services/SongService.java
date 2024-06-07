package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Songs;

public interface SongService 
{
	public String addSong(Songs song);
	
	public boolean nameExists(String name);
	
	public List<Songs> getAllSongs();
	
	public void updateSong(Songs song);

}
