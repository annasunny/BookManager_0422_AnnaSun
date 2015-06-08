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
<title>Book Manager</title>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>


<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" />
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
  
  

<!--[if lt IE 8]>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"></link>
<![endif]-->

<script type="text/javascript">
	function deleteBook(e) {
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
		xmlhttp.open("DELETE", "books/" + e.target.id, true);
		xmlhttp.send();
	}
</script>
</head>
<body>

<div class="container">
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Book Manager</a></li>
    <li><a href="#tabs-2">Books List</a></li>
    <li><a href="#tabs-3">Books Commons</a></li>
  </ul>
  <div id="tabs-1">
     
        <h1>
			Book Manager
		</h1>
		<div class="span-12 last">	
			<form:form modelAttribute="book" action="books" method="post" enctype="multipart/form-data">
			    <table>
				    <tr>
				        <td><form:label path="title" cssErrorClass="error">Title</form:label></td>
				        <td><form:input path="title" /> <form:errors path="title" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="author" cssErrorClass="error">Author:</form:label></td>
				        <td><form:input path="author" /> <form:errors path="author" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="quantity" cssErrorClass="error">Quantity:</form:label></td>
				        <td><form:input path="quantity" /> <form:errors path="quantity" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="coverPhotoFile" cssErrorClass="error">Cover Photo:</form:label></td>
				        <td><form:input path="coverPhotoFile" type="file" /> <form:errors path="coverPhotoFile" /></td>
				    </tr>
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Add Book"/>
				        </td>
				    </tr>
				</table>
			</form:form>
		</div>
    
  <div id="tabs-2">
   
    <div class="span-12 last"> 
			<h3>Books List</h3>
			<c:if test="${!empty bookList}">
				<table class="data">
					<tr>
						<th></th>
			    		<th>Title</th>
			    		<th>Author</th>
			    		<th>Quantity</th>
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
			        		<td><a href="#" id="${book.id}" onclick="deleteBook(event)">Delete</a></td>
			    		</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>

  </div>
  
  <div id="tabs-3">
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  </div>
</div>

</div>
</div>
</body>
</html>