package com.ashleigh.lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashleigh.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

}
