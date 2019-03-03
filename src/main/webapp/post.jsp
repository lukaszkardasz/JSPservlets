<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello JSP</title>
</head>
<body>

    <%--przekazujemy stronę na którąchcemy przekierować--%>
    <jsp:forward page="redirect.jsp">
    <jsp:param name="message" value="something message"/>
    </jsp:forward>/>
    <section>
        <h1>Strona główna</h1>

    </section>

</body>
</html>