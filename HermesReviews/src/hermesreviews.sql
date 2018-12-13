DROP DATABASE IF EXISTS bookreviewplatform;

CREATE DATABASE bookreviewplatform;

USE bookreviewplatform;

CREATE TABLE IF NOT EXISTS bookreviewplatform.fields (
 fieldID int(11) NOT NULL AUTO_INCREMENT,
 fieldName varchar(150) NOT NULL,
 PRIMARY KEY (fieldID),
 INDEX fieldName(fieldName)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.authors (
 authorID int(11) NOT NULL AUTO_INCREMENT,
 authorName varchar(150) NOT NULL,
 institution varchar(150) NOT NULL,
 PRIMARY KEY (authorID),
 INDEX authorName(authorName)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.books (
  bookID int(11) NOT NULL AUTO_INCREMENT,
  title varchar(250) NOT NULL,
  pressName varchar(150) NOT NULL,
  dateOfPublication varchar(150) NOT NULL,
  fieldOfStudyID int(11) NOT NULL,
  PRIMARY KEY (bookID),
  INDEX title(title),
  KEY field_idx(fieldOfStudyID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.book_author (
 bookAuthorID int(11) NOT NULL AUTO_INCREMENT,
 bookID int(11) NOT NULL,
 authorID int(11) NOT NULL,
 PRIMARY KEY (bookAuthorID),
 KEY fk_book_author_book_idx (bookID),
 KEY fk_book_author_author_idx (authorID),
 CONSTRAINT fk_book_author_books FOREIGN KEY (bookID) REFERENCES books(bookID),
 CONSTRAINT fk_book_author_authors FOREIGN KEY (authorID) REFERENCES authors(authorID) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.book_field (
  bookFieldID int(11) NOT NULL AUTO_INCREMENT,
  bookID int(11) NOT NULL,
  fieldID int(11) NOT NULL,
 PRIMARY KEY (bookFieldID),
 KEY fk_book_field_book_idx (bookID),
 KEY fk_book_field_field_idx (fieldID),
 CONSTRAINT fk_book_field_books FOREIGN KEY (bookID) REFERENCES books(bookID),
 CONSTRAINT fk_book_field_fields FOREIGN KEY (fieldID) REFERENCES fields(fieldID) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS bookreviewplatform.articles (
 articleID int(11) NOT NULL AUTO_INCREMENT,
 articleTitle varchar(150) NOT NULL,
 publicationName varchar(150) NOT NULL,
 dateOfPublication varchar(150) NOT NULL,
 author int(11) NOT NULL,
 field int(11) NOT NULL,
 PRIMARY KEY (articleID),
 INDEX articleTitle(articleTitle),
 INDEX publicationName(publicationName),
 KEY author_idx (author),
 KEY field_idx (field),
 CONSTRAINT fk_articles_authors FOREIGN KEY (author) REFERENCES authors(authorID),
CONSTRAINT fk_articles_fields FOREIGN KEY (field) REFERENCES fields(fieldID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.article_author (
 articleAuthorID int(11) NOT NULL AUTO_INCREMENT,
 articleID int(11) NOT NULL,
 authorID int(11) NOT NULL,
 PRIMARY KEY (articleAuthorID),
 KEY fk_article_author_articles_idx (articleID),
 KEY fk_article_author_authors_idx (authorID),
 CONSTRAINT fk_book_author_articles FOREIGN KEY (articleID) REFERENCES articles(articleID),
 CONSTRAINT fk_article_author_authors FOREIGN KEY (authorID) REFERENCES authors(authorID) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.article_field (
 articleFieldID int(11) NOT NULL AUTO_INCREMENT,
 articleID int(11) NOT NULL,
 fieldID int(11) NOT NULL,
 PRIMARY KEY (articleFieldID),
 KEY fk_article_field_articles_idx (articleID),
 KEY fk_article_field_field_idx (fieldID),
 CONSTRAINT fk_article_field_articles FOREIGN KEY (articleID) REFERENCES articles(articleID),
 CONSTRAINT fk_article_field_fields FOREIGN KEY (fieldID) REFERENCES fields(fieldID) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS bookreviewplatform.reviews (
 reviewID int(11) NOT NULL AUTO_INCREMENT,
 title varchar(150) NOT NULL,
 text longtext NOT NULL,
 field int(11) NOT NULL,
 PRIMARY KEY (reviewID),
 INDEX title(title),
 KEY field_idx (field),
 CONSTRAINT fk_reviews_fields FOREIGN KEY (field) REFERENCES fields(fieldID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.bookreviews (
 bookReviewID int(11) NOT NULL AUTO_INCREMENT,
 book int(11) NOT NULL,
 review int(11) NOT NULL,
 PRIMARY KEY (bookReviewID),
 KEY book_idx (book),
 KEY review_idx (review),
 CONSTRAINT fk_bookreviews_books FOREIGN KEY (book) REFERENCES books(bookID),
 CONSTRAINT fk_bookreviews_reviews FOREIGN KEY (review) REFERENCES reviews(reviewID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.articlereviews(
 articleReviewID int(11) NOT NULL AUTO_INCREMENT,
 article int(11) NOT NULL,
 review int(11) NOT NULL,
 PRIMARY KEY (articleReviewID),
 KEY article_idx (article),
 CONSTRAINT fk_articlereviews_articles FOREIGN KEY (article) REFERENCES articles(articleID),
 CONSTRAINT fk_articlereviews_reviews FOREIGN KEY (review) REFERENCES reviews(reviewID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS bookreviewplatform.review_bookreview (
 reviewBookID int(11) NOT NULL AUTO_INCREMENT,
 reviewID int(11) NOT NULL,
 bookReviewID int(11) NOT NULL,
 PRIMARY KEY (reviewBookID),
 KEY fk_review_bookreview_reviews_idx (reviewID),
 KEY fk_review_bookreview_bookreviews_idx (bookReviewID),
 CONSTRAINT fk_review_bookreview_reviews FOREIGN KEY (reviewID) REFERENCES reviews(reviewID),
 CONSTRAINT fk_review_bookreview_bookReviews FOREIGN KEY (bookReviewID) REFERENCES bookReviews(bookReviewID) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS bookreviewplatform. review_articlereview (
 reviewArticleID int(11) NOT NULL AUTO_INCREMENT,
 reviewID int(11) NOT NULL,
 articleReviewID int(11) NOT NULL,
 PRIMARY KEY (reviewArticleID),
 KEY fk_review_articlereview_reviews_idx (reviewID),
 KEY fk_review_articlereview_articlereviews_idx (articleReviewID),
 CONSTRAINT fk_review_articlereview_reviews FOREIGN KEY (reviewID) REFERENCES reviews(reviewID),
 CONSTRAINT fk_review_articlereview_articleReviews FOREIGN KEY (articleReviewID) REFERENCES articleReviews(articleReviewID) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;