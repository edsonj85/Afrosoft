<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: edsonj
  Date: 06/Sep/2016
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Music Site</title>
    
    <!-- jQuery -->
    <script   src="<c:url value="http://code.jquery.com/jquery-3.1.1.min.js" />"  type="text/javascript"></script>
    
    <!-- Data Table -->
    <script type="text/javascript" src="<c:url value="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js" />"></script>
    
    <!-- Angular JS-->
	<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"/>"></script>
	<script src="<c:url value="/resources/js/controller.js" />"></script>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    
    <link rel="stylesheet" href="<c:url value="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />">
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">eMusic</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/" />">Home</a></li>
                        <li><a href="<c:url value="/product/productList/all" />">Products</a></li>
                        <li><a href="<c:url value="/about" />">About Us</a></li>
                       
                    </ul>
                    
                    <ul class="nav navbar-nav pull-right">
                    	<c:if test="${pageContext.request.userPrincipal.name != null }">
                    		<li><a>Welecome: ${pageContext.request.userPrincipal.name}</a></li>
                    		<li><a href="/j_spring_security_logout">Logout</a></li>
                    		<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                    			<li><a href="<c:url value='/customer/cart'/>">Cart</a></li>
                    		</c:if>
                    		<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    			<li><a href="<c:url value='/admin'/>">Admin</a></li>
                    		</c:if>
                    	</c:if>
                    	<c:if test="${pageContext.request.userPrincipal.name == null }">
	                    	<li><a href="<c:url value="/login" />">Login</a></li>
	                    	<li><a href="<c:url value="/register" />">Register</a></li>
                    	</c:if>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>