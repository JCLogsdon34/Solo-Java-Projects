/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JCLog
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {
    
    private int bookID;
    @NotEmpty(message = "You must supply a value for Title.")
    @Length(max = 250, message = "Title must be no more than 250 characters in length.")
    private String title;
    private String pressName;
    private LocalDate dateOfPublication;
    
    List<Author> author;
    List<Field> fieldsOfStudy;
}
