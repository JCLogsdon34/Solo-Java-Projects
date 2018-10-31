<%-- 
    Document   : updateReviewForm
    Created on : Oct 31, 2018, 10:52:45 AM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Review Form</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/reviewscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Update An Individual Hermes Review</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Hermes Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayReviewsPage"> Hermes Reviews </a></li>
                </ul>    
            </div>
            <div class="container">
                <h1>Sighting Details:</h1>
                <hr>
                <sf:form class="form-horizontal" role="form" modelAttribute="review" action="updateReview" method="POST">
                    <div class="form-group">
                        <label for="add-review-bookID" class="col-md-4 control-label">Book ID:</label>
                        <div class="col-md-8">
                            <sf:input type="bookID" class="form-control" id="add-review-bookID"
                                      path="bookID" placeholder="Book ID Here"/>
                            <sf:errors path="bookID" cssclass="error"></sf:errors>
                        </div>
                        <div class="form-group">
                            <label for="add-review-text" class="col-md-4 control-label">Hermes Review Text:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="add-review-text"
                                          path="text" placeholder="Text"/>
                                <sf:errors path="review-text" cssclass="error"></sf:errors>
                            </div>
                            <sf:form class="form-horizontal" role="form" modelAttribute="book" action="updateReview" method="POST">
                                <div class="form-group">
                                    <label for="add-book-bookName" class="col-md-4 control-label">Book Name:</label>
                                    <div class="col-md-8">
                                        <sf:input type="text" class="form-control" id="add-book-name"
                                                  path="bookName" placeholder="Book Title"/>
                                        <sf:errors path="book-name" cssclass="error"></sf:errors>
                                    </div>
                                </div>
                            </sf:form>
                            <div class="form-group">
                                <label for="add-author-name" class="col-md-4 control-label">Author Name:</label>
                                <div class="col-md-8">
                                    <sf:input type="text" class="form-control" id="add-author-name"
                                              path="authorName" placeholder="Author Name"/>
                                    <sf:errors path="authorName" cssclass="error"></sf:errors>
                                </div>
                                <div class="form-group">
                                    <label for="add-author-institution" class="col-md-4 control-label">Author Institution:</label>
                                    <div class="col-md-8">
                                        <sf:input type="text" class="form-control" id="add-author-institution"
                                                  path="institution" placeholder="Institution"/>
                                        <sf:errors path="institution" cssclass="error"></sf:errors>
                                    </div>
                                </div>
                                </sf:form>
                                <sf:form class="form-horizontal" role="form" modelAttribute="field" action="updateFieldsOfStudy" method="POST">
                                    <div class="form-group">
                                        <label for="add-fieldID" class="col-md-4 control-label">Field ID:</label>
                                        <div class="col-md-8">
                                            <sf:input type="text" class="form-control" id="add-field-fieldID"
                                                      path="fieldID" placeholder="Field ID"/>
                                            <sf:errors path="field-fieldID" cssclass="error"></sf:errors>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="add-field-name" class="col-md-4 control-label">Field Name:</label>
                                        <div class="col-md-8">
                                            <sf:input type="text" class="form-control" id="add-address"
                                                      path="fieldName" placeholder="Field Name Here"/>
                                            <sf:errors path="fieldName" cssclass="error"></sf:errors>
                                        </div>
                                        <div class="form-group">
                                            <label for="update-fieldsOfStudy" class="col-md-4 control-label">Book Field(s) of Study:</label>
                                            <div class="col-md-8">
                                                <sf:input type="text" class="form-control" id="update-fieldsOfStudy"
                                                          path="fieldsOfStudy" placeholder="Field(s)"/>
                                                <sf:errors path="fieldsOfStudy" cssclass="error"></sf:errors>
                                            </div>
                                        </div>              
                                    </div>
                                </sf:form>

                                <!-- Placed at the end of the document so the pages load faster -->
                                <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
                                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
                                </body>
                                </html>