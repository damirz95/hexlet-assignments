<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Example</title>
    </head>
    <body>
        <div><%= request.getAttribute("message") %></div>
        <div>
            <c:if test="${!name.equals(null)}">
                <c:out value="${name}" />
            </c:if>
            <c:if test="${name.equals(null)}">
                <c:out value="Hello, Guest!" />
            </c:if>
        </div>
    </body>
</html>
