<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>

<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${empty loginId ? '/login/loginForm' : '/login/logout'}"/>
<c:set var="loginOut" value="${empty loginId ? '로그인' : loginId += '님이 접속하였습니다.'}"/>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
</head>
<c:if test="${not empty loginId}">
    <script type="text/javascript">
        let loginId = true;
    </script>
</c:if>
<body>
<div class="topnav" id="myTopnav">
    <a href="<c:url value='/' />" class="active">Home</a>
    <a href="<c:url value='/errorBoard/list' />">에러게시판</a>
    <a href="<c:url value='/suggestions' />">건의사항</a>
    <a href="<c:url value='/board/boardList' />">자유게시판</a>
    <a href="<c:url value='/information' />">프로젝트소개</a>
    <a href="<c:url value='/profile' />">프로필</a>
    <c:if test="${empty loginId}">
        <script type="text/javascript">
            let loginId = false;
        </script>
        <a href="<c:url value='/registerForm' />">회원가입</a>
    </c:if>
    <a href="<c:url value='${loginOutLink}'/>">${loginOut}</a>
</div>
<script>
    // Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon
    const x1 = document.querySelector("#myTopnav");

    function myFunction() {
        if (x1.className === "topnav") {
            x1.className += " responsive";
        } else {
            x1.className = "topnav";
        }
    }

    // Add event listeners to each tab link
    document.querySelectorAll('.topnav a').forEach(function(link) {
        link.addEventListener('click', function () {
            // Remove the active class from all links
            document.querySelectorAll('.topnav a').forEach(function (link) {
                link.classList.remove('active');
            });

            // Add the active class to the clicked link
            this.classList.add('active');
        });
    });
</script>
</body>
</html>