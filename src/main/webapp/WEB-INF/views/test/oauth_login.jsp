<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>

<h3>Login with:</h3>
<c:forEach var="url" items="${urls}">
    <a href="${url.value}">${url.key}</a> Client
</c:forEach>
</body>
</html>
