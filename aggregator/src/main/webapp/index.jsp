<%-- 
    Document   : index
    Created on : Dec 15, 2018, 6:06:23 PM
    Author     : JCLog
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
    <head>
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/aggregatorcss.css" rel="stylesheet">     
        <link rel="icon" href="http://getbootstrap.com/favicon.ico">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <hr>
        <div id="Links">
            <ul class="nav nav-tabs">
                <li class="active"><a href="${pageContext.request.contextPath}/"> <span class="glyphicon glyphicon-home"> </span></a></li>               
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayContactsPage"> New Contacts Table </a></li>
            </ul>
        </div>
        <hr>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/aggregator.js"></script>
    </body>
</HTML>