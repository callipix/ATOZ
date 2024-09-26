<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<link rel="stylesheet" href="https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor5/42.0.1/translations/ko.js"></script>
<title>에러게시판 게시글쓰기</title>
<body>
<jsp:include page="../header.jsp"/>
<link rel="stylesheet" href="<c:url value='/mycustom/buttons.css'/>">
<script>
    let msg = "${msg}";
    let beforeImgAddressWrite = [];
</script>
<div>
    <div class="board-container">
        <div>
            <div class="test-container">
                <h2 class="writing-header">게시글 작성</h2>
                <div class="btnList">
                    <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 게시글등록
                    </button>
                    <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록으로</button>
                </div>
            </div>
        </div>
        <input type="hidden" name="errBno" value="${errorBoardDTO.bno}">

        <form id="newForm" class="form" action="<c:url value='/errorBoard/write'/>" method="post"
              enctype="multipart/form-data">
            <c:if test="${not empty errorBoardDTO.errBno}">
                <input type="hidden" id="errBno" name="errBno" value="<c:out value='${errorBoardDTO.bno}'/>">
            </c:if>
            <input type="hidden" id="afterList" name="afterList">
            <div class="form-group">
                <label for="title">
                    <input class="form-control" name="title" id="title" type="text"
                           value="<c:out value='${errorBoardDTO.title}'/>" placeholder="  제목을 입력해 주세요.">
                </label>
            </div>
            <br>
            <div class="form-group">
                <label for="errCode">
                    <input class="form-control" name="errCode" id="errCode" type="text"
                           value="<c:out value='${errorBoardDTO.errCode}'/>" placeholder="  에러코드를 입력해 주세요.">
                </label>
            </div>
            <br>
            <div class="form-group">
                <label for="content">
                    <textarea name="content" id="content" rows="20"
                              placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}></textarea>
                </label><br>
            </div>
            <script type="importmap">
                {
                    "imports": {
                        "ckeditor5": "https://cdn.ckeditor.com/ckeditor5/42.0.1/ckeditor5.js",
                        "ckeditor5/": "https://cdn.ckeditor.com/ckeditor5/42.0.1/"
                    }
                }
            </script>
            <script type="module" src="<c:url value='/ckeditor5/write.js'/>"></script>
        </form>

    </div>
</div>
<script>
    const listBtn = document.querySelector('#listBtn');
    $(document).ready(function () {
        let afterList = document.querySelector('#afterList');

        let formCheck = function () {

            let form = document.querySelector("#newForm");

            let content = editor.getData();

            if (form.title.value === "") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if (content === "") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }
        $("#removeBtn").on("click", function () {
            if (!confirm("정말로 삭제하시겠습니까?")) {
                return;
            }
            let form = $("#form");
            form.attr("action", "<c:url value='/errorBoard/remove${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        })

        $("#writeNewBtn").on("click", function () {
            location.href = "<c:url value='/errorBoard/write'/>";
        });
        $("#writeBtn").on("click", function () {

            let form = $("#newForm");
            form.attr("action", "<c:url value='/errorBoard/write'/>");
            form.attr("method", "post");

            if (formCheck()) {
                let afterImgAddressWrite = getImageSrcFromData(editor.getData());
                let imageAddress = {
                    "beforeImgAddress": beforeImgAddressWrite,
                    "afterImgAddress": afterImgAddressWrite
                }

                $.ajax({
                    url: '/contentImgCheck',
                    type: 'post',
                    contentType: 'application/json',
                    data: JSON.stringify(imageAddress),
                    success: function (result) {
                        beforeImgAddressWrite = [];
                        if (result != 1) {
                            return;
                        }
                    },
                });
                afterList.value = afterImgAddressWrite;
                // 폼 제출
                form.submit();
            }
        });
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
</body>
