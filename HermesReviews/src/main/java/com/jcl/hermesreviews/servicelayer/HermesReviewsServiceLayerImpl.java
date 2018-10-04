/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.servicelayer;

import com.jcl.hermesreviews.dao.HermesReviewsDAO;
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
public class HermesReviewsServiceLayerImpl implements HermesReviewsServiceLayer {
    
    private HermesReviewsDAO dao;

    public HermesReviewsServiceLayerImpl(HermesReviewsDAO dao) {
        this.dao = dao;
    }
    
       ///articles
    @Override
    public Article getArticle(int articleID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public Article editArticle(int articleID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteArticle(int articleID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Article createArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /// article reviews///////////////////////////////////////////////////
    @Override
    public ArticleReview getArticleReview(int articleReviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArticleReview editArticleReview(int articleReviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteArticleReview(int articleReview) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArticleReview createArticleReview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Author methods /////////////////

    @Override
    public Author getAuthor(int authorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAuthor(int authorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAuthor(int authorID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Author createAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Author> getAllAuthors(){
        return dao.getAllAuthors();
    }
    
    /////// Book methods //////////////////////////

    @Override
    public Book getBook(int bookID) {
        return dao.getBook(bookID);
    }

    @Override
    public void editBook(int bookID) {
        dao.editBook(bookID);
    }

    @Override
    public void deleteBook(int bookID) {
        dao.deleteBook(bookID);
    }

    @Override
    public Book createBook(Book book) {
        return dao.createBook(book);
    }
    
    public List<Book> getAllBooks(){
        return dao.getAllBooks();
    }
    
    ////////////book reviews methods

    @Override
    public BookReview getBookReview(int bookReviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookReview editBookReview(int bookReviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBookReview(int bookReviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookReview createBookReview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ////// Field Methods ////////////  
    
    @Override
    public Field getField(int fieldID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Field editField(int fieldID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteField(int fieldID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Field createField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //////////////////// Review Methods //////
    @Override
    public Review getReview(int reviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Review editReview(int reviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteReview(int reviewID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Review createReview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
