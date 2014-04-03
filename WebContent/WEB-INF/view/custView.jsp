<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<fieldset>
			<legend>Customer List</legend>

			<table border="1">
				<tr>
					<td>Cust ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Type</td>
					<td>Address</td>
					<td>City</td>
				</tr>

				<core:forEach items="${custList}" var="custValues">
					<tr>
						<td>${custValues.custId}</td>
						<td>${custValues.firstName}</td>
						<td>${custValues.lastName}</td>
						<td>${custValues.custType}</td>
						<td>${custValues.address}</td>
						<td>${custValues.city}</td>
						<td><a href="editCustomer?custId=${custValues.custId}">Edit</a></td>
						<td><a href="deleteCustomer?custId=${custValues.custId}">Delete</a></td>
					</tr>
				</core:forEach>
			<tr><td><a href="register">New Customer</a></td></tr>
			</table>


		</fieldset>

	</center>
</body>
</html>