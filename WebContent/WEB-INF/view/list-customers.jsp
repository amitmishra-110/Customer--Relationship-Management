<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
	<link
	 type="text/css" 
		rel="stylesheet"  
		href="${pageContext.request.contextPath}/resources/css/style.css"
	/>

<meta charset="ISO-8859-1">
<title>List Customers</title>
</head>

<body>
 <div id ="wrapper">
 	<div id ="header">
			 <h2>CRM Application</h2>
 
 	</div>
 
	 <div id="container">
	 	<div id="content">
	 	
	 	<!-- Adding a new button for customer -->
	 	
	 	<input type='button' value="Add Customer"
		onClick="window.location.href='showFormForAdd'; return false;"
	 	 class="add-button"/>
	 	
	 	<!-- Adding HTML TABLE -->
	 	
	 	<table>
	 		<tr>
		 		<th>First Name</th>
		 		<th>Last Name</th>
		 		<th>Email</th>
	 		
	 		</tr>
	 		
	 		<!-- Looping over and printing customer -->
	 		
	 		<c:forEach var="tempCustomer" items="${Customers}"> 
	 		
	 		
	 		<tr>
		 		<td>${tempCustomer.firstName}</td>
		 		<td>${tempCustomer.lastName}</td>
		 		<td>${tempCustomer.emial}</td>
	 		<tr>
	 		
	 		</c:forEach>
	 		
	 	
	 	</table>
	 	
	 	</div>
 
 
 	</div>
 
 </div>

</body>
</html>