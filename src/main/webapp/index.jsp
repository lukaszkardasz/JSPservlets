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
<h4>
    Dzisiaj jest: <% out.println(java.time.LocalDate.now().toString());%>
</h4>

<section>

    <c:if test="${ empty sessionScope.user }">
        <section>
            <form action="/login" method="post">
                <input type="text" name="login">
                <input type="password" name="password">
                <input type="submit" value="Loguj">
            </form>
        </section>
    </c:if>

    <c:if test="${ not (empty sessionScope.user) }">
        <a href="/logout">Wyloguj</a>
    </c:if>

</section>
<c:forEach items="${requestScope.users}" var="usery">
    ${usery.login}<br>
</c:forEach>

</body>
</html>