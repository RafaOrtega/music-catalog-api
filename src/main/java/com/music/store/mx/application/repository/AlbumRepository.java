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
* Nombre de archivo: AlbumRepository.java
* Autor: raforteg
* Fecha de creación: 23 sep. 2021
*/

package com.music.store.mx.application.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.music.store.mx.model.Album;

/**
 * The Interface AlbumRepository.
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

  /**
   * Find all.
   *
   * @return the list
   */
  List<Album> findAll();

  /**
   * Find by album id.
   *
   * @param albumId the album id
   * @return the list
   */
  List<Album> findByAlbumId(Integer albumId);

  /**
   * Delete in batch.
   *
   * @param albumList the album list
   */
  void deleteInBatch(Iterable<Album> albumList);

  /**
   * Save.
   *
   * @param album the album
   * @return the album
   */
  Album save(Album album);

  /**
   * Delete by id.
   *
   * @param albumId the album id
   */
  void deleteById(Integer albumId);

  /**
   * Update label for all albums.
   *
   * @param newLabel the new label
   */
  @Modifying
  @Transactional
  @Query("UPDATE Album SET label = ?1")
  void updateLabelForAllAlbums(String newLabel);


}
