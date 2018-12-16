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

        <div class="modal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">JScript</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"></span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>This site is best viewed with JavaScripts enabled.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Save changes</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div id="Links">
            <ul class="nav nav-tabs">
                <li class="active"><a href="file:///C:/Users/JCLog/Desktop/Java Solo Work/aggregator/src/main/webapp/index.jsp"> <span class="glyphicon glyphicon-home"> </span></a></li>
                <li><a href="https://inventory.data.gov/dataset/032e19b4-5a90-41dc-83ff-6e4cd234f565/resource/38625c3d-5388-4c16-a30f-d105432553a4/download/postscndryunivsrvy2013dirinfo.csv"> Goverment Web Page </a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/displayContactsPage">New Contacts Table </a></li>
            </ul>
        </div>
        <hr>
        <div style="text-align:center">
            <h2>Original Table</h2>
                <iframe width="700" height="400" src="https://inventory.data.gov/dataset/post-secondary-universe-survey-2010-directory-information/resource/38625c3d-5388-4c16-a30f-d105432553a4/view/af9bf3eb-263f-4aed-a6f8-9902f6921a99" frameBorder="0"></iframe>
        </div>
        <hr>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/aggregator.js"></script>
    </body>
</HTML>