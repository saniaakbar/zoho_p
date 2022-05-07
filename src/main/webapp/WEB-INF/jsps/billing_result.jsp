<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ include file="menu.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Contacts</title>
</head>
<body>
<h2><a href= "billing">Billing Details</a></h2>
     <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Product_Name</th>
            <th>Amount</th>
            
          </tr>  
        
         <tr>
           <td>${bill.id}</td>
           <td>${bill.firstName}</td>
           <td>${bill.lastName}</td>
           <td>${bill.email}</td>
           <td>${bill.mobile}</td>
           <td>${bill.productName}</td>
           <td>${bill.amount}
           
          </tr> 
           
    </table>
</body>
</html>