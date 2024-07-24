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
<link rel="stylesheet" href="<c:url value='/css/register.css'/>">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<body>
<br>
<div id="formDiv" class="formDiv">
    <form id="signUpForm" method="post" action="<c:url value='/register/'/>">
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
                        <button id="idCheck" type="button" class="button">중복체크</button>
                    </div>
                </div>
                <input type="text" placeholder="아이디를 입력하세요." name="id" id="id" required>
            </div>
            <br>
            <div>
                <label for="password"><b>비밀번호  <span>* 필수입력사항입니다.</span></b></label>
                <input type="password" placeholder="비밀번호를 입력하세요" name="password" id="password" required>
                <label for="confirmPassword"></label>
                <input type="password" placeholder="비밀번호를 다시 한번 입력하세요" name="confirmPassword" id="confirmPassword" required>
                <br>
                <span id="passPatternCheck"></span>
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
                    <button class="button" type="button" id="sendCertifyNo" onclick="sendVerification()">인증번호 발송</button>
                </div>
            </div>
            <input type="text" placeholder="연락처를 입력하세요." name="phoneNo" id="phoneNo" required>
            <input type="text" placeholder="인증번호를 입력하세요." name="certiNo" id="certiNo" required>
            <div style="margin-left: auto">
                <button class="button" type="button" id="certifyCheck" onclick="phoneNoCertify()">인증번호 확인</button>
            </div>
            <br>
            <label>
                <input type="checkbox" id="consentCheckbox"> 개인정보 이용에 동의합니다
            </label>
            <br>
            <br>
            <button type="submit" class="registerBtn">가입하기</button>
        </div>

        <div class="container signin">
            <p>이미 가입된 계정인가요? <a href="#"><b>login</b></a></p>
        </div>
    </form>
</div>
<script type="text/javascript">

    // 정규식 체크
    const regId = /^[a-zA-Z0-9]{8,12}$/i;                                                    // 아이디 정규식
    const regPwd = /^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*(),.?":{}|<>]{8,20}$/;                 // 비밀번호 정규식
    const regEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;                    // 이메일 정규식
    const regName = /^[가-힣a-zA-Z]{3,8}$/i;                                                  // 이름 정규식
    const regNickname = /^(?=.*[가-힣])?(?=.*[a-zA-Z])?(?=.*\d)?[가-힣a-zA-Z\d]{3,8}$/i;     // 닉네임 정규식
    const regPhoneNo = /^01[0-9]-\d{3,4}-\d{4}$/;                                           // 연락처 정규식

    const idCheckBtn = document.querySelector('#idCheck');                                   // 아이디 중복체크버튼
    const inputId = document.querySelector('#id');
    const inputPassword = document.querySelector('#password');
    const inputConfirmPassword = document.querySelector('#confirmPassword');
    const passPatternCheckMessage = document.querySelector('#passPatternCheck');
    const inputPhoneNo = document.querySelector('#phoneNo');                                // 전화번호
    const inputCertiNo = document.querySelector('#certiNo');

    const sendCertifyNoBtn = document.querySelector('#sendCertifyNo');                       // 인증번호 발송버튼
    const certifyCheckBtn  = document.querySelector('#certifyCheck');                        // 인증번호 확인버튼
    const consentCheckbox = document.querySelector('#consentCheckbox');

    const signUpForm = document.querySelector('#signUpForm');
    const registerBtn = document.querySelector('#registerBtn');

    let isExistsChkId = false;
    let isConfirmChkPwd = false;
    let isConfirmPhoneNo = false;

    signUpForm.addEventListener('submit', function(event){
        event.preventDefault();

        if(!isExistsChkId){
        event.preventDefault();
            alert("아이디 중복체크를 확인하세요.");
            return;
        }
        if(!isConfirmChkPwd){
            inputConfirmPassword.focus();
            alert("재확인 비밀번호가 일치하지 않습니다.");
            return;
        }
        if(!isConfirmPhoneNo){
            event.preventDefault();
            inputCertiNo.focus();
            alert("전화번호 인증을 확인하세요.");
            return;
        }
        if(!consentCheckbox.checked){
            alert("개인정보 이용에 동의해야 합니다.");
            event.preventDefault();
            return;
        }
        this.submit();
        // alert("회원가입이 완료되었습니다. 로그인 후 이용하세요!!");
        // console.log("formData = " + FormData);
        // location.href="/";
    })

    idCheckBtn.addEventListener('click', function(){
        let id = inputId.value;
        if(!regId.test(id)){
            alert("아이디는 대소문자 관계없이 숫자를 포함한 8자까지 가능합니다.");
            return;
        }
        $.ajax({
            url : 'idCheck',
            method : 'get',
            data : {id : id},
            success : function(result){
                if(result === 1){
                    alert("이미 존재하는 아이디입니다.");
                    isExistsChkId = false;
                    inputId.focus();
                } else {
                    isExistsChkId = true;
                    alert("사용 가능한 아이디입니다.");
                }
            }
        })
        console.log("최종 결과값은? " + isExistsChkId);
    });

    function checkPasswordMatch(){
        const password = inputPassword.value;
        const confirmPassword = inputConfirmPassword.value;

        if(!regPwd.test(password)){
            passPatternCheckMessage.textContent = '비밀번호가 입력 형식에 맞지 않습니다.';
            passPatternCheckMessage.style.color = 'red';
            return;
        }
        if (password === confirmPassword) {
            passPatternCheckMessage.textContent = '비밀번호가 일치 합니다';
            passPatternCheckMessage.style.color = 'green';
            isConfirmChkPwd = true;
        } else {
            passPatternCheckMessage.textContent = '비밀번호가 일치하지 않습니다.';
            passPatternCheckMessage.style.color = 'red';
            isConfirmChkPwd = false;
        }
    }
    inputConfirmPassword.addEventListener('input', checkPasswordMatch);

    let certiNoByServer;           // 서버에서 넘어온 인증번호
    // sendCertifyNoBtn.addEventListener('click', function(){
    function sendVerification(){
        let phoneNo = inputPhoneNo.value;

        if(phoneNo === ''){
            alert("연락처를 입력하세요.");
            inputPhoneNo.focus();
        }
        $.ajax({
            url : 'sendSMS',
            method : 'post',
            data : {phoneNo : phoneNo},
            success : function(result){
                certiNoByServer = result;
                inputPhoneNo.focus();
            }
        })
    // });
    }
    function phoneNoCertify(){
    // certifyCheckBtn.addEventListener('click', function(){
        let inputNo = inputCertiNo.value;

        console.log("inputNo = " + inputNo)
        if(certiNoByServer !== inputNo){
            alert("인증번호가 일치하지않습니다.");
            isConfirmPhoneNo = false;
            return;
        }
        isConfirmPhoneNo = true;
        alert("인증번호가 일치합니다.");
        console.log("test = " + isExistsChkId)
        inputCertiNo.focus();
    // });
    }
</script>
</body>
</html>
