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
* Nombre de archivo: MusicStoreController.java
* Autor: raforteg
* Fecha de creación: 23 sep. 2021
*/

package com.music.store.mx.application.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.application.dto.SongDto;
import com.music.store.mx.application.service.MusicStoreService;
import com.music.store.mx.model.Album;
import com.music.store.mx.model.Song;

/**
 * The Class MusicStoreController.
 */
@RestController
public class MusicStoreController {

  /** The music store service. */
  private MusicStoreService musicStoreService;

  /**
   * Instantiates a new music store controller.
   *
   * @param musicStoreService the music store service
   */
  public MusicStoreController(MusicStoreService musicStoreService) {
    this.musicStoreService = musicStoreService;
  }

  /**
   * Gets the albums.
   *
   * @return the albums
   */
  @GetMapping(value = "/api/v1/albums", produces = "application/json")
  public ResponseEntity<List<AlbumDto>> getAlbums() {
    return new ResponseEntity<>(musicStoreService.retrieveAlbums(), HttpStatus.OK);
  }

  /**
   * Save album.
   *
   * @param albumDto the album dto
   * @return the response entity
   */
  @PostMapping(value = "/api/v1/albums", produces = "application/json")
  public ResponseEntity<Album> saveAlbum(@RequestBody AlbumDto albumDto) {
    return new ResponseEntity<>(musicStoreService.saveAlbum(albumDto), HttpStatus.CREATED);
  }

  /**
   * Update all albums.
   *
   * @param newLabel the new label
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums", produces = "application/json")
  public ResponseEntity<List<AlbumDto>> updateAllAlbums(@RequestParam String newLabel) {
    musicStoreService.updateAllAlbums(newLabel);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Delete all albums.
   *
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums", produces = "application/json")
  public ResponseEntity<Void> deleteAllAlbums() {
    musicStoreService.deleteAllAlbums();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Gets the album by id.
   *
   * @param albumId the album id
   * @return the album by id
   */
  @GetMapping(value = "/api/v1/albums/{albumId}", produces = "application/json")
  public ResponseEntity<List<AlbumDto>> getAlbumById(@PathVariable("albumId") Integer albumId) {
    return new ResponseEntity<>(musicStoreService.retrieveAlbumById(albumId), HttpStatus.OK);
  }

  /**
   * Update album by id.
   *
   * @param albumId the album id
   * @param albumDto the album dto
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums/{albumId}", produces = "application/json")
  public ResponseEntity<String> updateAlbumById(@PathVariable Integer albumId,
      @RequestBody AlbumDto albumDto) {
    return new ResponseEntity<>(musicStoreService.updateAlbumById(albumDto, albumId),
        HttpStatus.OK);
  }

  /**
   * Delete album by id.
   *
   * @param albumId the album id
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums/{albumId}", produces = "application/json")
  public ResponseEntity<Boolean> deleteAlbumById(@PathVariable("albumId") Integer albumId) {
    return new ResponseEntity<>(musicStoreService.deleteAlbumById(albumId), HttpStatus.OK);
  }

  /**
   * Gets the songs by album id.
   *
   * @param albumId the album id
   * @return the songs by album id
   */
  @GetMapping(value = "/api/v1/albums/{albumId}/songs", produces = "application/json")
  public ResponseEntity<List<SongDto>> getSongsByAlbumId(@PathVariable("albumId") Integer albumId) {
    return new ResponseEntity<>(musicStoreService.findSongsByAlbumId(albumId), HttpStatus.OK);
  }

  /**
   * Creates the song by album.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the response entity
   */
  @PostMapping(value = "/api/v1/albums/{albumId}/songs", produces = "application/json")
  public ResponseEntity<Song> createSongByAlbum(@PathVariable Integer albumId,
      @RequestBody SongDto songDto) {
    return new ResponseEntity<>(musicStoreService.saveSongByAlbum(songDto, albumId),
        HttpStatus.CREATED);
  }

  /**
   * Update song by album.
   *
   * @param newAuthor the new author
   * @param albumId the album id
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums/{albumId}/songs", produces = "application/json")
  public ResponseEntity<Void> updateSongByAlbum(@RequestParam String newAuthor,
      @PathVariable Integer albumId) {
    musicStoreService.updateAllSongs(newAuthor, albumId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Delete all songs.
   *
   * @param albumId the album id
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums/{albumId}/songs", produces = "application/json")
  public ResponseEntity<Void> deleteAllSongs(@PathVariable Integer albumId) {
    musicStoreService.deleteAllSongs(albumId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Gets the song by album.
   *
   * @param albumId the album id
   * @param songId the song id
   * @return the song by album
   */
  @GetMapping(value = "/api/v1/albums/{albumId}/songs/{songId}", produces = "application/json")
  public ResponseEntity<Song> getSongByAlbum(@PathVariable Integer albumId,
      @PathVariable Integer songId) {
    return new ResponseEntity<>(musicStoreService.getSongByAlbum(songId, albumId), HttpStatus.OK);
  }

  /**
   * Update song by album.
   *
   * @param albumId the album id
   * @param songId the song id
   * @param songDto the song dto
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums/{albumId}/songs/{songId}", produces = "application/json")
  public ResponseEntity<Song> updateSongByAlbum(@PathVariable Integer albumId,
      @PathVariable Integer songId, @RequestBody SongDto songDto) {
    return new ResponseEntity<>(musicStoreService.updateSongByAlbum(songId, albumId, songDto),
        HttpStatus.OK);
  }

  /**
   * Delete song by album.
   *
   * @param albumId the album id
   * @param songId the song id
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums/{albumId}/songs/{songId}", produces = "application/json")
  public ResponseEntity<Void> deleteSongByAlbum(@PathVariable Integer albumId,
      @PathVariable Integer songId) {
    musicStoreService.deleteSongByAlbum(songId, albumId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Gets the songs.
   *
   * @return the songs
   */
  @GetMapping(value = "/api/v1/songs", produces = "application/json")
  public ResponseEntity<List<SongDto>> getSongs() {
    return new ResponseEntity<>(musicStoreService.retrieveSongs(), HttpStatus.OK);
  }

}
