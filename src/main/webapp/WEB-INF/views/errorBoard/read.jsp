<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<!-- Core Css -->
<title>에러게시판 게시글조회</title>
<link rel="shortcut icon" type="image/png" href="<c:url value='/bootstrap/assets/images/logos/favicon.png'/>" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/board.css'/>">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<%--<link type="text/css" rel="stylesheet" href="https://www.gstatic.com/_/translate_http/_/ss/k=translate_http.tr.26tY-h6gH9w.L.W.O/am=Phg/d=0/rs=AN8SPfor9mOnrVSOJ5Dp4JexmA5DU8Siog/m=el_main_css">--%>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<link rel="stylesheet" href="https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor5/42.0.1/translations/ko.js"></script>

<style>
    .container-fluid {
        width: 70%;
    }
    .board-container {
        width: 70%;
        margin:auto;
    }
    .btnList {
        margin-left: auto;
        display: flex;
    }
    .search-container > * > select  {
        font-weight: bold;
    }
    .btn.bg-primary-subtle.text-primary {
        margin-right: 10px;
        width: auto;;
    }
    #contentDisplay{
        padding: 12px 20px;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 10px;
        box-sizing: border-box;
    }
    #contentDisplay img {
        <%-- contentDisplay내의 모든 img 요소가 가운데 정렬 --%>
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
</style>
<body>
<jsp:include page="../header.jsp" />
<br>

<script>
    let msg = "${msg}";

    if(msg =="MOD_OK") alert("수정이 완료되었습니다.")
</script>
<div class="container-fluid">
    <div class="position-relative mb-4">
        <div>
            <br>
            <h4>그동안 경험했던 에러와 오류들을 기록하기 위한 트러블슈팅 게시판</h4>
        </div>
    </div>
</div>
<div class="board-container">
    <div>
        <div class="test-container">
            <h2 class="writing-header"></h2>
            <div class="btnList">
                <c:if test="${errorBoardDTO.writer eq loginId}">
                    <button type="button" id="removeBtn" class="btn bg-primary-subtle text-primary"><i class="fa fa-trash"></i> 삭제하기</button>
                    <button type="button" id="modifyBtn" class="btn bg-primary-subtle text-primary"><i class="fa fa-edit"></i> 수정하기
                    </button>
                </c:if>
                <button type="button" id="listBtn" class="btn bg-primary-subtle text-primary"><i class="fa fa-bars"></i> 목록으로</button>
            </div>
        </div>
    </div>
    <form id="form" class="form" action="<c:url value='/errorBoard/remove'/>" method="post" enctype="multipart/form-data">
        <c:if test="${not empty errorBoardDTO.errBno}">
            <input type="hidden" id="errBno" name="errBno" value="<c:out value='${errorBoardDTO.errBno}'/>">
        </c:if>
        <input name="title" type="text" value='${errorBoardDTO.title}' readonly placeholder="제목">
        <input name="errCode" type="text" value='발생한 에러코드 : ${errorBoardDTO.errCode}' readonly placeholder="에러코드">
        <div id="contentDisplay"></div>
    </form>
    <br>
</div>
<%--</div>--%>
</body>
<script>
    let listBtn = document.querySelector('#listBtn');
    let errBno = "${errorBoardDTO.errBno}";
    $(document).ready(function(){
        let data = `${errorBoardDTO.content}`;

        $("#contentDisplay").html(data);
        $("#contentDisplay").children().children().css('max-width','100%');
        $("#contentDisplay").children().find().css('max-width','100%');
        $("#contentDisplay").children().children().css('margin','auto');

        let formCheck = function() {

            let form = document.querySelector("#newForm");

            let content = editor.getData();

            if(form.title.value === "") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if(content === "") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")){
                return;
            }
            let form = $("#form");
            form.attr("action", "<c:url value='/errorBoard/remove${searchCondition.queryString}'/>");
            form.attr("method" , "post");
            form.submit();
        })
        $("#modifyBtn").on("click", function() {
            location.href = "<c:url value='modify?errBno=${errorBoardDTO.errBno}'/>";
        })
        $("#writeNewBtn").on("click", function(){
            location.href="<c:url value='/errorBoard/write'/>";
        });
        $("#writeBtn").on("click", function(){

            // $("#contentDisplay").children().children().children().children().css('height','500px;');

            let form = $("#newForm");
            form.attr("action", "<c:url value='/errorBoard/write'/>");
            form.attr("method", "post");

            if(formCheck()){
                let afterImgAddressWrite = getImageSrcFromData(editor.getData());

                alert("afterImgAddressWrite = " + afterImgAddressWrite);
                alert("beforeImgAddressWrite = " + beforeImgAddressWrite);

                let imageAddress = {
                    "beforeImgAddress" : beforeImgAddressWrite,
                    "afterImgAddress" : afterImgAddressWrite
                }
                alert("imageAddress" + imageAddress);
                $.ajax({
                    url: '/myApp/contentImgCheck',
                    type: 'post',
                    contentType: 'application/json',
                    data: JSON.stringify(imageAddress),
                    success: function (result) {
                        beforeImgAddressWrite = [];
                        if(result != 1) return;
                    }
                })
                form.submit();
            }
        })
    });
    listBtn.addEventListener('click', function () {
        location.href = '<c:url value="/errorBoard/list"/>';
    })
    function getImageSrcFromData(data) {
        // 게시물 등록시 최종 주소값
        let afterImgAddress = [];

        const parser = new DOMParser();
        const doc = parser.parseFromString(data, 'text/html');
        const imgElements = doc.querySelectorAll('img');

        imgElements.forEach(img => {
            afterImgAddress.push(img.src);
        });
        return afterImgAddress;
    }
</script>
