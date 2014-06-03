<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key = "title"/></title></head>
  <body>
    <h1><fmt:message key = "heading"/></h1>
    <p><fmt:message key = "greeting"/> <c:out value="${model.now}"/></p>
    <h3>Authorizeds</h3>
    <c:forEach items = "${model.authorizeds}" var = "auth">
    	<c:out value = "${auth.name}"/> <i><c:out value="${auth.dniNumber}"/></i><i><c:out value="${auth.dniLetter}"/></i><br> <br>
    </c:forEach>
    <br>
    <a href = "<c:url value = "addAuthorized.htm"/>">Anyadir autorizado</a>
    <br>
  </body>
</html>