<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true"%>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${empty loginId ? '/login/loginForm' : '/login/logout'}"/>
<c:set var="loginOut" value="${empty loginId ? 'Login' : loginId +='님이 접속하였습니다.'}"/><html>
<head>
    <title>미니프로젝트</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
</head>
<script>
const token = localStorage.getItem('token'); // 로컬 스토리지에서 토큰 읽기
alert(token);
$.ajax({
    url : "/test",
    type : "post",
    headers:{
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json'
    },
    data: JSON.stringify(token),
    success:function (result, textStatus , jqXHR){

    }
})
</script>
<body>

<jsp:include page="header.jsp" />

<jsp:include page="updateList.jsp" />
</body>
</html>
