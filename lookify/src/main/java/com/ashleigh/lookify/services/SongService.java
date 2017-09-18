package com.ashleigh.lookify.services;

import com.ashleigh.lookify.models.Song;
import com.ashleigh.lookify.repositories.SongRepository;
import com.ashleigh.lookify.services.SongService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.stereotype.Service;

@Service
public class SongService {
	private SongRepository songRepository;
	
	public SongService(SongRepository songRepository){
		this.songRepository = songRepository;
	}
	
	public ArrayList<Song> allSongs(){
		return (ArrayList<Song>) songRepository.findAll();
	}
	
	public void addSong(Song song){
		songRepository.save(song);
	}
	
	public void destroySong(Long id){
		songRepository.delete(id);
		
	}
	
	public Song findSongById(Long id){
		return songRepository.findOne(id);
	}
	
	public void updateSong(Song song){
		songRepository.save(song);
	}
	
	public ArrayList<Song> topten(){
		ArrayList<Song> songs = (ArrayList<Song>) songRepository.findAll();
		Collections.sort(songs, Comparator.comparingInt(Song::getRating).reversed());
		for( int i= 0; i<songs.size(); i++){
			if(i>9){
				songs.remove(i);
			}
		}
		return songs;
		
	}

}
