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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        List<Review> revs = new ArrayList<>();
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
    
    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Reviews ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayReviewsPage", method = RequestMethod.GET)
    public String displayAllReviews(Model model) {
        List<Review> reviewList = new ArrayList<>();
        List<Review> revs = new ArrayList<>();
        List<Field> fields = new ArrayList<>();

        reviewList = service.getAllReviews();
        
        for (Review review : reviewList) {
            Book book = new Book();
            Field field = new Field();
            fields = review.getFieldsOfStudy();
            for(Field f : fields){
                int fieldID = f.getFieldID();
                field = service.getField(fieldID);
                fields.add(field);
            }
            int bookID = review.getBookID();
            book = service.getBook(bookID);
            review.setBook(book);
            revs.add(review);
        }
        model.addAttribute("reviews", revs);
        return "reviewsPage";
    }

    @RequestMapping(value = "/createReview", method = RequestMethod.POST)
    public String createReview(HttpServletRequest request) {
        Book book = new Book();
        List<Field> fields = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Author> auths = new ArrayList<>();
        
        Review review = new Review();
        
        books = service.getAllBooks();
        
        String authorName = "";
        int integerBook = 0;
        int authorID = 0;
        int fieldID = 0;
        String bookTitle  = "";
        String press = "";  
        String published = "";
        String fieldName = "";
        
        for(Book b : books){
           integerBook = b.getBookID();
           bookTitle = b.getTitle();
           press = b.getPressName();
           published = b.getDateOfPublication();
           auths = b.getAuthor();
           fields = b.getFieldsOfStudy();
           
           
//                for(Author r : auths){
//                    authorID = r.getAuthorID();
//                    authorName = r.getAuthorName();
//                    
//                }
//                for(Field f : fields){
//                    fieldID = f.getFieldID();
//                    fieldName = f.getFieldName();
//                }
        }
        String bookIdParameter = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookIdParameter);
        review.setBookID(bookID);
        
        String fieldIdParameter = request.getParameter("fieldID");
        fieldID = Integer.parseInt(fieldIdParameter);
        Field field = new Field();
        field = service.getField(fieldID);
        fields.add(field);
        review.setFieldsOfStudy(fields);
        String title = "";
        String text = "";
        title = request.getParameter("title");
        text = request.getParameter("text");
        book = service.getBook(bookID);
        review.setBook(book);

        service.createReview(review);
        return "redirect:displayReviewsPage";
    }

    @RequestMapping(value = "/deleteReview", method = RequestMethod.GET)
    public String deleteReview(HttpServletRequest request) {
        String reviewIdParameter = request.getParameter("reviewID");
        int reviewID = Integer.parseInt(reviewIdParameter);
        Review review = new Review();
        review = service.getReview(reviewID);
        service.deleteReview(reviewID);
        return "redirect:displayReviewsPage";
    }
    
    @RequestMapping(value = "/displayUpdateReviewsForm", method = RequestMethod.GET)
    public String displayEditReviewForm(HttpServletRequest request, Model model) {
        List<Review> reviewList = new ArrayList<>();
        String reviewIdParameter = request.getParameter("reviewID");
        int reviewID = Integer.parseInt(reviewIdParameter);
        Review review = new Review();
        review = service.getReview(reviewID);
        List<Field> fieldList = new ArrayList<>();
        List<Field> lotList = new ArrayList<>();
        List<Book> bList = new ArrayList<>();
        for (Review r : reviewList) {
            Field field = new Field();
            Book book = new Book();
            int fieldID = 0;
            int bookID = 0;
            fieldList = r.getFieldsOfStudy();
            for(Field f : fieldList){
                fieldID = f.getFieldID();
                field = service.getField(fieldID);
                lotList.add(f);
            }
            review.setFieldsOfStudy(fieldList);
            bookID = review.getBookID();
            book = service.getBook(bookID);
            review.setBook(book);
        }
        model.addAttribute("fieldList", fieldList);
        reviewList.add(review);
        model.addAttribute("reviewList", reviewList);
        return "updateReviewsForm";
    }

    @RequestMapping(value = "/updateReviews", method = RequestMethod.POST)
    public String editReview(@Valid @ModelAttribute("sighting") Review review, BindingResult result) {
        if (result.hasErrors()) {
            return "updateReviewForm";
        }
        service.editReview(review);
        return "redirect:reviewsPage";
    }

    @RequestMapping(value = "/displayReviewDetails", method = RequestMethod.GET)
    public String displayReview(HttpServletRequest request, Model model) {
        List<Review> reviewList = new ArrayList<>();
        String reviewIdParameter = request.getParameter("reviewID");
        int reviewID = Integer.parseInt(reviewIdParameter);
        Review review = new Review();

        review = service.getReview(reviewID);
        List<Field> fieldList = new ArrayList<>();
//        int fieldID = 0;
        int bookID = 0;
        Book book = new Book();
//        Field field = new Field();
//        field = service.getField(fieldID);
        fieldList = review.getFieldsOfStudy();
//        for(Field f : fieldList){
//            fieldID = f.getFieldID();
//            field = service.getField(fieldID);
//        }
        model.addAttribute("fieldList", fieldList);

        bookID = review.getBookID();
        book = service.getBook(bookID);
        review.setBook(book);
        reviewList.add(review);
        model.addAttribute("reviewList", reviewList);
        return "reviewDetails";
    }
    
    
    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Author ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayAuthorsPage", method = RequestMethod.GET)
    public String displayAllAuthors(Model model) {
        List<Author> authorList = new ArrayList<>();
        authorList = service.getAllAuthors();
        model.addAttribute("authorList", authorList);
        return "authorsPage";
    }

    @RequestMapping(value = "/createAuthor", method = RequestMethod.POST)
    public String createAuthor(HttpServletRequest request) {
        Author Author = new Author();
        Author.setAuthorName(request.getParameter("authorName"));
        Author.setInstitution(request.getParameter("institution"));
        service.createAuthor(Author);
        return "redirect:displayAuthorsPage";
    }

    @RequestMapping(value = "/displayUpdateAuthor", method = RequestMethod.GET)
    public String displayEditAuthorForm(HttpServletRequest request, Model model) {
        List<Author> AuthorList = new ArrayList<>();
        String AuthorIdParameter = request.getParameter("AuthorID");
        int AuthorID = Integer.parseInt(AuthorIdParameter);
        Author Author = new Author();
        Author = service.getAuthor(AuthorID);
        AuthorList.add(Author);
        model.addAttribute("AuthorList", AuthorList);
        return "updateAuthorForm";
    }

    @RequestMapping(value = "/updateAuthor", method = RequestMethod.POST)
    public String editAuthor(@Valid @ModelAttribute("AuthorList") Author Author, BindingResult result) {
        if (result.hasErrors()) {
            return "updateAuthorForm";
        }
        service.editAuthor(Author);
        return "redirect:AuthorsPage";
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.GET)
    public String deleteAuthor(HttpServletRequest request) {
        String AuthorIdParameter = request.getParameter("AuthorID");
        int AuthorID = Integer.parseInt(AuthorIdParameter);
        service.deleteAuthor(AuthorID);
        return "redirect:displayAuthorsPage";
    }

    @RequestMapping(value = "/displayAuthor", method = RequestMethod.GET)
    public String displayAuthor(HttpServletRequest request, Model model) {
        List<Author> AuthorList = new ArrayList<>();
        String AuthorIdParameter = request.getParameter("AuthorID");
        int AuthorID = Integer.parseInt(AuthorIdParameter);
        Author Author = new Author();
        Author = service.getAuthor(AuthorID);
        AuthorList.add(Author);
        model.addAttribute("AuthorList", AuthorList);
        return "AuthorDetails";
    }
    
    
    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Fields ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayFieldsPage", method = RequestMethod.GET)
    public String displayAllFields(Model model) {
        List<Field> FieldList = new ArrayList<>();
        FieldList = service.getAllFields();
        model.addAttribute("FieldList", FieldList);
        return "FieldsPage";
    }

    @RequestMapping(value = "/createField", method = RequestMethod.POST)
    public String createField(HttpServletRequest request) {
        Field Field = new Field();
        Field.setFieldName(request.getParameter("fieldName"));
        service.createField(Field);
        return "redirect:displayFieldsPage";
    }

    @RequestMapping(value = "/displayUpdateField", method = RequestMethod.GET)
    public String displayEditFieldForm(HttpServletRequest request, Model model) {
        List<Field> FieldList = new ArrayList<>();
        String FieldIdParameter = request.getParameter("FieldID");
        int FieldID = Integer.parseInt(FieldIdParameter);
        Field Field = new Field();
        Field = service.getField(FieldID);
        FieldList.add(Field);
        model.addAttribute("FieldList", FieldList);
        return "updateFieldForm";
    }

    @RequestMapping(value = "/updateField", method = RequestMethod.POST)
    public String editField(@Valid @ModelAttribute("FieldList") Field Field, BindingResult result) {
        if (result.hasErrors()) {
            return "updateFieldForm";
        }
        service.editField(Field);
        return "redirect:FieldsPage";
    }

    @RequestMapping(value = "/deleteField", method = RequestMethod.GET)
    public String deleteField(HttpServletRequest request) {
        String FieldIdParameter = request.getParameter("FieldID");
        int FieldID = Integer.parseInt(FieldIdParameter);
        service.deleteField(FieldID);
        return "redirect:displayFieldsPage";
    }

    @RequestMapping(value = "/displayField", method = RequestMethod.GET)
    public String displayField(HttpServletRequest request, Model model) {
        List<Field> FieldList = new ArrayList<>();
        String FieldIdParameter = request.getParameter("FieldID");
        int FieldID = Integer.parseInt(FieldIdParameter);
        Field Field = new Field();
        Field = service.getField(FieldID);
        FieldList.add(Field);
        model.addAttribute("FieldList", FieldList);
        return "FieldDetails";
    }
    
    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Books ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayBooksPage", method = RequestMethod.GET)
    public String displayAllBooks(Model model) {
        List<Book> bookList = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        bookList = service.getAllBooks();
        
        for (Book b : bookList) {
            Book book = new Book();
            int bookID = book.getBookID();
            book = service.getBook(bookID);
            Author author = new Author();
            authors = book.getAuthor();
            for(Author a : authors){
                int authorID = a.getAuthorID();
                author = service.getAuthor(authorID);
                authors.add(author);
            }
            book.setAuthor(authors);
            books.add(book);
        }
        model.addAttribute("books", books);
        return "booksPage";
    }

    @RequestMapping(value = "/createBook", method = RequestMethod.POST)
    public String createBook(HttpServletRequest request) {
        Book book = new Book();
        List<Field> fields = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<Author> auths = new ArrayList<>();
        
        Review review = new Review();
        
        books = service.getAllBooks();
        
        String authorName = "";
        int integerBook = 0;
        int authorID = 0;
        int fieldID = 0;
        String bookTitle  = "";
        String press = "";  
        String published = "";
        String fieldName = "";
        
        for(Book b : books){
           integerBook = b.getBookID();
           bookTitle = b.getTitle();
           press = b.getPressName();
           published = b.getDateOfPublication();
           auths = b.getAuthor();
           fields = b.getFieldsOfStudy();
           
           
//                for(Author r : auths){
//                    authorID = r.getAuthorID();
//                    authorName = r.getAuthorName();
//                    
//                }
//                for(Field f : fields){
//                    fieldID = f.getFieldID();
//                    fieldName = f.getFieldName();
//                }
        }
        String bookIdParameter = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookIdParameter);
        review.setBookID(bookID);
        
        String fieldIdParameter = request.getParameter("fieldID");
        fieldID = Integer.parseInt(fieldIdParameter);
        Field field = new Field();
        field = service.getField(fieldID);
        fields.add(field);
        review.setFieldsOfStudy(fields);
        String title = "";
        String text = "";
        title = request.getParameter("title");
        text = request.getParameter("text");
        book = service.getBook(bookID);
        review.setBook(book);

        service.createReview(review);
        return "redirect:displayBooksPage";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public String deleteBook(HttpServletRequest request) {
        String bookIdParameter = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookIdParameter);
        Book book = new Book();
        book = service.getBook(bookID);
        service.deleteBook(bookID);
        return "redirect:displayBooksPage";
    }
    
    @RequestMapping(value = "/displayUpdateBooksForm", method = RequestMethod.GET)
    public String displayEditBookForm(HttpServletRequest request, Model model) {
        List<Author> authorList = new ArrayList<>();
        String bookIdParameter = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookIdParameter);
        Book book = new Book();
        book = service.getBook(bookID);
        List<Field> fieldList = new ArrayList<>();
        List<Field> lotList = new ArrayList<>();
        List<Book> bList = new ArrayList<>();
        List<Author> aList = new ArrayList<>();
        for (Book b: bList) {
            Field field = new Field();
            Author author = new Author();
            int fieldID = 0;
            int authorID = 0;
            for(Author a : aList){
                authorID = a.getAuthorID();
                author = service.getAuthor(authorID);
                aList.add(author);
            }
            fieldList = b.getFieldsOfStudy();
            for(Field f : fieldList){
                fieldID = f.getFieldID();
                field = service.getField(fieldID);
                lotList.add(f);
            }
            book.setAuthor(authorList);
            book = service.getBook(bookID);
            book.setFieldsOfStudy(lotList);
        }
        
        model.addAttribute("fieldList", lotList);
        bList.add(book);
        model.addAttribute("bookList", bList);
        return "updateBooksForm";
    }

    @RequestMapping(value = "/updateReviews", method = RequestMethod.POST)
    public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "updateBookForm";
        }
        service.editBook(book);
        return "redirect:reviewsPage";
    }

    @RequestMapping(value = "/displayBookDetails", method = RequestMethod.GET)
    public String displayBook(HttpServletRequest request, Model model) {
        List<Book> bookList = new ArrayList<>();
        String bookIdParameter = request.getParameter("bookID");
        int bookID = Integer.parseInt(bookIdParameter);
        Book book = new Book();

        book = service.getBook(bookID);
        List<Author> authorList = new ArrayList<>();
        List<Field> fieldList = new ArrayList<>();
        List<Author> aList = new ArrayList<>();
        List<Field> fList = new ArrayList<>();
        int authorID = 0;
        Author author = new Author();
        Field field = new Field();
        int fieldID = 0;
        fieldList = book.getFieldsOfStudy();
        authorList = book.getAuthor();
        for(Author a : authorList){
            authorID = a.getAuthorID();
            author = service.getAuthor(authorID);
            aList.add(author);
        }
        for(Field f : fieldList){
            fieldID = f.getFieldID();
            field = service.getField(fieldID);
            fList.add(field);
        }
        model.addAttribute("authorList", aList);
        model.addAttribute("fieldList", fList);
        bookList.add(book);
        model.addAttribute("bookList", bookList);
        return "bookDetails";
    }
    
}