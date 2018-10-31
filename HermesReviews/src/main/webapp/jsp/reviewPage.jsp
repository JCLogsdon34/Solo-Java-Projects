<%-- 
    Document   : reviewPage
    Created on : Oct 31, 2018, 10:39:03 AM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reviews Main Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/reviewscss.css" rel="stylesheet">
        <script>
            if (${currentReview.reviewID} === ${currentReview.reviewID}) {
                var bookID = <c:out value="${currentReview.book.bookID}"/>
                var bookName = <c:out value="${currentReview.book.bookName}"/>
                var fieldID = <c:out value="${currentField.fieldID}"/>
                var fieldName = <c:out value="${currentField.fieldName}"/>
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1>Hermes All Reviews Page</h1>
            <hr/>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage"> Sightings </a></li>
            </ul>   

            <h2> Reviews </h2>
            <div class="col-md-12">
                <h2>Hermes Reviews Table</h2>
                <h4>*Books covered in a review are available on clicking a list item</h4>
                <table id="reviews" class="table table-hover">
                    <tr>
                        <th width="10%">Review ID</th>
                        <th width="20%">Book ID</th>
                        <th width="20%">Book Name</th>
                        <th width="10%">Field(s) of Study</th>
                        <th width="10%"></th>
                        <th width="10%"></th>
                    </tr>

                    <c:forEach var="currentReview" items="${reviews}">
                       
                            <tr>
                                <td>
                                    <a href="displayReviewDetails?reviewID=${currentReview.reviewID}">
                                        <c:out value="${currentReview.reviewID}"/> 
                                    </a>
                                </td>
                                <td>
                                    <a href="displayReviewDetails?bookID=${currentReview.bookID}">
                                        <c:out value="${currentReview.bookID}"/>
                                    </a>
                                </td>
                                <td>
                                        <c:out value="${currentReview.bookName}"/>                                  
                                </td>
                                <td>                           
                                        <c:out value="${currentReview.fieldsOfStudy}"/>
                                </td>
                                <td>
                                    <a href="displayUpdateReviewsForm?reviewID=${currentReview.reviewID}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteReview?reviewID=${currentReview.reviewID}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                </table>                    
            </div>
            
            <div class="col-md-8">
                <h2>Add New Hermes Review</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createReview">
                    <div class="form-group">
                        <label for="add-review-bookID" class="col-md-4 control-label">Book ID:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="bookID" placeholder="Book ID"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-bookName" class="col-md-4 control-label">Book Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="bookName" placeholder="Book Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-fieldID" class="col-md-4 control-label">Field ID:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="fieldID" placeholder="Field ID"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Review"/>
                        </div>
                    </div>
                </form>
            </div>
        </div> <!-- End col div --> <!-- End row div -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/superHeroSightings.js"></script>
    </body>
</html>
