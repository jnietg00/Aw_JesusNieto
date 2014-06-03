<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title><fmt:message key = "title"/></title>
	<style>
		.error { color: red;}
	</style>
</head>

<body>
<h1><fmt:message key = "addauthorized.heading"/></h1>
<form:form method = "post" commandName = "addAuthorized">
	<table width = "95%" bgcolor = "f8f8ff" border = "0" cellspacing = "0" cellpadding = "5">
		<tr>
			<td align = "right" width = "20%"> Numeros del DNI : </td>
				<td width = "20%">
					<form:input path = "dniNumber"/>
				</td>
				<td width = "60%">

				</td>
		</tr>
		<br>
		<br>
		<tr>
			<td align = "right" width = "20%"> Letra del DNI : </td>
				<td width = "20%">
					<form:input path = "dniLetter"/>
				</td>
				<td width = "40%">
				</td>
		</tr>	
		<br>
		<br>
		<tr>
			<td align = "right" width = "20%"> Nombre : </td>
				<td width = "20%">
					<form:input path = "name"/>
				</td>
				<td width = "60%">
				</td>
		</tr>	
	</table>
	<br>
	<input type = "submit" value = "Execute">
</form:form>
<a href = "<c:url value = "hello.htm"/>">Home</a>
</body>
</html>