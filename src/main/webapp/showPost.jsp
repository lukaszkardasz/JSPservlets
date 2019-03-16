<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 2019-03-10
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${ requestScope.posts }" var="post" >
    <section>
        <ul>
            <li>Id: ${ post.postId }</li>
            <li>data: ${ post.date }</li>
            <li>owner:${post.user}  </li>
            <p>Zawartość posta: ${ post.postData }</p>
        </ul>
        </br>
        <c:url var="deleteUrl" value="/deletePost">
            <c:param name="id" value="${ post.postId }" />
        </c:url>
        <c:if test="${ sessionScope.user.equals(post.user) || sessionScope.user.isAdmin() }">
        <a href="${deleteUrl}" > delete </a>
        </c:if>
    </section>
</c:forEach>

