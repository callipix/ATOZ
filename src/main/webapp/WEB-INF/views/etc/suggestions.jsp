<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>건의사항</title>
    <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
    <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>"/>
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<style>
    .card {
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

    #suggestionList {
        width: auto;
        margin: auto;
    }

    #modifyPass, #modifyPass > * {
        margin-bottom: 0 !important;
        height: 40px;
    }

    .mod-del-pass {
        display: flex;
        align-items: center;
        justify-content: right;
        margin-left: auto;
    }
</style>
<body>
<jsp:include page="../header.jsp"/>
<div class="card">
    <div class="card-body">
        <h4 class="mb-4 fw-semibold">To be updated..</h4>
        <textarea id="content" name="content" class="form-control mb-4" rows="5"
                  placeholder="발견한 오류나 건의사항을 남겨주세요. 가입없이 이용 가능합니다."></textarea>
        <div class="suggestFormHeader" id="suggestFormHeader" name="suggestFormHeader">
            <button class="btn btn-primary" id="writeBtn">Post Comment</button>
            <div class="suggestForm" name="suggestForm" id="suggestForm">
                <div class="col-md-1">
                    <div class="mb-3">
                        <input type="text" id="suggestWriter" name="suggestWriter" class="form-control"
                               placeholder="작성자명" style="width: 100px; margin-right: 100px;">
                    </div>
                </div>
                <div class="col-md-1">
                    <div class="mb-3">
                        <input type="password" id="suggestWriterPassword" name="suggestWriterPassword"
                               class="form-control" placeholder="비밀번호" style="width: 100px; margin-right: 0px">
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex align-items-center gap-3 mb-4 mt-7 pt-8">
            <h4 class="mb-0">Comments</h4>
            <span class="badge bg-primary-subtle text-primary fs-4 fw-semibold px-6 py-8 rounded">${suggestCount}</span>
            <h5 class="mb-0">코멘트 수정 불가, 건의사항 댓글목록 페이징 처리</h5>
        </div>

        <div class="position-relative" id="suggestionList" name="suggestionList">
            <c:if test="${empty suggestCount || suggestCount == null || suggestCount == 0}">
                <div style="text-align:center; margin: auto">
                    건의사항이 없습니다..
                </div>
            </c:if>
            <c:forEach var="suggestionDTO" items="${suggestionList}">
                <div class="p-4 rounded-2 text-bg-light mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <input type="hidden" class="sno" name="sno" value="${suggestionDTO.sno}">
                        <c:choose>
                            <c:when test="${empty value}">
                                <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img"
                                     class="rounded-circle" width="33" height="33">
                            </c:when>
                        </c:choose>
                        <h6 class="mb-0 fs-4">${suggestionDTO.writer}</h6>
                        <span class="p-1 text-bg-muted rounded-circle d-inline-block">
                        </span>
                        <div class="mb-4" style="margin-bottom: 0 !important; color: #9097a7">
                            <c:choose>
                                <c:when test="${suggestionDTO.regDate.time >= startOfToday}">
                                    <fmt:formatDate value="${suggestionDTO.regDate}" pattern="HH:mm" type="time"/>
                                </c:when>
                                <c:otherwise>
                                    <fmt:formatDate value="${suggestionDTO.regDate}" pattern="yyyy-MM-dd" type="date"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="mod-del-pass">
                            <button class="btn btn-primary" name="deleteBtn" id="deleteBtn"
                                    style="background-color: transparent; border: none; color:black;"
                                    data-sno="${suggestionDTO.sno}">삭제
                            </button>
                            <button class="btn btn-primary" id="modifyBtn"
                                    style="background-color: transparent; border: none; color:black;"
                                    data-sno="${suggestionDTO.sno}">수정
                            </button>
                            <div class="mb-3" name="modifyPass" id="modifyPass">
                                <label for name="modifyCheckPassword">
                                    <input type="password" id="modifyCheckPassword" class="modifyCheckPassword"
                                           name="modifyCheckPassword" placeholder="비밀번호"
                                           style="width: 100px; height: 40px; margin-right: 0px;">
                                </label>
                            </div>
                        </div>
                    </div>
                    <p class="my-3">${suggestionDTO.content}</p>
                </div>
            </c:forEach>
        </div>
        <nav aria-label="...">
            <ul class="pagination justify-content-center mb-0 mt-4">
                <c:if test="${suggestCount != null && suggestCount != 0}">
                    <c:if test="${ph.showPrev}">
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center"
                               href="<c:url value='/suggestions?page=${ph.beginPage - 1}' />">
                                <i class="ti ti-chevron-left"></i>
                            </a>
                        </li
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <li class="page-item ${i == ph.page ? 'active' : ''}">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center ${i == ph.page ? 'text-white' : ''}"
                               href="<c:url value='/suggestions?page=${i}' />">${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center"
                               href="<c:url value='/suggestions?page=${ph.endPage + 1}' />">
                                <i class="ti ti-chevron-right"></i>
                            </a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
<script>

    const suggestWriter = document.querySelector('#suggestWriter');
    const suggestPassword = document.querySelector('#suggestWriterPassword');
    const writeBtn = document.querySelector('#writeBtn');
    const deleteBtn = document.querySelector('#deleteBtn');
    const modifyBtn = document.querySelector('#modifyBtn');
    const content = document.querySelector('#content');
    // const modifyCheckPassword = document.querySelector('#modifyCheckPassword');

    const modifyCheckPass = document.querySelectorAll('button[name="deleteBtn"]');

    let addZero = function (value = 1) {
        return value > 9 ? value : "0" + value;
    }

    let dateToString = function (ms = 0) {
        let date = new Date(ms);

        let yyyy = date.getFullYear();
        let mm = addZero(date.getMonth() + 1);
        let dd = addZero(date.getDate());

        let HH = addZero(date.getHours());
        let MM = addZero(date.getMinutes());
        let ss = addZero(date.getSeconds());

        return yyyy + "." + mm + "." + dd + " " + HH + ":" + MM + ":" + ss;
    }
    $(document).ready(function () {


        writeBtn.addEventListener('click', function () {

            let inputContent = content.value;
            let inputWriter = suggestWriter.value;
            let inputPassword = suggestPassword.value;

            let accessToken = localStorage.getItem("access");

            if (inputContent.trim() === '') {
                alert("내용을 입력하세요");
                return;
            }
            if (inputWriter.trim() === '') {
                alert("작성자명을 입력하세요");
                return;
            }
            if (inputPassword.trim() === '') {
                alert("비밀번호를 입력하세요");
                return;
            }
            let suggestDTO = {
                "writer": inputWriter,
                "password": inputPassword,
                "content": inputContent
            }
            let str = '';
            let ms = Date.now();
            $.ajax({
                url: "/suggestions",
                method: 'post',
                data: suggestDTO,
                success: function (result) {
                    str += '<div class="p-4 rounded-2 text-bg-light mb-3">';
                    str += '    <div class="d-flex align-items-center gap-3">';
                    str += '        <img src="/bootstrap/assets/images/profile/user-3.jpg" alt="xtreme-img" class="rounded-circle" width="33" height="33">';
                    str += '        <h6 class="mb-0 fs-4">' + result.writer + '</h6>';
                    str += '        <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>';
                    str += (dateToString(ms)).substring(11, 16);
                    str += '    </div>';
                    str += '    <p class="my-3">' + result.content + '</p>';
                    str += '    <div class="d-flex align-items-center gap-2">';
                    str += '    </div>';
                    str += '</div>';
                    $("#suggestionList").prepend(str);
                }
            })
        });

        modifyBtn.addEventListener('click', function () {

            if (!confirm("수정 하시겠습니까?")) {
            }

        })
    })

    modifyCheckPass.forEach(function (button) {
        <%
        // 1. deleteBtn을 가진 모든 요소를 선택
        // 2. 선택된 모든 요소에 대해 반복문을 실행(forEach문)
        %>

        button.addEventListener('click', function () {
            // 3. 각 요소에 클릭이벤트를 추가
            const parentDiv = button.closest('.mod-del-pass');
            const modifyCheckPassword = parentDiv.querySelector('input[name="modifyCheckPassword"]');
            let password = modifyCheckPassword.value;

            let sno = this.dataset.sno;

            // 4. 클릭된 버튼 요소의 data-sno값을 가져옴
            if (password === '' || password.trim() === '') {
                alert("패스워드를 입력하세요");
                return;
            }
            if (!confirm("삭제하시겠습니까?")) {
                return;
            }

            $.ajax({
                url: '/suggestions/' + sno + '?password=' + password,
                method: 'delete',
                success: function (result) {
                    if (result === 'passNotEqual') {
                        alert("비밀번호가 일치하지 않습니다.");
                        return;
                    }
                    if (result === 'DEL_OK') {
                        alert("삭제되었습니다.");
                        location.href = '/suggestions/';
                    }
                }

            })
        });
    });
</script>
</body>
</html>
