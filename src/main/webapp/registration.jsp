<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
${ pageContext.request.contextPath }>
${ pageContext.request.contextPath }/registration" method="post">
        <input type="text" name="login" placeholder="Login">
        <input type="password" name="password" placeholder="Hasło">
        <input type="password" name="repeatPassword" placeholder="Powtórz hasło">
        <input type="submit" value="Zarejestruj się">
    </form>
</section>

<jsp:include page="message.jsp">
    <jsp:param name="message" value="${ requestScope.message.value }"/>
    <jsp:param name="type" value="${ requestScope.message.type }"/>
</jsp:include>

</body>
</html>