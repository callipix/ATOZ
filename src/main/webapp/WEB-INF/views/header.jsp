<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>

<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${empty loginId ? '/login/loginForm' : '/login/logout'}"/>
<c:set var="loginOut" value="${empty loginId ? 'Login' : loginId += '님이 접속하였습니다.'}"/>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
</head>
<body>
<div class="topnav" id="myTopnav">
    <a href="<c:url value='/' />" class="active">Home</a>
    <a href="<c:url value='/suggestions' />">Suggest</a>
    <c:if test="${empty loginId}">
        <a href="<c:url value='/registerForm' />">Sign In</a>
    </c:if>
    <a href="<c:url value='/board/boardList' />">Board</a>
    <a href="<c:url value='${loginOutLink}' />">${loginOut}</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
</div>
<script>
    // Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon
    const x = document.querySelector("#myTopnav");

    function myFunction() {
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }

    // Add event listeners to each tab link
    document.querySelectorAll('.topnav a').forEach(function(link) {
        link.addEventListener('click', function() {
            // Remove the active class from all links
            document.querySelectorAll('.topnav a').forEach(function(link) {
                link.classList.remove('active');
            });

            // Add the active class to the clicked link
            this.classList.add('active');
        });
    });
</script>
</body>
</html>