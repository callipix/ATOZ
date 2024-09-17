<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<html>
<head>
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value='/css/header.css'/>">
<style>
    /* Bordered form */
    form {
        border: 3px solid #f1f1f1;
        width: 100%;
    }

    /* Full-width inputs */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    /* Add a hover effect for buttons */
    button:hover {
        opacity: 0.8;
    }

    /* Extra style for the cancel button (red) */
    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    /* Center the avatar image inside this container */
    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }

    /* Avatar image */
    img.avatar {
        width: 40%;
        /*border-radius: 50%;*/
    }

    /* Add padding to containers */
    .container {
        padding: 16px;
    }

    /* The "Forgot password" text */
    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }

        .cancelbtn {
            width: 100%;
        }
    }

    #loginForm {
        display: block;
        width: 20%; /* 폼을 50%로 축소 */
        margin: 0 auto; /* 수평 중앙 정렬 */
        position: fixed; /* 화면 중앙에 위치시키기 위해 고정 위치 사용 */
        top: 50%; /* 수직 중앙 정렬 */
        left: 50%; /* 수평 중앙 정렬 */
        transform: translate(-50%, -50%); /* 정확히 중앙에 위치시키기 위해 변환 사용 */
        background-color: white;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        border-radius: 10px;
    }

    /* Add a black background color to the top navigation */
    .topnav {
        background-color: #333;
        overflow: hidden;
        margin: auto;
        max-width: 1300px;
        /*width: 1300px;*/
        height: 51px;
        /*margin: 0px 100px 0px 100px;*/
        border: none;
        box-sizing: border-box;
        text-align: center;
    }

    /* Style the links inside the navigation bar */
    .topnav a {
        float: right;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    /* Change the color of links on hover */
    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    /* Add an active class to highlight the current page */
    .topnav a.active {
        background-color: #04AA6D;
        color: white;
    }

    /* Hide the link that should open and close the topnav on small screens */
    .topnav .icon {
        display: none;
    }

    Add media queries
    Example

    /* When the screen is less than 600 pixels wide, hide all links, except for the first one ("Home"). Show the link that contains should open and close the topnav (.icon) */
    @media screen and (max-width: 600px) {
        .topnav a:not(:first-child) {
            display: none;
        }

        .topnav a.icon {
            float: right;
            display: block;
        }
    }

    /* The "responsive" class is added to the topnav with JavaScript when the user clicks on the icon. This class makes the topnav look good on small screens (display the links vertically instead of horizontally) */
    @media screen and (max-width: 600px) {
        .topnav.responsive {
            position: relative;
        }

        .topnav.responsive a.icon {
            position: absolute;
            right: 0;
            top: 0;
        }

        .topnav.responsive a {
            float: none;
            display: block;
            text-align: left;
        }
    }

    body {
        margin: 0 200px;
    }
</style>
<body>
<div class="topnav" id="myTopnav">
    <a href="<c:url value='/' />" class="active">Home</a>
    <a href="<c:url value='/errorBoard/list' />">에러게시판</a>
    <a href="<c:url value='/suggestions' />">건의사항</a>
    <a href="<c:url value='/board/boardList' />">자유게시판</a>
    <a href="<c:url value='/information' />">프로젝트소개</a>
    <a href="<c:url value='/profile' />">프로필</a>
    <c:if test="${empty loginId}">
        <a href="<c:url value='/registerForm' />">회원가입</a>
    </c:if>
</div>
<form action="#" id="loginForm">
    <div class="container">
        <label for="id"><b>ID</b></label>
        <input type="text" placeholder="아이디를 입력하세요" id="id" name="id" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="패스워드를 입력하세요" id="password" name="password" required>

        <button type="button" id="loginClick">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>
    <div style="text-align: center">
        <h4>소셜 로그인</h4>
        <a href="<c:url value='/oauth2/authorization/google'/>">
            <img src="<c:url value='/img/free-icon-google-300221.png'/>" alt="google"
                 width="50" height="50px"/>
        </a>
    </div>
    <br/>
    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>
</div>
<script>
    /* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
    const x = document.querySelector("#myTopnav");
    const form = document.querySelector("#loginForm");
    const overlay = document.querySelector("#overlay");
    const id = document.querySelector('#id');
    const password = document.querySelector('#password');
    const loginClick = document.querySelector('#loginClick');

    function myFunction() {
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
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
            link.classList.add('active');
        });
    });

    function hideForm() {
        form.style.display = "none";
        overlay.style.display = "none";
    }

    $(document).ready(function () {

        loginClick.addEventListener('click', function (event) {
            event.preventDefault();
            let idVal = id.value;
            let passVal = password.value;

            let data = {
                "username": idVal,
                "password": passVal
            };

            $.ajax({
                url: "/login",
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                headers: {
                    'Content-Type': 'application/json',
                },
                contentType: "application/json", // Content type 설정
                data: JSON.stringify(data),
                success: function (result, textStatus, jqXHR) {
                    localStorage.setItem("access", jqXHR.getResponseHeader("access"));
                    location.href = "/";
                },
                error: function (xhr, status, error) {
                    console.log("에러 발생 loginForm xhr: ", xhr);
                    console.log("에러 발생 loginForm status: ", status);
                    console.log("에러 발생 loginForm error: ", error);
                }
            })
        })
    })

</script>
</body>
</html>
