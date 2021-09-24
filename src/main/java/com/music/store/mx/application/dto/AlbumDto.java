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
* Nombre de archivo: AlbumDto.java
* Autor: raforteg
* Fecha de creación: 23 sep. 2021
*/
package com.music.store.mx.application.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Gets the coverage.
 *
 * @return the coverage
 */
@Getter

/**
 * Sets the coverage.
 *
 * @param coverage the new coverage
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class AlbumDto {

  /** The album id. */
  private Integer albumId;

  /** The title. */
  private String title;

  /** The release. */
  private LocalDateTime release;

  /** The label. */
  private String label;

  /** The singer. */
  private String singer;

  /** The genre. */
  private String genre;

  /** The coverage. */
  private String coverage;

}
