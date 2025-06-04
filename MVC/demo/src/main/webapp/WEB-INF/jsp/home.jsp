<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome to Home Page</h1>
    <h2>Name: <c:out value="${name}" /></h2>
    <h2>Id: <c:out value="${id}" /></h2>
    <h2>Names:
        <c:forEach var="name" items="${names}">
            <c:out value="${name}" />
        </c:forEach>
    </h2>
</body>
</html> 