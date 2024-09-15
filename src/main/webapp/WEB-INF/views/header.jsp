<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <sec:authentication property="principal" var="principal"/>--%>
<%--</sec:authorize>--%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
</head>
<script>

</script>
<body>
<div class="topnav" id="myTopnav">
    <a href="<c:url value='/' />" class="active">Home</a>
    <a href="<c:url value='/errorBoard/list' />">에러게시판</a>
    <a href="<c:url value='/suggestions' />">건의사항</a>
    <a href="<c:url value='/board/boardList' />">자유게시판</a>
    <a href="<c:url value='/information' />">프로젝트소개</a>
    <a href="<c:url value='/profile' />">프로필</a>
    <a href="<c:url value='/registerForm' />">회원가입</a>
    <a href="<c:url value='/login/loginForm' />" id="loginOut">로그인</a>
    <button id="testBtn" type="button">버튼 테스트</button>
</div>
<script>
    const testBtn = document.querySelector('#testBtn');
    const userInfoSpan = document.querySelector('#user-info');
    const loginForm = document.querySelector('#loginOut');
    const data = localStorage.getItem("access");

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
    document.querySelectorAll('.topnav a').forEach(function (link) {
        link.addEventListener('click', function () {
            // Remove the active class from all links
            document.querySelectorAll('.topnav a').forEach(function (link) {
                link.classList.remove('active');
            });

            // Add the active class to the clicked link
            this.classList.add('active');
        });
    });

    $.ajax({
        url: '/jwtLogin',
        type: "post",
        xhrFields: {
            withCredentials: true
        },
        headers: {
            'access': data,
            'Content-Type': 'application/json'
        },
        success: function (response) {
            if (response) {
                loginForm.innerHTML = `<a href="/logout" id="logout">\${response}님이 접속하였습니다</a>`;

                document.getElementById('logout').addEventListener('click', function (event) {
                    event.preventDefault(); // 기본 링크 동작 방지

                    // 로컬 스토리지 값 삭제
                    localStorage.removeItem('access');

                    // 서버로 로그아웃 요청 전송
                    fetch('/logout', {
                        method: 'POST',
                        credentials: 'include'
                    }).then(response => {
                        if (response.ok) {
                            // 로그아웃 성공 시 로그인 페이지로 리다이렉트
                            location.href = '/';
                        } else {
                            alert('로그아웃 실패');
                        }
                    });
                });
            } else {
                // 로그아웃 상태일 때: 로그인 링크로 변경
                loginForm.innerHTML = `<a href="<c:url value='/login/loginForm' />" id="loginOut">로그인</a>`;
            }

        },
        error: function (xhr, status, error) {
            console.log("에러 발생: ", error);
        }
    });

    testBtn.addEventListener('click', function () {
        $.ajax({
            url: '/jwtLogin',
            type: "post",
            xhrFields: {
                withCredentials: true
            },
            headers: {
                'access': data,
                'Content-Type': 'application/json'
            },
            success: function (response) {
                if (response) {
                    alert(response);
                }
            },
            error: function (xhr, status, error) {
                console.log("에러 발생: ", error);
            }
        });
    })

</script>
</body>
</html>