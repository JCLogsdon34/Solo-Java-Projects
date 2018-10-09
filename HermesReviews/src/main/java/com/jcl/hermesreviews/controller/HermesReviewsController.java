/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.controller;

import com.jcl.hermesreviews.dto.Author;
import com.jcl.hermesreviews.dto.Book;
import com.jcl.hermesreviews.dto.Field;
import com.jcl.hermesreviews.dto.Review;
import com.jcl.hermesreviews.servicelayer.HermesReviewsServiceLayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author JCLog
 */
@Controller
public class HermesReviewsController {

    private HermesReviewsServiceLayer service;

    @Inject
    public HermesReviewsController(HermesReviewsServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLandingPage() {
        return "index";
    }
    
    @RequestMapping(value = "/displayHomePage", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        List<Book> bookList = new ArrayList<>();
        List<Review> reviews = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Author> auths = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        List<Field> lots = new ArrayList<>();
        
//        Author author = new Author();
//        Field field = new Field();
        
        bookList = service.getAllBooks();

        for (Book book : bookList) {
            
            
            authors = book.getAuthor();
            fields = book.getFieldsOfStudy();
            
            for(Author author : authors){
            
            int authorID = author.getAuthorID();
            author = service.getAuthor(authorID);
            auths.add(author);
            }
            for(Field field : fields){
            
            int fieldID = field.getFieldID();
            field = service.getField(fieldID);
            lots.add(field);
            }
        }
            reviews.sort(new Comparator<Review>() {

                @Override
                public int compare(Review m1, Review m2) {
                    int placement = 0;
                    int first = m1.getReviewID();
                    int second = m2.getReviewID();
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
//                    LocalDate dateOne = LocalDate.parse(dateString, formatter);
//                    LocalDate dateTwo = LocalDate.parse(dateStringTwo, formatter);
                    if (first == second) {
                        placement = 0;
                    } else if (first < second){
                        placement = -1;
                    } else if (first > second){
                        placement = 1;
                    }
                    return placement;
                }
            });
            int u = 0;
            int r = 0;
            u = reviews.size();
            r = u - 10;
            reviews.subList(0, r).clear();
                

        model.addAttribute("reviews", reviews);
        return "homePage";
    }
    
}
