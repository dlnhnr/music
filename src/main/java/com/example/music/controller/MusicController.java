package com.example.music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.model.Track;
import com.example.music.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
        @Autowired
        MusicService musicService;
        
        @GetMapping(value="/tracks")
    	public List<Track> readMusic() {
    	    return musicService.getMusic();
    	}
        
        @PostMapping("/track")
        public Track createMusic(@RequestBody Track track) {
            return musicService.createMusic(track);
        }

        @GetMapping("/track/{id}")
        public Optional<Track> getMusicById(@PathVariable(value = "id") Long id) {
            return musicService.getMusicById(id);
        }

        @PutMapping("/track/{id}")
        public Track updateMusic(@PathVariable("id") Long id, @RequestBody Track musicDetails) {
            return musicService.updateMusic(id, musicDetails);
        }
        
        //needs to be fixed
        @PatchMapping("/track/{id}/{newname}")
        public Track patchMusic(@PathVariable(value = "id") Long id, @PathVariable(value = "newname") String newName) {
        	return musicService.patchMusic(id, newName);
		}

        @DeleteMapping("/track/{id}")
        public void deleteMusic(@PathVariable(value = "id") Long id) {
            musicService.deleteMusic(id);
        }


}
