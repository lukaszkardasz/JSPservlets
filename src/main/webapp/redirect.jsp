<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 2019-03-03
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Redirected site</title>
</head>
<body>
<p1>REDIRECTED SITE</p1>


<jsp:useBean id="user" scope="session" class="pl.sda.model.User"/>
<section>
    <h1>
        Strona główna ${param.message}
    </h1>
    <h2>
        Jesteś zalogowany jako ${user.login}
        Twoje hasło to ${user.password}
        Jesteś w systemie ${user.role}


    </h2>
</section>
<h1>
    <c:if test="${ not (empty sessionScope.user) }">
        <a href="/logout">Wyloguj</a>
    </c:if>
</h1>


<c:if test="${ empty sessionScope.user}">
<jsp:include page="/something.jsp"/>
</c:if>
</body>
</html>
