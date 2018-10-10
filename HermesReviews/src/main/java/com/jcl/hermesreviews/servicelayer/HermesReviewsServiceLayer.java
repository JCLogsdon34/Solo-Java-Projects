/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.servicelayer;

import com.jcl.hermesreviews.dto.Article;
import com.jcl.hermesreviews.dto.ArticleReview;
import com.jcl.hermesreviews.dto.Author;
import com.jcl.hermesreviews.dto.Book;
import com.jcl.hermesreviews.dto.BookReview;
import com.jcl.hermesreviews.dto.Field;
import com.jcl.hermesreviews.dto.Review;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface HermesReviewsServiceLayer {
    
    ////Article Methods
//    public Article getArticle(int articleID);
//    
//    public void editArticle(Article article);
//    
//    public void deleteArticle(int articleID);
//    
//    public Article createArticle(Article article);
    
    /// ArticleReview Methods
//    public ArticleReview getArticleReview(int articleReviewID);
//    
//    public ArticleReview editArticleReview(int articleReviewID);
//    
//    public void deleteArticleReview(int articleReview);
//    
//    public ArticleReview createArticleReview(ArticleReview articleReview);
    
    
    /// Author Methods
    public Author getAuthor(int authorID);
    
    public void editAuthor(Author author);
    
    public void deleteAuthor(int authorID);
    
    public Author createAuthor(Author author);
    
    public List<Author> getAllAuthors();
    
    /// Book Methods
    public Book getBook(int bookID);
    
    public void editBook(Book book);
    
    public void deleteBook(int bookID);
    
    public Book createBook(Book book);
    
    public List<Book> getAllBooks();
    
    /// Book Review Methods
//    public BookReview getBookReview(int bookReviewID);
//    
//    public BookReview editBookReview(int bookReviewID);
//    
//    public void deleteBookReview(int bookReviewID);
//    
//    public BookReview createBookReview(BookReview bookReview);
    
    
    /// Field Methods
    public Field getField(int fieldID);
    
    public void editField(Field field);
    
    public void deleteField(int fieldID);
    
    public Field createField(Field field);
    
    /// Review Methods 
    public Review getReview(int reviewID);
    
    public void editReview(Review review);
    
    public void deleteReview(int reviewID);
    
    public Review createReview(Review review);
    
    public List<Review> getAllReviews();
}
