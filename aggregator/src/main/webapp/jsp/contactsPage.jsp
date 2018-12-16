<%-- 
    Document   : contactsPage
    Created on : Dec 15, 2018, 4:20:40 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
    <head>
        <title>Contacts Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/myCss.css" rel="stylesheet">     
        <link href="${pageContext.request.contextPath}/css/aggregatorcss.css" rel="stylesheet">
        <link rel="icon" href="http://getbootstrap.com/favicon.ico">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
        <body>
            <div class="col-md-12">
                <h2>Aggregated Table</h2>
                <form action="getContact" class="form-horizontal" role="form" method="POST">     
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
                    <c:forEach var="currentContacts" items="${contacts}">
                <tr>
                    <td>
                        <a href="displayContactDetails?name=${currentContact.name}">
                            <c:out value="${currentContact.name}" />
                        </a>
                    </td>
                    <td>
                        <a href="displayContactDetails?name=${currentSighting.name}">
                            <c:out value="${currentContact.title}" />
                        </a>
                    </td>
                    <td>
                        <a href="displayContactDetails?name=${currentSighting.name}">
                            <c:out value="${currentContact.phoneNumber}" />
                        </a>
                    </td>
                    <td>
                        <a href="displayContactDetails?name=${currentSighting.name}">
                            <c:out value="${currentContact.webAddress}" />
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/aggregator.js"></script>
    </body>
</html>