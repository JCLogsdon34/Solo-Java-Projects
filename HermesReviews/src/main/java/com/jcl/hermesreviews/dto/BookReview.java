/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author JCLog
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookReview {
    
    private int bookReviewID;
    private int bookID;
    private Review review = new Review();
    
}
