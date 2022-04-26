package com.example.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.model.Track;
import com.example.music.repository.MusicRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

	@Autowired
	MusicRepository musicRepo;
	
	// CREATE 
	public Track createMusic(Track track) {
	    return musicRepo.save(track);
	}

	// READ
	public List<Track> getMusic() {
	    return musicRepo.findAll();
	}
	
	public Optional<Track> getMusicById(Long id) {
	    return musicRepo.findById(id);
	}

	// DELETE
	public void deleteMusic(Long id) {
		musicRepo.deleteById(id);
	}
	
	// UPDATE
	public Track updateMusic(Long id, Track musicDetails) {
	        Track track = musicRepo.findById(id).get();
	        track.setName(musicDetails.getName());
	        track.setGenre(musicDetails.getGenre());
	        track.setArtist(musicDetails.getArtist());
	        track.setDurationInSeconds(musicDetails.getDurationInSeconds());
	        
	        return musicRepo.save(track);                                
	}
	
	// PATCH
		public Track patchMusic(Long id, String newName) {
		        Track track = musicRepo.findById(id).get();
		        track.setName(newName);
		        return musicRepo.save(track);                                
		}

}