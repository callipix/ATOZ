<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${empty loginId ? '/login/loginForm' : '/login/logout'}"/>
<c:set var="loginOut" value="${empty loginId ? 'Login' : loginId +='님이 접속하였습니다.'}"/>
<html>
<link rel="stylesheet" href="<c:url value='/css/header.css'/>">

<div class="topnav" id="myTopnav">
    <a href="/" class="active">Home</a>
    <c:if test="${empty loginId}">
        <a href="<c:url value='/registerForm'/>">Sign In</a>
    </c:if>
    <a href="/board/boardList">Board</a>
    <a href="<c:url value='${loginOutLink}'/>">${loginOut}</a>
    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>
</div>

<script>
    /* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
    const x = document.querySelector("#myTopnav");
    const form = document.querySelector("#loginForm");
    const overlay = document.querySelector("#overlay");
    const login = document.querySelector("#login");

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
</html>
