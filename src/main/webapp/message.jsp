<%--
  Created by IntelliJ IDEA.
  User: n2god
  Date: 2019-03-03
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${ not empty param.message }" >
    <section class="message">
        <h4 class="${ param.type }">${ param.message }</h4>
    </section>
</c:if>
