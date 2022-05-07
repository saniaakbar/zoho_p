<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead | create</title>
</head>
<body>

      <h2>Lead | Create</h2>
      <form action="generate" method="post"> 
         <pre>
             First Name<input type="text" name="firstName" value="${contacts.firstName}"/>
		      Last Name<input type="text" name="lastName" value="${contacts.lastName}"/>
		      Email<input type="text" name="email" value="${contacts.email}"/>
		      Mobile<input type="text" name="mobile" value="${contacts.mobile}"/>
		      Product Name <input type="text" name="productName"/>
		      Amount Paid<input type="text" name="amount"/>
		      <input type="submit" value="generateBill"/>  
         </pre>
      </form>
</body>
</html>