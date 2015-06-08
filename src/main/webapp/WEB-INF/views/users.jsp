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
<title>User Manager</title>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<!--[if lt IE 8]>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection"></link>
<![endif]-->

<script type="text/javascript">
	function deleteUser(e) {
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
		xmlhttp.open("DELETE", "users/" + e.target.userId, true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<div class="container">
		<h1>
			User Manager
		</h1>
		<div class="span-12 last">	
			<form:form modelAttribute="user" action="users" method="post" enctype="multipart/form-data">
			    <table>
				    <tr>
				        <td><form:label path="username" cssErrorClass="error">Username</form:label></td>
				        <td><form:input path="username" /> <form:errors path="username" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="password" cssErrorClass="error">Password:</form:label></td>
				        <td><form:input path="password" /> <form:errors path="password" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="userDetail" cssErrorClass="error">UserDetail:</form:label></td>
				        <td><form:input path="userDetail" /> <form:errors path="userDetail" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="coverPhotoFile" cssErrorClass="error">Cover Photo:</form:label></td>
				        <td><form:input path="coverPhotoFile" type="file" /> <form:errors path="coverPhotoFile" /></td>
				    </tr>
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Add User"/>
				        </td>
				    </tr>
				</table>
			</form:form>
			 
			<h3>Users</h3>
			<c:if test="${!empty userList}">
				<table class="data">
					<tr>
						<th></th>
			    		<th>Username</th>
			    		<th>Password</th>
			    		<th>UserDetail</th>
					</tr>
					<c:forEach items="${userList}" var="user">
			    		<tr>
			    			<td>
			    				<c:if test="${fn:length(user.coverPhoto) > 0}">
			    					<img src="users/${user.userId}/photo" />
			    				</c:if>
			    			</td>
			        		<td>${user.username}</td>
			        		<td>${user.password}</td>
			        		<td>${user.userDetail}</td>
			        		<td><a href="#" id="${user.userId}" onclick="deleteUser(event)">Delete</a></td>
			    		</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>