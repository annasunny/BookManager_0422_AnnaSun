<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View Books List</title>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<!--[if lt IE 8]>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"></link>
<![endif]-->


<!-- From bootstrpt  -->
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   <!--  <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico"> -->

    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/carousel/carousel.css" rel="stylesheet">
  





</head>

<body>


	<div class="container">
	
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/bookmanager">Good to Read</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
               <li class="active"><a href="/bookmanager">Home</a></li>
                <li><a href="/bookmanager/viewbooks.htm">View Books</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
	
	
		<h1>
			View Books List
		</h1>
		<div class="span-12 last">	

			<c:if test="${!empty bookList}">
				<table class="data">
					<tr>
						<th></th>
			    		<th>Title</th>
			    		<th>Author</th>
			    		<th>Level</th>
			    		<th>Discription</th>
					</tr>
					<c:forEach items="${bookList}" var="book">
			    		<tr>
			    			<td>
			    				<c:if test="${fn:length(book.coverPhoto) > 0}">
			    					<img src="books/${book.id}/photo" />
			    				</c:if>
			    			</td>
			        		<td>${book.title}</td>
			        		<td>${book.author}</td>
			        		<td>${book.quantity}</td>
			        		<td>${book.discription}</td>
			        		
			        		
			        		<td> <a href="comments/${book.id}" >View Comments</a> </td>
			        		
			    		</tr>	    		
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>