/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.dto;

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
public class Review {
    
    private int reviewID;
    @NotEmpty(message = "You must supply a value for Title.")
    @Length(max = 100, message = "The title needs to be at least 50 characters.")
    private String title;
    @NotEmpty(message = "You must supply a value for the text of this review.")
    @Length(max = 3000, message = "The Text must be no more than 3000 characters in length.")
    private String text;
    private int bookID;
    private Book book;
    

    List<Field> fieldsOfStudy;
}
