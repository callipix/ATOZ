<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value='/css/boardDetail.css'/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
    .board-container {
        padding: 50px 200px;
    }
    textarea {
        width: 100%; /* 필요에 따라 너비를 설정합니다 */
        max-width: 100%; /* 최대 너비를 설정하여 부모 요소를 넘지 않도록 합니다 */
        min-width: 300px; /* 최소 너비를 설정할 수도 있습니다 */
    }
    <style>
     * {
         box-sizing: border-box;
         margin: 0;
         padding: 0;
         font-family: "Noto Sans KR", sans-serif;
     }

    .container {
        width : 50%;
        margin : auto;
    }

    .writing-header {
        position: relative;
        margin: 20px 0 0 0;
        padding-bottom: 10px;
        border-bottom: 1px solid #323232;
    }

    input {
        width: 100%;
        height: 35px;
        margin: 5px 0px 10px 0px;
        border: 1px solid #e9e8e8;
        padding: 8px;
        background: #f8f8f8;
        outline-color: #e6e6e6;
    }

    textarea {
        width: 100%;
        background: #f8f8f8;
        margin: 5px 0px 10px 0px;
        border: 1px solid #e9e8e8;
        resize: none;
        padding: 8px;
        outline-color: #e6e6e6;
    }

    .frm {
        width:100%;
    }
    .btn {
        background-color: rgb(236, 236, 236); /* Blue background */
        border: none; /* Remove borders */
        color: black; /* White text */
        padding: 6px 12px; /* Some padding */
        font-size: 16px; /* Set a font size */
        cursor: pointer; /* Mouse pointer on hover */
        border-radius: 5px;
    }

    .btn:hover {
        text-decoration: underline;
    }
    </style>
    </style>
</head>
<body>
<jsp:include page="../header.jsp" />
<script>
    let msg = "${msg}";
</script>
<div>
    <div class="board-container">
        <div>
            <div class="test-container">
            <h2 class="writing-header">게시글 ${mode eq "new" ? "쓰기" : "읽기"}</h2>
<%--                <c:if test="${mode eq 'new'}">--%>
<%--                    <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i>글쓰기</button>--%>
<%--                </c:if>--%>
                <c:if test="${boardDTO.writer eq loginId}">
                    <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i>글수정</button>
                    <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i>글삭제</button>
                </c:if>
            </div>
        </div>
        <form id="form" class="form" action="/board/write" method="post">
            <c:if test="${not empty boardDTO.bno}">
                <input type="hidden" id="bno" name="bno" value="<c:out value='${boardDTO.bno}'/>">
            </c:if>
            <input name="title" id="title" type="text" value="<c:out value='${boardDTO.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>

            <textarea id="content" name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value="${boardDTO.content}"/></textarea><br>

            <c:if test="${mode eq 'new'}">
                <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
            </c:if>
            <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
        </form>
    </div>
</div>

<script>

    let formCheck = function() {

        let form = document.getElementById("form");

        if(form.title.value ==='') {
            alert("제목을 입력해 주세요.");
            form.title.focus();
            return false;
        }
        if(form.content.value==='') {
            alert("내용을 입력해 주세요.");
            form.content.focus();
            return false;
        }
        return true;
    }

    $("#writeNewBtn").on("click", function(){
        location.href="<c:url value='/board/write'/>";
    });

    $("#writeBtn").on("click", function(){
        let form = $("#form");
        form.attr("action", "<c:url value='/board/write'/>");
        form.attr("method", "post");

        if(formCheck())
            form.submit();
    });

        listBtn.addEventListener('click', function () {
            location.href = '<c:url value="/board/boardList"/>';
        })
</script>

</body>
</html>