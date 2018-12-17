<%-- 
    Document   : searchContacts
    Created on : Dec 17, 2018, 9:30:52 AM
    Author     : JCLog
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/aggregatorcss.css" rel="stylesheet">     
    </head>
    <body>
        <div class="container">
            <h1>Contacts</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"> 
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaycontactsPage">
                            Contacts
                        </a>
                    </li>
                    <li role="presentation"
                        class="active">
                        <a href="${pageContext.request.contextPath}/displaySearchPage">
                            Search
                        </a> 
                    </li>
                </ul>    
            </div>
            <!-- Main Page Content Start -->
            <ul class="list-group" id="errorMessages"></ul>
            <div class="row">
                <!-- 
                    Add a col to hold the summary table - have it take up half the row 
                -->
                <div class="col-md-6">
                    <h2>Search Results</h2>
                    <table id="contactTable" class="table table-hover">
                        <tr>
                            <th width="10%">Name</th>
                            <th width="20%">Title</th>
                            <th width="20%">Phone Number</th>
                            <th width="10%">Web Address</th>
                        </tr>
                        <tbody id="contentRows"/>
                    </table>                    
                </div> <!-- End col div -->
                <!-- 
                    Add col to hold the search form - have it take up the other 
                    half of the row
                -->
                <div class="col-md-6">
                    <h2>Search</h2>
                    <form class="form-horizontal" role="form" id="search-form">
                        <div class="form-group">
                            <label for="search-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-name" placeholder="Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-title" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-phone-number" class="col-md-4 control-label">Phone Number:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-phone-number" placeholder="Phone Number"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-web-address" class="col-md-4 control-label">Web Address:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-web-address" placeholder="Web Address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="button" class="btn btn-default" id="search-button" value="Search"/>
                            </div>
                        </div>
                    </form>

                </div> <!-- End col div -->

            </div> <!-- End row div -->
            <!-- Main Page Content Stop -->                 
        </div>                      
        <!-- Main Page Content Stop -->                 
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/aggregator.js"></script>
    </body>    
</html>

