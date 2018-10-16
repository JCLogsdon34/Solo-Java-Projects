<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/reviewscss.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <h1>Hermes Reviews</h1>
            <hr/>

            <div class="col-md-12">
                <h2>Dedicated to the smartest doggo in the World, Hermes!</h2>
                <a href="${pageContext.request.contextPath}/displayHomePage">Continue to Home Page</a>
                <img src="C:\Users\JCLog\Desktop\Java Solo Work\HermesReviews.jpeg"/>
                <h3>Our Patron Doggo, Hermes</h3>
            </div>

        </div> 
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/HermesReviews.js"></script>
    </body>
</html>
