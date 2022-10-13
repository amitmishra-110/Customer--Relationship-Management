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
		 		<th>Action</th>
	 		
	 		</tr>
	 		
	 		<!-- Looping over and printing customer -->
	 		
	 		<c:forEach var="tempCustomer" items="${Customers}"> 
	 		
	 		
	 		<!-- Developing Update link  with embedded customer id -->
	 		
	 		<!-- Creating a variable to hold customer id for each display customer -->
	 		<c:url var="updateLink" value="/customer/showFormForUpdate	">
	 		<c:param name="customerId" value="${tempCustomer.id}"></c:param>
	 		</c:url>
	 		
	 		
	 		<c:url var="deleteLink" value="/customer/Delete">
	 		<c:param name="customerId" value="${tempCustomer.id}"> </c:param>
	 		</c:url>
	 		
	 		<tr>
		 		<td>${tempCustomer.firstName}</td>
		 		<td>${tempCustomer.lastName}</td>
		 		<td>${tempCustomer.emial}</td>
		 		<!-- Display the update variable in table -->
		 		<td><a href="${updateLink}">Update</a></td>
				
				<td>|<a href="${deleteLink}"  
				onClick="if(!(confirm('Are you sure you want to delete?'))) return false"
				>Delete</a></td>		 		
	 		<tr>
	 		
	 		
	 		
	 		</c:forEach>
	 		
	 	
	 	</table>
	 	
	 	</div>
 
 
 	</div>
 
 </div>

</body>
</html>