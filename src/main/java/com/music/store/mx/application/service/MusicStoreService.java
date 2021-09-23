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
* Nombre de archivo: MusicStoreService.java
* Autor: raforteg
* Fecha de creación: 22 sep. 2021
*/

package com.music.store.mx.application.service;

import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.application.dto.SongDto;
import com.music.store.mx.model.Album;
import com.music.store.mx.model.Song;
import java.util.List;

/**
 * The Interface MusicStoreService.
 */
public interface MusicStoreService {

  /**
   * Retrieve albums.
   *
   * @return the list
   */
  List<AlbumDto> retrieveAlbums();

  /**
   * Save album.
   *
   * @param albumDto the album dto
   * @return the album
   */
  Album saveAlbum(AlbumDto albumDto);


  /**
   * Update all albums.
   *
   * @param newLabel the new label
   */
  void updateAllAlbums(String newLabel);

  /**
   * Delete all albums.
   */
  void deleteAllAlbums();

  /**
   * Retrieve album by id.
   *
   * @param albumId the album id
   * @return the list
   */
  List<AlbumDto> retrieveAlbumById(Integer albumId);

  /**
   * Update album by id.
   *
   * @param albumDto the album dto
   * @param albumId the album id
   * @return the string
   */
  String updateAlbumById(AlbumDto albumDto, Integer albumId);

  /**
   * Delete album by id.
   *
   * @param albumId the album id
   * @return true, if successful
   */
  boolean deleteAlbumById(Integer albumId);

  /**
   * Find songs by album id.
   *
   * @param albumId the album id
   * @return the list
   */
  List<SongDto> findSongsByAlbumId(Integer albumId);

  /**
   * Save song by album.
   *
   * @param songDto the song dto
   * @param albumId the album id
   * @return the song
   */
  Song saveSongByAlbum(SongDto songDto, Integer albumId);

  /**
   * Delete all songs.
   *
   * @param albumId the album id
   */
  void deleteAllSongs(Integer albumId);

  /**
   * Update all songs.
   *
   * @param newAuthor the new author
   * @param albumId the album id
   */
  void updateAllSongs(String newAuthor, Integer albumId);

  /**
   * Gets the song by album.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return the song by album
   */
  Song getSongByAlbum(Integer songId, Integer albumId);

  /**
   * Update song by album.
   *
   * @param songId the song id
   * @param albumId the album id
   * @param songDto the song dto
   * @return the song
   */
  Song updateSongByAlbum(Integer songId, Integer albumId, SongDto songDto);

  /**
   * Delete song by album.
   *
   * @param songId the song id
   * @param albumId the album id
   */
  void deleteSongByAlbum(Integer songId, Integer albumId);

  /**
   * Retrieve songs.
   *
   * @return the list
   */
  List<SongDto> retrieveSongs();
}
