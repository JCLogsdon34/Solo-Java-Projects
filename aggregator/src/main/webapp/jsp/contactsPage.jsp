<%-- 
    Document   : contactsPage
    Created on : Dec 15, 2018, 4:20:40 PM
    Author     : JCLog
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/aggregatorcss.css" rel="stylesheet">     
    </head>    
    <body>
        <div class="container">
            <hr>
            <div id="Links">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="${pageContext.request.contextPath}/"> <span class="glyphicon glyphicon-home"> </span></a></li>               
                </ul>
            </div>
            <div class="col-md-12">
                <h2>Aggregated Table</h2>
                <form action="getContact" class="form-horizontal" role="form" method="GET">     
                    <div class="form-group">
                        <label for="get-term" class="col-md-4 control-label"> Search Term:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="term" placeholder="term"/>                      
                        </div>       
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Get Contact"/>
                        </div>
                    </div>
                </form>
                <table id="contacts" class="table table-hover">
                    <tr>
                        <th width="10%">Name</th>
                        <th width="20%">Title</th>
                        <th width="20%">Phone Number</th>
                        <th width="10%">Web Address</th>
                    </tr>
                    <c:forEach var="currentContact" items="${contactList}">
                        <tr>
                            <td>
                                <a href="getContact?name=${currentContact.name}">
                                    <c:out value="${currentContact.name}" />
                                </a>
                            </td>
                            <td>
                                <a href="getContact?name=${currentSighting.name}">
                                    <c:out value="${currentContact.title}" />
                                </a>
                            </td>
                            <td>
                                <a href="getContact?name=${currentSighting.name}">
                                    <c:out value="${currentContact.phoneNumber}" />
                                </a>
                            </td>
                            <td>
                                <a href="getContact?name=${currentSighting.name}">
                                    <c:out value="${currentContact.webAddress}" />
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>         
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/aggregator.js"></script>
    </body>
</html>