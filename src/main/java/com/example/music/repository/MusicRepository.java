package com.example.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.music.model.Track;

@Repository
public interface MusicRepository extends JpaRepository<Track, Long> {

}
