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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/aggregatorcss.css" rel="stylesheet">         
    </head>
    <body>
            <hr>
            <div id="Links">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="${pageContext.request.contextPath}/"> <span class="glyphicon glyphicon-home"> </span></a></li>               
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayContactsPage"> New Contacts Table </a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search</a></li>
                </ul>
            </div>
            <hr>
            <div class="container">
                <h2>Table Page</h2>
                <div class="col-md-8">
                    <iframe src="https://inventory.data.gov/dataset/post-secondary-universe-survey-2010-directory-information/resource/38625c3d-5388-4c16-a30f-d105432553a4/view/af9bf3eb-263f-4aed-a6f8-9902f6921a99"></iframe>
                </div>
            </div>    
            <br>
            <hr>
            <div class="container">
                <div class="col-md-8">
                    <img src="C:\Users\JCLog\Desktop\Java Solo Work\aggregator\Folding_and_Drawing_Table.jpg" alt="Table"/>
                </div>
            </div>    
        <hr>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/aggregator.js"></script>
    </body>
</html>