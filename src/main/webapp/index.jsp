<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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
    <form action="/login" method="post">
        <input type="text" name="login">
        <input type="password" name="password">
        <input type="submit" value="Loguj">
    </form>
</section>

</body>
</html>