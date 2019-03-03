<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formularz logowania</title>
</head>
<body>

<h1><b>Panel logowania</b></h1>

<jsp:include page="message.jsp">
    <jsp:param name="message" value="${ requestScope.message.value }"/>
    <jsp:param name="type" value="${ requestScope.message.type }"/>
</jsp:include>

<h4>
    Dzisiaj jest: <% out.println(java.time.LocalDate.now().toString());%>
</h4>
<c:choose>
<c:when test="${ empty sessionScope.user }">
<section>
    <section>
        <form action="/login" method="post">
            <input type="text" name="login">
            <input type="password" name="password">
            <input type="submit" value="Loguj">
        </form>
    </section>
    <a href="${ pageContext.request.contextPath }/registration">Zarejestruj się</a>
    </c:when>
    <c:otherwise>


    <a href="/logout">Wyloguj</a></li>
    </c:otherwise>
    </c:choose>


    <c:if test="${ sessionScope.user.isAdmin() }">
    <a href="${pageContext.request.contextPath}/users">Wyświetl użytkowników</a>
    </c:if>

    <c:forEach begin="5" end="10" step="1" varStatus="i">
    <h3>${ i.index }. Lorem ipsum dolor.</h3>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium amet animi aspernatur aut autem blanditiis
        culpa cum cupiditate, distinctio dolorem dolores ea eos et ex facilis fuga fugiat harum illum impedit incidunt
        laboriosam, libero nobis nulla quam qui quo ratione rem repellendus reprehenderit rerum saepe sed sequi unde ut
        voluptate?</p>
    </c:forEach>
</section>
</body>
</html>