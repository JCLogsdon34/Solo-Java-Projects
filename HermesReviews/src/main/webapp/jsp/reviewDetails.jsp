<%-- 
    Document   : reviewDetails
    Created on : Oct 31, 2018, 10:27:28 AM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Review Details</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/reviewscss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayReviewsPage">Hermes Reviews Main Page</a></li>
                </ul>    
            </div>
            <h1>Individual Review Details</h1>
            <hr/>
            <c:forEach var="currentField" items="${fieldList}">
                <p>
                    <a href="displayFieldDetails?fieldID=${currentField.fieldID}">
                        <c:out value="${currentField.fieldID}"/> 
                    </a>
                </p>
                <p>
                    <a href="displayFieldDetails?fieldID=${currentField.fieldName}">
                        <c:out value="${currentField.fieldName}"/>
                    </a>
                </p>
            </c:forEach> 
            <c:forEach var="currentReview" items="${reviewList}">
                <p>
                    Review ID: <c:out value="${currentReview.reviewID}"/>
                </p>
                <p>
                    Book ID: <c:out value="${currentReview.book.bookID}"/>
                </p>

                <p>
                    Book Name: <c:out value="${currentReview.book.bookName}"/> 
                </p>
                <p>
                    Review Text: <c:out value="${currentReview.text}"/> 
                </p>
            </c:forEach>                   
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>