<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="<c:url value='/css/header.css'/>">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<body>
<br>
<div id="formDiv" class="formDiv">
    <form action="action_page">
        <div class="container">
            <h1>회원가입</h1>
            <p>아래에 있는 정보를 입력해주세요.</p>
            <hr>

            <div>

                <div class="idForm" style="display: flex">
                    <div>
                        <label for="id"><b>아이디  <span>* 필수입력사항입니다.</span></b></label>
                    </div>
                    <div style="margin-left: auto">
                        <button class="button">중복체크</button>
                    </div>
                </div>
                <input type="text" placeholder="아이디를 입력하세요." name="id" id="id" required>
            </div>
            <br>
            <div>
                <label for="psw"><b>비밀번호  <span>* 필수입력사항입니다.</span></b></label>
                <input type="password" placeholder="비밀번호를 입력하세요" name="psw" id="psw" required>
                <label for="psw-repeat"></label>
                <input type="password" placeholder="비밀번호를 다시 한번 입력하세요" name="psw-repeat" id="psw-repeat" required>
            </div>
            <br>
            <label for="nickName"><b>닉네임  <span>* 필수입력사항입니다.</span></b></label>
            <input type="text" placeholder="닉네임을 입력하세요." name="nickName" id="nickName" required>
            <br>
            <label for="name"><b>이름  <span>* 필수입력사항입니다.</span></b></label>
            <input type="text" placeholder="이름을 입력하세요." name="name" id="name" required>
            <br>
            <label for="email"><b>이메일  <span>* 필수입력사항입니다.</span></b></label>
            <input type="text" placeholder="이메일을 입력하세요." name="email" id="email" required>
            <br>
            <div style="display: flex">
                <label for="phoneNo"><b>연락처  <span>* 필수입력사항입니다.</span></b></label>
                <div style="margin-left: auto">
                    <button class="button">인증번호 발송</button>
                </div>
            </div>
            <input type="text" placeholder="연락처를 입력하세요." name="phoneNo" id="phoneNo" required>
            <br>
            <label>
                <input type="checkbox" id="consentCheckbox"> 개인정보 이용에 동의합니다
            </label>
            <br>
            <br>
            <button type="submit" class="registerbtn">가입하기</button>
        </div>

        <div class="container signin">
            <p>이미 가입된 계정인가요? <a href="#"><b>login</b></a></p>
        </div>
    </form>
</div>
</body>
</html>
