<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
    <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
</head>
<style>
    .card{
        max-width: 70%;
        margin: auto;
    }
    .suggestFormHeader {
        display: flex;
        align-items: center;
    }
    .suggestForm, .suggestForm > * > * {
        margin-bottom: 0 !important;
        height: 37px;
        margin: 0px 0px 0px auto;
        display: flex;
        justify-content: right;
    }
</style>
<body>
<jsp:include page="header.jsp" />
<div class="card">
    <div class="card-body">
        <h4 class="mb-4 fw-semibold">To be updated..</h4>
            <textarea class="form-control mb-4" rows="5" placeholder="발견한 오류나 건의사항을 남겨주세요. 가입없이 이용 가능합니다."></textarea>
            <div class="suggestFormHeader" id="suggestFormHeader" name="suggestFormHeader">
                <button class="btn btn-primary" id="writeBtn">Post Comment</button>
                <div class="suggestForm" name="suggestForm" id="suggestForm">
                    <div class="col-md-1">
                        <div class="mb-3">
                                <input type="text" id="suggestWriter" name="suggestWriter" class="form-control" placeholder="작성자명" style="width: 100px; margin-right: 100px;">
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="mb-3">
                                <input type="text" id="suggestWriterPassword" name="suggestWriterPassword" class="form-control" placeholder="비밀번호" style="width: 100px; margin-right: 0px">
                        </div>
                    </div>
                </div>
            </div>
        <div class="d-flex align-items-center gap-3 mb-4 mt-7 pt-8">
            <h4 class="mb-0">Comments</h4>
            <span class="badge bg-primary-subtle text-primary fs-4 fw-semibold px-6 py-8 rounded">3</span>
        </div>
        <div class="position-relative">
            <div class="p-4 rounded-2 text-bg-light mb-3">
                <div class="d-flex align-items-center gap-3">
                    <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                    <h6 class="mb-0 fs-4">wait...!!</h6>
                    <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                </div>
                <p class="my-3">규모 크게 잡았다가 막상 해보니 할게 너무 많아서 기본적인것만도 벅차다..</p>
                <p class="my-3">그래도 생각보다 너무 재밌었다. 기존에 애매하게 알고있던 것들 정리되는 느낌</p>
                <div class="d-flex align-items-center gap-2">
                    <a class="d-flex align-items-center justify-content-center text-bg-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                        <i class="ti ti-arrow-back-up"></i>
                    </a>
                </div>
            </div>
            <div class="p-4 rounded-2 text-bg-light">
                <div class="d-flex align-items-center gap-3">
                    <img src="<c:url value='/bootstrap/assets/images/profile/user-4.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                    <h6 class="mb-0 fs-4">Seth Ortiz</h6>
                    <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                </div>
                <p class="my-3">
                    추가해 보고싶은 기능들 : 알림, 채팅, 통계관련, 캘린더, 가계부 등등
                </p>
                <div class="d-flex align-items-center gap-2">
                    <a class="d-flex align-items-center justify-content-center text-bg-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                        <i class="ti ti-arrow-back-up"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    const suggestWriter = document.querySelector('#suggestWriter');
    const suggestPassword = document.querySelector('#suggestWriterPassword');
    const writeBtn = document.querySelector('#writeBtn');

    writeBtn.addEventListener('click' , function(){

        let inputWriter = suggestWriter.value;
        let inputPassword = suggestPassword.value;

        if(inputWriter.trim() == ''){
            alert("작성자명을 입력하세요");
            return;
        }
        if(inputPassword.trim() == ''){
            alert("비밀번호를 입력하세요");
            return;
        }
        let suggestDTO = {
            "writer" : inputWriter,
            "password" : inputPassword
        }
            $.ajax({
                url:"",
                method : 'post',
                dataType : "application/json",
                data : suggestDTO,
                success : function (result){

                }
            })


    })



</script>
</body>
</html>
