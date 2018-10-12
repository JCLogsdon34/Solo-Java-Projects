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
public class Article {
    
    private int articleID;
    @NotEmpty(message = "You must supply a value for Article Title.")
    @Length(max = 150, message = "Article Title must be no more than 150 characters in length.")
    private String articleTitle;
    private LocalDate dateOfPublication;
    @NotEmpty(message = "You must supply a value for Publication Name.")
    @Length(max = 150, message = "Publication Name must be no more than 150 characters in length.")
    private String publicationName;
    
    List<Author> authors;
    List<Field> fields;
}
