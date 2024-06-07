package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.PlayList;

public interface PlaylistService {
	
	public void addPlayList(PlayList playList);
	
	public List<PlayList> fetchPlayList();

}