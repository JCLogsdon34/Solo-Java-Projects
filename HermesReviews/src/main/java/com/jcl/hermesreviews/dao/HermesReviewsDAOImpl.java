/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hermesreviews.dao;

import com.jcl.hermesreviews.dto.Article;
import com.jcl.hermesreviews.dto.ArticleReview;
import com.jcl.hermesreviews.dto.Author;
import com.jcl.hermesreviews.dto.Book;
import com.jcl.hermesreviews.dto.BookReview;
import com.jcl.hermesreviews.dto.Field;
import com.jcl.hermesreviews.dto.Review;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JCLog
 */
public class HermesReviewsDAOImpl implements HermesReviewsDAO {

     private JdbcTemplate jdbcTemplate;

    @Inject
    public HermesReviewsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    ////////////////////////// Fields /////////////
    private static final String SQL_INSERT_FIELDS
            = "insert into fields (fieldName)"
            + "values (?)";

    private static final String SQL_DELETE_FIELDS
            = "DELETE from fields "
            + "WHERE fieldID = ? ";

    private static final String SQL_UPDATE_FIELDS
            = "update heros set fieldName = ? "
            + "WHERE fieldID = ? ";

    private static final String SQL_SELECT_FIELDS
            = "SELECT * from fields where fieldID = ?";
    

    private static final String SQL_SELECT_ALL_FIELDS
            = "SELECT * from fields";

//    private static final String SQL_INSERT_ARTICLE_FIELD
//            = "insert into article_field (articleID, fieldID)"
//            + " values (?, ?)";
//
//    private static final String SQL_UPDATE_ARTICLE_FIELD
//            = "update article_field set fieldID = ? "
//            + "WHERE articleID = ?";
//
//    private static final String SQL_DELETE_ARTICLE_FIELD
//            = "DELETE from article_field "
//            + "WHERE articleID = ?";
    
    private static final String SQL_UPDATE_BOOK_FIELD
           = "update article_field set fieldID = ? "
            + "WHERE bookID = ?";

    private static final String SQL_INSERT_BOOK_FIELD
            = "insert into book_field (bookID, fieldID)"
            + " values (?, ?)";
    
        private static final String SQL_DELETE_BOOK_FIELD
            = "DELETE from book_field "
            + "WHERE bookID = ?";

   ////////////////////// Authors //////////////////////////
    
    private static final String SQL_INSERT_AUTHORS
            = "insert into authors (authorName, institution)"
            + "values (?, ?)";

    private static final String SQL_DELETE_AUTHORS
            = "DELETE from authors "
            + "WHERE authorID = ? ";

    private static final String SQL_UPDATE_AUTHORS
            = "update authors set authorName = ?, institution = ? "
            + "WHERE authorID = ? ";

    private static final String SQL_SELECT_AUTHORS_BY_ID
            = "SELECT * from authors where authorID = ?";
    
     private static final String SQL_SELECT_BOOK_AUTHOR
            = "SELECT * "
            + "FROM BOOK_AUTHOR ba "
            + "inner join books b on ba.authorID = b.authorID "
            + "left join author a on ba.authorID = a.authorID "
            + "WHERE a.authorID = ?";

    private static final String SQL_SELECT_ALL_AUTHORS
            = "SELECT * from authors";

    private static final String SQL_INSERT_BOOK_AUTHOR
            = "insert into book_author (bookID, authorID)"
            + " values (?, ?)";

    private static final String SQL_UPDATE_BOOK_AUTHOR
            = "update book_author set bookID = ? "
            + "WHERE authorID = ?";

    private static final String SQL_DELETE_BOOK_AUTHOR
            = "DELETE from book_author "
            + "WHERE authorID = ?";

//    private static final String SQL_SELECT_ARTICLE_AUTHOR
//            = "SELECT * "
//            + "FROM article_author aa "
//            + "inner join articles ar on aa.articleID = ar.articleID "
//            + "left join authors au on aa.authorID = au.authorID "
//            + "WHERE au.authorID = ?";
//
//    private static final String SQL_INSERT_ARTICLE_AUTHOR
//            = "insert into article_author (articleID, authorID)"
//            + " values (?, ?)";
//
//    private static final String SQL_UPDATE_ARTICLE_AUTHOR
//            = "update article_author set articleID = ? "
//            + "WHERE authorID = ?";
//
//    private static final String SQL_DELETE_ARTICLE_AUTHOR
//            = "DELETE from article_author "
//            + "WHERE authorID = ?";
    
    //////////////Books //////////////////////////////
    
    private static final String SQL_INSERT_BOOKS
            = "insert into books "
            + "(title, pressName, dateOfPublication, fieldOfStudyID) "
            + "values (?, ?, ?, ?)";

    private static final String SQL_DELETE_BOOKS
            = "DELETE FROM books WHERE bookID = ?";

    private static final String SQL_UPDATE_BOOKS
            = "UPDATE books SET title = ?, "
            + "pressName = ?, "
            + "dateOfPublication = ?, "
            + "fieldOfStudyID = ? "
            + "WHERE bookID = ?";

    private static final String SQL_SELECT_ALL_BOOKS
            = "SELECT * FROM books";
    
        private static final String SQL_SELECT_BOOKS_BY_ID
            = "SELECT * from books where bookID = ?";
    
   /////////////////////Articles //////////////////////////////////
    
//    private static final String SQL_INSERT_ARTICLES
//            = "insert into articles "
//            + "(articleTitle, publicationName, dateOfPublication, author, field) "
//            + "values (?, ?, ?, ?, ?)";
//
//    private static final String SQL_DELETE_ARTICLES
//            = "DELETE FROM articles WHERE articleID = ?";
//
//    private static final String SQL_UPDATE_ARTICLES
//            = "UPDATE articles SET articleTitle = ?, "
//            + "publicationName = ?, "
//            + "dateOfPublication = ?, "
//            + "author = ? "
//            + "field = ? "
//            + "WHERE articleID = ?";
//
//    private static final String SQL_SELECT_ALL_ARTICLES
//            = "SELECT * FROM articles";
//
//    private static final String SQL_GET_ARTICLE_BY_ID
//            = "SELECT * FROM articles WHERE articleID = ?";
//    
    
    //////////////////////////// Reviews ////////////////////////
    private static final String SQL_INSERT_REVIEWS
            = "insert into reviews "
            + "(title, text, field) "
            + "values (?, ?, ?, ?)";

    private static final String SQL_DELETE_REVIEWS
            = "DELETE FROM reviews WHERE reviewID = ?";

    private static final String SQL_UPDATE_REVIEWS
            = "UPDATE reviews SET title = ?, "
            + "text = ?, "
            + "field = ?, "
            + "bookID = ?, "
            + "WHERE reviewID = ?";

    private static final String SQL_SELECT_ALL_REVIEWS
            = "SELECT * FROM reviews";

    private static final String SQL_GET_REVIEW_BY_ID
            = "SELECT * FROM reviews WHERE reviewID = ?";           
    
    //////////////////////////////// bookReviews //////////////////////
//    private static final String SQL_INSERT_BOOKREVIEWS
//            = "INSERT into bookreviews (book, review) "
//            + "values (?, ?)";
//    private static final String SQL_DELETE_BOOKREVIEW
//            = "delete from bookreviews where bookreviewID = ?";
//    private static final String SQL_UPDATE_BOOKREVIEW
//            = "update bookReviews set book = ?, review = ?"
//            + " WHERE bookReviewID  =  ?";
//    private static final String SQL_SELECT_BOOKREVIEWS
//            = "SELECT * from bookReviews WHERE bookReviewID = ? ";
//
//    private static final String SQL_SELECT_BOOKREVIEWS_BY_BOOK_ID
//            = " SELECT * "
//            + " FROM review_bookreview sl "
//            + " inner join BookReviews s on sl.bookID = s.bookID "
//            + " left join Books l on sl.book = l.bookID "
//            + " WHERE l.bookID = ?;";
//
//    private static final String SQL_SELECT_ALL_BOOKREVIEWS
//            = "SELECT * from bookreviews";  
//    
    //////////////////////// articleReviews ////////////////////////
    
//    private static final String SQL_INSERT_ARTICLEREVIEWS
//            = "INSERT into articlereviews (article, review) "
//            + "values (?, ?)";
//    private static final String SQL_DELETE_ARTICLEREVIEW
//            = "delete from articlereviews where bookreviewID = ?";
//    private static final String SQL_UPDATE_ARTICLEREVIEW
//            = "update articleReviews set article = ?, review = ?"
//            + " WHERE articleReviewID  =  ?";
//    private static final String SQL_SELECT_ARTICLEREVIEWS
//            = "SELECT * from articleReviews WHERE articleReviewID = ? ";
//
//    private static final String SQL_SELECT_ARTICLEREVIEWS_BY_ARTICLE_ID
//            = " SELECT * "
//            + " FROM review_articlereview sl "
//            + " inner join ArticleReviews s on sl.articleID = s.articleID "
//            + " left join Articles l on sl.article = l.articleID "
//            + " WHERE l.articleID = ?;";
//
//    private static final String SQL_SELECT_ALL_ARTICLEREVIEWS
//            = "SELECT * from articlereviews";  
    
    
    ////////////////////// DAO Methods /////////////////////////////
    ///articles
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public Article getArticle(int articleID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//   
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public Article editArticle(int articleID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public void deleteArticle(int articleID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public Article createArticle(Article article) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /// article reviews///////////////////////////////////////////////////
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public ArticleReview getArticleReview(int articleReviewID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public ArticleReview editArticleReview(int articleReviewID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public void deleteArticleReview(int articleReview) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public ArticleReview createArticleReview(ArticleReview articleReview) {
////        jdbcTemplate.update(SQL_INSERT_ARTICLEREVIEWS,
////                articleReview.getAuthorName(),
////                articleReview.getArticleID
////                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
////                        Integer.class);
////        articleReview.setAuthorID(authorID);
//        return articleReview;
//    }
    
    //Author methods /////////////////

    @Override 
    @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Author getAuthor(int authorID) {
         try {
            return jdbcTemplate.queryForObject(SQL_SELECT_AUTHORS_BY_ID,
                    new AuthorMapper(),
                    authorID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void editAuthor(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHORS,
                author.getAuthorName(),
                author.getInstitution(),
                author.getAuthorID());
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteAuthor(int authorID) {
  //      jdbcTemplate.update(SQL_DELETE_ARTICLE_AUTHOR, authorID);
        jdbcTemplate.update(SQL_DELETE_BOOK_AUTHOR, authorID);
        jdbcTemplate.update(SQL_DELETE_AUTHORS, authorID);
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Author createAuthor(Author author) {
         jdbcTemplate.update(SQL_INSERT_AUTHORS,
                author.getAuthorName(),
                author.getInstitution());
        int authorID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        author.setAuthorID(authorID);
        return author;
    }
    
    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public List<Author> getAllAuthors(){
        return jdbcTemplate.query(SQL_SELECT_ALL_AUTHORS,
                new AuthorMapper());
    }
    
    private static final class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author art = new Author();
            art.setAuthorID(rs.getInt("authorID"));
            art.setAuthorName(rs.getString("authorName"));
            art.setInstitution(rs.getString("institution"));
            return art;
        }
    }
    
    /////// Book methods //////////////////////////

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Book getBook(int bookID) {
          try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BOOKS_BY_ID,
                    new BookMapper(),
                    bookID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void editBook(Book book) {
                jdbcTemplate.update(SQL_UPDATE_BOOKS,
                book.getTitle(),
                book.getPressName(),
                book.getDateOfPublication(),
                book.getBookID());
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteBook(int bookID) {
//        jdbcTemplate.update(SQL_DELETE_BOOK_FIELD, bookID);
        jdbcTemplate.update(SQL_DELETE_BOOK_AUTHOR, bookID);
        jdbcTemplate.update(SQL_DELETE_BOOKS, bookID);
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Book createBook(Book book) {
                 jdbcTemplate.update(SQL_INSERT_BOOKS,
                book.getTitle(),
                book.getPressName(),
                book.getPressName(),
                book.getDateOfPublication());
        int bookID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        book.setBookID(bookID);
        return book;
    }
    
    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BOOKS,
                new BookMapper());
    }
    
        private static final class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book booook = new Book();
            booook.setBookID(rs.getInt("bookID"));
            booook.setTitle(rs.getString("title"));
            booook.setPressName(rs.getString("pressName"));
            booook.setDateOfPublication(rs.getString("dateOfPublication"));
//            booook.setAuthor(rs.getInt("author"));
//            booook.setFieldOfStudy(rs.getString("fieldOfStudy"));
            return booook;
        }
    }
    
    ////////////book reviews methods

//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public BookReview getBookReview(int bookReviewID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public BookReview editBookReview(BookReview bookReview) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public void deleteBookReview(int bookReviewID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public BookReview createBookReview(BookReview bookReview) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
//    public List<Review> getAllBookReviews(int bookReviewID) {
//        return jdbcTemplate.query(SQL_SELECT_ALL_BOOKREVIEWS,
//                new ReviewMapper(), bookReviewID);
//    }
//    
//        private static final class BookReviewMapper implements RowMapper<BookReview> {
//
//        @Override
//        public BookReview mapRow(ResultSet rs, int i) throws SQLException {
//            BookReview rev = new BookReview();
//            rev.setBookID(rs.getInt("bookID"));
//            return rev;
//        }
//    }
    ////// Field Methods ////////////  
    
    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Field getField(int fieldID) {
                  try {
            return jdbcTemplate.queryForObject(SQL_SELECT_FIELDS,
                    new FieldMapper(),
                    fieldID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void editField(Field field) {
        jdbcTemplate.update(SQL_UPDATE_FIELDS,
                field.getFieldName(),
                field.getFieldID());
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteField(int fieldID) {
        jdbcTemplate.update(SQL_DELETE_BOOK_FIELD, fieldID);
 //       jdbcTemplate.update(SQL_DELETE_ARTICLE_FIELD, fieldID);
        jdbcTemplate.update(SQL_DELETE_FIELDS, fieldID);
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Field createField(Field field) {
         jdbcTemplate.update(SQL_INSERT_FIELDS,
                field.getFieldName());
        int fieldID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        field.setFieldID(fieldID);
        return field;
    }
    
    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public List<Field> getAllFields() {
        return jdbcTemplate.query(SQL_SELECT_ALL_FIELDS,
                new FieldMapper());
    }
    
        private static final class FieldMapper implements RowMapper<Field> {

        @Override
        public Field mapRow(ResultSet rs, int i) throws SQLException {
            Field fie = new Field();
            fie.setFieldID(rs.getInt("fieldID"));
            fie.setFieldName(rs.getString("fieldName"));
            return fie;
        }
    }

    //////////////////// Review Methods //////
    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Review getReview(int reviewID) {
                 try {
            return jdbcTemplate.queryForObject(SQL_GET_REVIEW_BY_ID,
                    new ReviewMapper(),
                    reviewID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void editReview(Review review) {
        jdbcTemplate.update(SQL_UPDATE_REVIEWS,
                review.getTitle(),
                review.getText(),
                review.getBookID(),
                review.getReviewID());
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteReview(int reviewID) {
  //      jdbcTemplate.update(SQL_DELETE_BOOKREVIEW, reviewID);
  //      jdbcTemplate.update(SQL_DELETE_ARTICLEREVIEW, reviewID);
        jdbcTemplate.update(SQL_DELETE_REVIEWS, reviewID);
    }

    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public Review createReview(Review review) {
         jdbcTemplate.update(SQL_INSERT_REVIEWS,
                review.getTitle(),
                review.getText(),
                review.getBookID());
        int reviewID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        review.setReviewID(reviewID);
        return review;
    }
    
    @Override @Transactional (propagation = Propagation.REQUIRED, readOnly = false)
    public List<Review> getAllReviews() {
                return jdbcTemplate.query(SQL_SELECT_ALL_REVIEWS,
                new ReviewMapper());
    }
    
    private static final class ReviewMapper implements RowMapper<Review> {

        @Override
        public Review mapRow(ResultSet rs, int i) throws SQLException {
            Review rev = new Review();
            rev.setReviewID(rs.getInt("reviewID"));
            rev.setTitle(rs.getString("title"));
            rev.setText(rs.getString("text"));
            rev.setBookID(rs.getInt("bookID"));
            return rev;
        }
    }
  
}