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
    <a href="<c:url value='/registerForm' />" id="registerLink">회원가입</a>
    <a href="<c:url value='/login/loginForm' />" id="loginLink">로그인</a>
    <button id="testBtn" type="button">버튼 테스트</button>
</div>
<script>

    const testBtn = document.querySelector('#testBtn');
    const userInfoSpan = document.querySelector('#user-info');
    const data = localStorage.getItem("access");
    const loginLink = document.querySelector('#loginLink');
    const registerLink = document.querySelector('#registerLink');
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

    if (data) {

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
            contentType: "application/json; charset=UTF-8", // Content-Type을 UTF-8로 설정
            dataType: "text", // 서버가 문자열을 반환하는 경우
            success: function (response) {
                if (response) {
                    loginLink.innerHTML = '';
                    loginLink.href = "/logout";
                    loginLink.id = "logout";
                    loginLink.textContent = `\${response}님이 접속하였습니다`;
                    registerLink.remove();

                    document.getElementById('logout').addEventListener('click', function (event) {
                        event.preventDefault(); // 기본 링크 동작 방지
                        localStorage.removeItem('access');// 로컬 스토리지 값 삭제

                        // 서버로 로그아웃 요청 전송
                        $.ajax({
                            url: '/logout',
                            method: 'post',
                            xhrFields: {
                                withCredentials: true
                            },
                            headers: {
                                'access': data,
                                'Content-Type': 'application/json'
                            },
                            success: function (response) {
                                if (!response) {
                                    alert("로그아웃 완료")
                                    location.href = '/';
                                }
                            }
                        })
                    });
                } else {
                    loginLink.innerHTML = '';
                    loginLink.href = "/login/loginForm";
                    loginLink.id = "loginLink";
                    loginLink.textContent = "로그인";
                }
            },
            error: function (xhr) {
                if (xhr.status === 401) {
                    console.log("error Code 401 : 토큰 만료되서 재발급됨 " + xhr.responseText)
                    $.ajax({
                        url: "/reissue",
                        type: "post",
                        xhrFields: {
                            withCredentials: true
                        },
                        success: function (response) {
                            localStorage.setItem("access", response);
                            location.href = '/';
                        },
                        error: function (xhr, status, error) {
                            console.log("에러 발생 for header.jsp xhr: ", xhr);
                            console.log("에러 발생 for header.jsp status: ", status);
                            console.log("에러 발생 for header.jsp error: ", error);
                        },
                    })
                }
                console.log("에러 발생 for header.jsp xhr: ", xhr.responseText);
            }
        });
    }

    testBtn.addEventListener('click', function () {

        if (data) {

            $.ajax({
                url: '/jwtLogin',
                type: 'post',
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
                    console.log("에러 발생 xhr: ", xhr);
                    console.log("에러 발생 status: ", status);
                    console.log("에러 발생 error: ", error);
                }
            });
        } else {
            alert("토큰이 없어");
        }
    })

</script>
</body>
</html>
