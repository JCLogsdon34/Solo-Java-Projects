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
//    @Override
//    public Article getArticle(int articleID) {
//       return dao.getArticle(articleID);
//    }
//
//   
//    @Override
//    public void editArticle(Article article) {
//        dao.editArticle(article);
//    }
//
//    @Override
//    public void deleteArticle(int articleID) {
//        dao.deleteArticle(articleID);
//    }
//
//    @Override
//    public Article createArticle(Article article) {
//        return dao.createArticle(article);
//    }

    /// article reviews///////////////////////////////////////////////////
//    @Override
//    public ArticleReview getArticleReview(int articleReviewID) {
//        return dao.getArticleReview(articleReviewID);
//    }
//
//    @Override
//    public ArticleReview editArticleReview(int articleReviewID) {
//        return dao.editArticleReview(articleReviewID);
//    }
//
//    @Override
//    public void deleteArticleReview(int articleReview) {
//        dao.deleteArticleReview(articleReview);
//    }
//
//    @Override
//    public ArticleReview createArticleReview(ArticleReview articleReview) {
//        return dao.createArticleReview(articleReview);
//    }
    
    //Author methods /////////////////

    @Override
    public Author getAuthor(int authorID) {
        return dao.getAuthor(authorID);
    }

    @Override
    public void editAuthor(Author author) {
        dao.editAuthor(author);
    }

    @Override
    public void deleteAuthor(int authorID) {
        dao.deleteAuthor(authorID);
    }

    @Override
    public Author createAuthor(Author author) {
        return dao.createAuthor(author);
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
    public void editBook(Book book) {
        dao.editBook(book);
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

//    @Override
//    public BookReview getBookReview(int bookReviewID) {
//        return dao.getBookReview(bookReviewID);
//    }
//
//    @Override
//    public BookReview editBookReview(int bookReviewID) {
//        return dao.editBookReview(bookReviewID);
//    }
//
//    @Override
//    public void deleteBookReview(int bookReviewID) {
//        dao.deleteBookReview(bookReviewID);
//    }
//
//    @Override
//    public BookReview createBookReview(BookReview bookReview) {
//        return dao.createBookReview(bookReview);
//    }

    ////// Field Methods ////////////  
    
    @Override
    public Field getField(int fieldID) {
        return dao.getField(fieldID);
    }

    @Override
    public void editField(Field field) {
        dao.editField(field);
    }

    @Override
    public void deleteField(int fieldID) {
        dao.deleteField(fieldID);
    }

    @Override
    public Field createField(Field field) {
        return dao.createField(field);
    }

    @Override
    public List<Field> getAllFields(){
        return dao.getAllFields();
    }
    
    //////////////////// Review Methods //////
    @Override
    public Review getReview(int reviewID) {
        return dao.getReview(reviewID);
    }

    @Override
    public void editReview(Review review) {
        dao.editReview(review);
    }

    @Override
    public void deleteReview(int reviewID) {
        dao.deleteReview(reviewID);
    }

    @Override
    public Review createReview(Review review) {
        return dao.createReview(review);
    }
    
    @Override
    public List<Review> getAllReviews(){
        return dao.getAllReviews();
    }
    
}
