<%-- 
    Document   : contactsDetails
    Created on : Dec 16, 2018, 3:54:07 PM
    Author     : JCLog
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
    <head>
        <title>Contact Details</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
        <link href="${pageContext.request.contextPath}/css/aggregatorcss.css" rel="stylesheet">
        <link rel="icon" href="http://getbootstrap.com/favicon.ico">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
        <body>
            <div class="col-md-12">
                <h2>Search Results</h2>
            <table id="contacts" class="table table-hover">
                <tr>
                    <th width="10%">Name</th>
                    <th width="20%">Title</th>
                    <th width="20%">Phone Number</th>
                    <th width="10%">Web Address</th>
                </tr>
                    <c:forEach var="currentContacts" items="${contactList}">
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
