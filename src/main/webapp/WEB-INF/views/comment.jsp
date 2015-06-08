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
<title>Comment Manager</title>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<!--[if lt IE 8]>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"></link>
<![endif]-->

<script type="text/javascript">
	function deleteComment(e) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
		  	xmlhttp = new XMLHttpRequest();
		}
		else { 
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		    	location.reload(true);
		    }
		}
		xmlhttp.open("DELETE", "" + e.target.id, true);
		xmlhttp.send();
	}
</script>

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
               <li><a href="/bookmanager/viewbooks">View Books</a></li>
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
			Comment Reviews
		</h1>
		<div class="span-12 last">	
			<form:form modelAttribute="comment" action="comments" method="post" enctype="multipart/form-data">
			    <table>
				    <tr>
				        <td>Title</td>
				        <td>${book.title}</td>
				    </tr>
				   <tr>
				        <td><form:label path="bookId" cssErrorClass="error">Book Id</form:label></td>
				        <td><form:input path="bookId" value="${book.id}"/> <form:errors path="bookId" /></td>
				    </tr> 
				    <tr>
				        <td><form:label path="byUser" cssErrorClass="error">ByUser:</form:label></td>
				        <td><form:input path="byUser" /> <form:errors path="byUser" /></td>
				    </tr>
				      <tr>
				        <td><form:label path="grade" cssErrorClass="error">Grade:</form:label></td>
				        <td><form:input path="grade"/> <form:errors path="grade" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="content" cssErrorClass="error">Content:</form:label></td>
				        <td><form:input path="content" type = "text" class = "form-control" rows="3"/> <form:errors path="content" /></td>
				    </tr>
				   
				 
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Add Comment"/>
				        </td>
				    </tr>
				</table>
			</form:form>
			 
			<h3>Comments</h3>
			<c:if test="${!empty commentList}">
				<table class="data">
					<tr>
						
			    		<th>Title</th>
			    		<th>ByUser</th>
			    		<th>Grade</th>
			    		<th>Content</th>
					</tr>
					<c:forEach items="${commentList}" var="comment">
			    		<tr>
			        		<td>${book.title}</td>
			        		<td>${comment.byUser}</td>
			        		<td>${comment.grade}</td>
			        		<td>${comment.content}</td>
			        		
			        		
			        		<td><a href="#" id="${comment.commentId}" onclick="deleteComment(event)">Delete</a></td>
			    		</tr>
			    		
			    		
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>