/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: SongsRepository.java
* Autor: raforteg
* Fecha de creación: 24 sep. 2021
*/


package com.music.store.mx.application.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.music.store.mx.model.Song;

/**
 * The Interface SongsRepository.
 */
public interface SongsRepository extends JpaRepository<Song, Integer> {

  /**
   * Find all.
   *
   * @return the list
   */
  List<Song> findAll();

  /**
   * Find by author.
   *
   * @param author the author
   * @return the list
   */
  List<Song> findByAuthor(String author);

  /**
   * Find by album id.
   *
   * @param albumId the album id
   * @return the list
   */
  List<Song> findByAlbumId(Integer albumId);

  /**
   * Save and flush.
   *
   * @param s the s
   * @return the song
   */
  Song saveAndFlush(Song s);

  /**
   * Delete by id.
   *
   * @param songId the song id
   */
  void deleteById(Integer songId);

  /**
   * Delete in batch.
   *
   * @param songList the song list
   */
  void deleteInBatch(Iterable<Song> songList);

  /**
   * Find by song id.
   *
   * @param songId the song id
   * @return the song
   */
  Song findBySongId(Integer songId);

  /**
   * Update author for all songs.
   *
   * @param newAuthor the new author
   * @param albumId the album id
   */
  @Modifying
  @Transactional
  @Query("UPDATE Song SET author = ?1 WHERE albumId = ?2")
  void updateAuthorForAllSongs(String newAuthor, Integer albumId);

}
