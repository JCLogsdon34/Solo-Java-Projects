<%-- 
    Document   : homePage
    Created on : Oct 31, 2018, 10:06:53 AM
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
        <title>Home Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/reviewscss.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <h1>Hermes Reviews Hom</h1>
            <hr/>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHomePage">Home</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage"> Sightings </a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPowersPage">Super Powers</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayHerosPage">Heros</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search Page</a></li>
            </ul>   



            <div class="col-md-12">
                <h2>Hermes Main Page</h2>

            </div>

            <div class="col-md-12">
                <h3>Most Recent Ten Reviews</h3>
                <h4>*Look at the book by clicking a review</h4>
                <table id="lastTenReviews" class="table table-hover">
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
                                        <c:out value="${currentReview.book.bookID}"/>
                                </td>
                                <td>     
                                        <c:out value="${currentReview.book.bookName}"/>                                   
                                </td>
                                <td>                        
                                        <c:out value="${currentSighting.book.fields}"/>
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
        </div> 
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>