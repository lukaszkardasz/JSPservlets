<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 2019-03-03
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>included</title>
</head>
<body>
</br>
<c:forEach begin="1" end="4" step="1" varStatus="i">
    <h3>Zawartość posta do powtórzenia nr ${i.index}</h3>
</c:forEach>


<c:if test="${sessionScope.user.isAdmin()}">
    <a href="/users">
        pokaz uzytkownikow
    </a>
</c:if>
</br>


</body>
</html>
