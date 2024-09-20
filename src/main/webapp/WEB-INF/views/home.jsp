<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>미니프로젝트</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/cursorEffect.css'/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
</head>
<script>
    // $.ajaxSetup({
    //     beforeSend: function (xhr) {
    //         const token = localStorage.getItem('access'); // 로컬 스토리지에서 JWT 토큰을 가져옴
    //         if (token) {
    //             xhr.setRequestHeader('access', token);
    //         }
    //     }
    // });
</script>
<body>
<%--<jsp:include page="headerTest.jsp"/>--%>
<jsp:include page="header.jsp"/>
<jsp:include page="updateList.jsp"/>
</body>
</html>
