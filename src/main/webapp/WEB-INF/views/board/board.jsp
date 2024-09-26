<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>자유게시판 게시글조회</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <link rel="stylesheet" href="https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.css">

    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor5/42.0.1/translations/ko.js"></script>
</head>
<style>
    #removeBtn, #modifyBtn, #writeBtn {
        display: none;
    }
</style>
<body>
<jsp:include page="../header.jsp"/>
<script>
    let msg = "${msg}";
</script>
<div>
    <div class="board-container">
        <div>
            <div class="test-container">
                <h2 class="writing-header">게시글 ${mode eq "new" ? "쓰기" : "읽기"}</h2>
                <div class="btnList">
                    <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 글삭제
                    </button>
                    <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 글수정
                    </button>
                    <button type="button" id="writeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 글쓰기
                    </button>
                    <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 게시글목록
                    </button>
                </div>
            </div>
        </div>
        <form id="form" class="form" action="<c:url value='/board/remove'/>" method="post"
              enctype="multipart/form-data">
            <c:if test="${not empty boardDTO.bno}">
                <input type="hidden" id="bno" name="bno" value="<c:out value='${boardDTO.bno}'/>">
            </c:if>
            <input name="title" type="text" value='${boardDTO.title}' ${mode=="new" ? "" : "readonly='readonly'"}><br>
            <br>
            <br>
            <div id="contentDisplay">
            </div>
        </form>
        <br>
    </div>

    <div id="commentList">
        <ul>
            <c:forEach var="commentDTO" items="${commentList}">
                <li class="comment-item" data-cno="${commentDTO.cno}" data-bno="${commentDTO.bno}">
                        <span class="comment-img">
                            <i class="fa fa-user-circle" aria-hidden="true"></i>
                        </span>
                    <div class="comment-area">
                        <div class="commenter">${commentDTO.commenter}</div>
                        <div class="comment-content">${commentDTO.comment}
                        </div>
                        <div class="comment-bottom">
                            <span class="up_date">${commentDTO.up_date}</span>
                            <a href="#" class="btn-write" data-cno="${commentDTO.cno}" data-bno="${commentDTO.bno}"
                               data-pcno="${commentDTO.pcno}">답글쓰기</a>
                            <a href="#" class="btn-modify" data-cno="${commentDTO.cno}" data-bno="${commentDTO.bno}"
                               data-pcno="${commentDTO.pcno}">수정</a>
                            <a href="#" class="btn-delete" data-cno="${commentDTO.cno}" data-bno="${commentDTO.bno}"
                               data-pcno="${commentDTO.pcno}">삭제</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <br>
        <div id="comment-writebox">
            <div class="commenter commenter-writebox">댓글인데 없네</div>
            <div class="comment-writebox-content">
                <textarea name="comment-content" id="commentText" cols="30" rows="3" placeholder="댓글을 남겨보세요"></textarea>
            </div>
            <div id="comment-writebox-bottom">
                <div class="register-box">
                    <button type="button" class="btn" id="btn-write-comment">등록</button>
                    <br>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="comment.jsp"/>
</div>
<script>
    let bno = "${boardDTO.bno}";
    let data = `${boardDTO.content}`;

    const removeBtn = document.querySelector('#removeBtn');
    const modifyBtn = document.querySelector('#modifyBtn');
    const listBtn = document.querySelector('#listBtn');

    $(document).ready(function () {

        if(accessToken){
            $.ajax({
                url : '/tokenCheck',
                method : 'get',
                xhrFields: {
                    withCredentials: true
                },
                headers :{
                    'access': accessToken,
                    'Content-Type': 'application/json;charset=utf-8'
                },
                dataType: "text",
                success : function(response){
                    if(response === "${boardDTO.writer}"){
                        removeBtn.style.display = 'block';
                        modifyBtn.style.display = 'block';
                        writeBtn.style.display = 'block';
                    }
                }
            })
        }

        $("#contentDisplay").html(data);
        $("#contentDisplay").children().children().children().css('max-width', '100%');

        $("#removeBtn").on("click", function (event) {
            if (!confirm("정말로 삭제하시겠습니까?")) {
                return;
            }
            event.preventDefault();
            let sc = {
                "page": "${searchCondition.page}",
                "pageSize": "${searchCondition.pageSize}",
                "option": "${searchCondition.option}",
                "keyword": "${searchCondition.keyword}"
            }

            let removeData = {
                "bno": bno,
                "sc": sc
            }
            $.ajax({
                url: '/board/remove',
                type: "post",
                xhrFields: {
                    withCredentials: true
                },
                headers: {
                    'access': accessToken,
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(removeData),
                success: function (response) {
                    location.href = response;
                }
            })
        })
        
        $("#modifyBtn").on("click", function () {
            location.href = "<c:url value='/board/modify?bno=${boardDTO.bno}'/>";
        })
        $("#writeBtn").on("click", function () {
            location.href = "<c:url value='/board/write'/>";
        });
        $("#listBtn").on("click", function () {
            location.href = "<c:url value='/board/boardList${searchCondition.queryString}'/>";
        });
    })
    let showList = function (bno) {
        $.ajax({
            type: 'get',       // 요청 메서드
            url: '/ch4/comments?bno=' + bno,  // 요청 URI
            success: function (result) {
                $("#commentList").html(toListHTML(result));
            },
            error: function () {
                alert("error")
            }
        }) // $.ajax()
    }
</script>
</body>
</html>