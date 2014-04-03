<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>

<title>Register The Customer</title>
<style type="text/css">
body {
	font-size: 20px;
	color: navy;
	font-family: inherit;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 20px;
	text-align: left;
}
</style>

</head>
<body>
	<fieldset>
		<legend>Customer Creation</legend>
		<form:form method="post" action="/insertCustomer" modelAttribute="customer">
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td>Customer Type</td>
 					<td><form:radiobuttons path="custType"
 							items="${map.custTypeList}" /></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><form:textarea path="address" /></td>
				</tr>

				<tr>
					<td>City :</td>
					<td><form:select path="city" items="${map.cityList}"></form:select>
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="Save Customer"/></td>
				</tr>
			</table>
		</form:form>

	</fieldset>

</body>
</html>