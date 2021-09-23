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
* Nombre de archivo: Song.java
* Autor: raforteg
* Fecha de creación: 23 sep. 2021
*/
package com.music.store.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class Song.
 */
@Entity
@Table(name = "Cancion")

/**
 * Gets the duration.
 *
 * @return the duration
 */
@Getter

/**
 * Sets the duration.
 *
 * @param duration the new duration
 */
@Setter
public class Song {

  /** The song id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idCancion", nullable = false, length = 11)
  private Integer songId;

  /** The title. */
  @Column(name = "titulo", nullable = false, length = 45)
  private String title;

  /** The album id. */
  @Column(name = "idAlbum", nullable = false, length = 11)
  private Integer albumId;

  /** The author. */
  @Column(name = "autor", nullable = false, length = 45)
  private String author;

  /** The duration. */
  @Column(name = "duracion", nullable = false)
  private Double duration;

}
