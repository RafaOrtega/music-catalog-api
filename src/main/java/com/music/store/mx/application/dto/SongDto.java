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
* Nombre de archivo: SongDto.java
* Autor: raforteg
* Fecha de creación: 23 sep. 2021
*/
package com.music.store.mx.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class SongDto {

  /** The song id. */
  private Integer songId;

  /** The title. */
  private String title;

  /** The album id. */
  private Integer albumId;

  /** The author. */
  private String author;

  /** The duration. */
  private Double duration;

}
