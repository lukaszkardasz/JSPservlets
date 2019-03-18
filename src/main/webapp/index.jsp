<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="description"
          content="Bloguj o programowaniu i poznawaj ludzi o podobnych zainteresowaniach. Naucz się programowania i wszystkiego co chciałbyś wiedzieć o dystrybucji Kali Linux.">
    <meta http-equiv="X-UA-Compatible" content="ie=edge,chrome=1">
    <meta name="blog, programowanie, linux, Java, kali linux, kali, bloguj">
    <link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
    <title>n2God_blog</title>
</head>

<style>
    body {
        font-family: 'Lato', sans-serif;
    }
    #container{
        width: 1500px;
        margin-left: auto;
        margin-right: auto;
    }
    #logo{
        float: left;
        color: dodgerblue;
        margin-top: 20px;
        font-size: 44px;
        letter-spacing: 3px;
        font-weight: 900;
        width: 750px;
    }
    #login{
        float: right;
        padding: 40px;
        width: 630px;
        background-color: white;
    }
    #topbar{
        text-align: center;
        font-size: 16px;
        clear: both;
    }
    #sidebar{
        float: left;
        width: 750px;
        min-height: 400px;
        padding: 20px;
        background-color: dodgerblue;
        text-align: center;
        font-size: 24px;
        color: white;
        vert-align: middle;

    }
    #registerOrLogin{
        display: flex;
        justify-content: center; /* align horizontal */
        align-items: center; /* align vertical */
    }
    #content{
        clear:both;
    }
    #footer{
        min-height: 50px;
        text-align: center;
    }



</style>

<body>
<!--container-->
<div id="container">
    <!--logo-->
    <div id="logo">
        <a href="index.jsp">n2God Blog</a>
    </div>
    <!--login-->
    <div id="login">
        <c:choose>
            <c:when test="${ empty sessionScope.user }">
                <section>
                    <form action="${ pageContext.request.contextPath }/login" method="post">
                        <input type="text" name="login" placeholder="Login">
                        <input type="password" name="password" placeholder="Hasło">
                        <input type="submit" value="Loguj">
                    </form>
                </section>
                <a href="${ pageContext.request.contextPath }/registration">Zarejestruj się</a>
            </c:when>
            <c:otherwise>
                <a href="${ pageContext.request.contextPath }/logout">Wyloguj</a>
            </c:otherwise>
        </c:choose>
    </div>
    <!--tpbar-->
    <div id="topbar">
        <jsp:include page="message.jsp">
            <jsp:param name="message" value="${ requestScope.message.value }"/>
            <jsp:param name="type" value="${ requestScope.message.type }"/>
        </jsp:include>
    </div>
    <!--sidebar-->
    <div id="sidebar">
            Obserwuj to, co Cię interesuje.</br>
            Dowiedz się, o czym rozmawiają inni.</br>
            Dołącz do rozmowy!
    </div>
    <!--registerOrLogin-->
    <div id="registerOrLogin">
        Zobacz, co piszą w tej chwili</br>
        </br>
        Dołącz już dziś!</br>
        Zarejestruj się</br>
        Zaloguj się
    </div>
    <!--content-->
    <div id="content">
        <c:if test="${ sessionScope.user.isAdmin() }">
            <a href="${pageContext.request.contextPath}/users">Wyświetl użytkowników</a>
        </c:if>

        <c:if test="${ not empty sessionScope.user }">
            <form action="${pageContext.request.contextPath}/add-post" method="post">
                <textarea name="text" placeholder="Napisz coś"></textarea>
                <input type="submit" value="Wyślij">
            </form>
        </c:if>

        <jsp:include page="/posts"/>
    </div>
    <!--footer-->
    <div id="footer">
        n2God Blog &copy; Wszelkie prawa zastrzeżone.
    </div>
</div>
</body>
</html>