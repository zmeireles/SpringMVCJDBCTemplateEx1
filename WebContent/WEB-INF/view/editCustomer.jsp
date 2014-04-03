<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit customer</title>

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
		<legend>Edit Customer</legend>
		<form:form method="post" action="/updateCustomer"
			modelAttribute="customer">
			<table>
				<tr>
					<td>Customer ID</td>
					<td><form:input path="custId" readonly="true"
							value="${map.customer.custId}" /></td>
				</tr>

				<tr>
					<td>First Name</td>
					<td><form:input path="firstName"
							value="${map.customer.firstName}" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName"
							value="${map.customer.lastName}" /></td>
				</tr>

				<tr>
					<td>Customer Type</td>
					<td><spring:bind path="custType">

							<core:forEach items="${map.custTypeList}" var="custTypeName">
								<core:choose>
									<core:when test="${custTypeName eq map.customer.custType}">
										<input type="radio" name="custType" value="${custTypeName}"
											checked="checked" />${custTypeName}
															</core:when>
									<core:otherwise>
										<input type="radio" name="custType" value="${custTypeName}" />${custTypeName}
															</core:otherwise>
								</core:choose>
							</core:forEach>

						</spring:bind></td>
				</tr>
				
				<tr>
					<td>Address</td>
					<td><spring:bind path="address"><textarea name="address">${map.customer.address}</textarea>
							</spring:bind></td>
				</tr>

				<tr>
					<td>City :</td>
					<td><spring:bind path="city">
							<select name="city">
								<core:forEach items="${map.cityList}" var="cityName">
									<core:choose>
										<core:when test="${cityName eq map.customer.city}">
											<option value="${cityName}" selected="selected">${cityName}</option>
										</core:when>
										<core:otherwise>
											<option value="${cityName}">${cityName}</option>
										</core:otherwise>
									</core:choose>
								</core:forEach>
							</select>
						</spring:bind></td>
				</tr>

				<tr>
					<td><input type="submit" value="Update Customer" /></td>
				</tr>

			</table>
		</form:form>
	</fieldset>
</body>
</html>