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
* Nombre de archivo: MusicStoreServiceImpl.java
* Autor: raforteg
* Fecha de creación: 24 sep. 2021
*/

package com.music.store.mx.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.application.dto.SongDto;
import com.music.store.mx.application.mapper.AlbumMapper;
import com.music.store.mx.application.mapper.SongMapper;
import com.music.store.mx.application.repository.AlbumRepository;
import com.music.store.mx.application.repository.SongsRepository;
import com.music.store.mx.application.service.MusicStoreService;
import com.music.store.mx.model.Album;
import com.music.store.mx.model.Song;


/**
 * The Class MusicStoreServiceImpl.
 */
@Service
public class MusicStoreServiceImpl implements MusicStoreService {

  /** The album repository. */
  private AlbumRepository albumRepository;

  /** The songs repository. */
  private SongsRepository songsRepository;

  /**
   * Instantiates a new music store service impl.
   *
   * @param albumRepository the album repository
   * @param songsRepository the songs repository
   */
  public MusicStoreServiceImpl(AlbumRepository albumRepository, SongsRepository songsRepository) {
    this.albumRepository = albumRepository;
    this.songsRepository = songsRepository;
  }

  /**
   * Retrieve albums.
   *
   * @return the list
   */
  @Override
  public List<AlbumDto> retrieveAlbums() {
    return this.albumRepository.findAll().stream().map(AlbumMapper::toDto)
        .collect(Collectors.toList());
  }

  /**
   * Save album.
   *
   * @param albumDto the album dto
   * @return the album
   */
  @Override
  public AlbumDto saveAlbum(AlbumDto albumDto) {
    Album album = new Album();
    album = AlbumMapper.toModel(albumDto);
    this.albumRepository.save(album);
    albumDto = AlbumMapper.toDto(album);
    return albumDto;
  }

  /**
   * Update all albums.
   *
   * @param newLabel the new label
   */
  @Override
  public void updateAllAlbums(String newLabel) {
    this.albumRepository.updateLabelForAllAlbums(newLabel);
  }

  /**
   * Delete all albums.
   */
  @Override
  public void deleteAllAlbums() {
    this.albumRepository.deleteAllAlbums();
  }


  /**
   * Retrieve album by id.
   *
   * @param albumId the album id
   * @return the list
   */
  @Override
  public List<AlbumDto> retrieveAlbumById(Integer albumId) {
    return this.albumRepository.findByAlbumId(albumId).stream().map(AlbumMapper::toDto)
        .collect(Collectors.toList());
  }

  /**
   * Update album by id.
   *
   * @param albumDto the album dto
   * @param albumId the album id
   * @return the string
   */
  @Override
  public String updateAlbumById(AlbumDto albumDto, Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      Album newAlbum = new Album();
      newAlbum.setAlbumId(albumId);
      newAlbum.setTitle(albumDto.getTitle());
      newAlbum.setRelease(albumDto.getRelease());
      newAlbum.setLabel(albumDto.getLabel());
      newAlbum.setSinger(albumDto.getSinger());
      newAlbum.setGenre(albumDto.getGenre());
      newAlbum.setCoverage(albumDto.getCoverage());
      albumRepository.save(newAlbum);
      return "Actualizado";
    } else
      return "No se encuentra el registro";
  }

  /**
   * Delete album by id.
   *
   * @param albumId the album id
   * @return true, if successful
   */
  @Override
  public boolean deleteAlbumById(Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      this.albumRepository.deleteById(albumId);
      return true;
    } else
      return false;
  }

  /**
   * Find songs by album id.
   *
   * @param albumId the album id
   * @return the list
   */
  public List<SongDto> findSongsByAlbumId(Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      return this.songsRepository.findByAlbumId(albumId).stream().map(SongMapper::toDto)
          .collect(Collectors.toList());
    } else
      return null;
  }

  /**
   * Save song by album.
   *
   * @param songDto the song dto
   * @param albumId the album id
   * @return the song
   */
  @Override
  public SongDto saveSongByAlbum(SongDto songDto, Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      Song song = new Song();
      song.setTitle(songDto.getTitle());
      song.setAlbumId(albumId);
      song.setAuthor(songDto.getAuthor());
      song.setDuration(songDto.getDuration());
      this.songsRepository.saveAndFlush(song);
      songDto = SongMapper.toDto(song);
      return songDto;
    } else
      return null;
  }

  /**
   * Update all songs.
   *
   * @param newAuthor the new author
   * @param albumId the album id
   */
  @Override
  public void updateAllSongs(String newAuthor, Integer albumId) {
    this.songsRepository.updateAuthorForAllSongs(newAuthor, albumId);
  }

  /**
   * Delete all songs.
   *
   * @param albumId the album id
   */
  @Override
  public void deleteAllSongs(Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      List<Song> songs = new ArrayList<>();
      songs = this.songsRepository.findByAlbumId(albumId).stream().collect(Collectors.toList());
      this.songsRepository.deleteInBatch(songs);
    }
  }

  /**
   * Gets the song by album.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return the song by album
   */
  @Override
  public SongDto getSongByAlbum(Integer songId, Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      return SongMapper.toDto(this.songsRepository.findBySongId(songId));
      
      
    }
    return null;
  }

  /**
   * Delete song by album.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return true, if successful
   */
  @Override
  public boolean deleteSongByAlbum(Integer songId, Integer albumId) {
    if (albumRepository.findById(albumId).isPresent()) {
      this.songsRepository.deleteById(songId);
      return true;
    }
    return false;
  }

  /**
   * Update song by album.
   *
   * @param songId the song id
   * @param albumId the album id
   * @param songDto the song dto
   * @return the song
   */
  @Override
  public SongDto updateSongByAlbum(Integer songId, Integer albumId, SongDto songDto) {
    if (albumRepository.findById(albumId).isPresent()) {
      Song song = new Song();
      song.setSongId(songId);
      song.setTitle(songDto.getTitle());
      song.setAlbumId(albumId);
      song.setAuthor(songDto.getAuthor());
      song.setDuration(songDto.getDuration());
      this.songsRepository.saveAndFlush(song);
      songDto = SongMapper.toDto(song);
      return songDto;
    }
    return null;
  }

  /**
   * Retrieve songs.
   *
   * @return the list
   */
  @Override
  public List<SongDto> retrieveSongs() {
    return this.songsRepository.findAll().stream().map(SongMapper::toDto)
        .collect(Collectors.toList());
  }


}
