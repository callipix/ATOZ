<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<style>
    * {
        border: 0;
        padding: 0;
    }

    ul {
        border: 1px solid rgb(235, 236, 239);
        border-bottom: 0;
    }

    li {
        background-color: #f9f9fa;
        list-style-type: none;
        border-bottom: 1px solid rgb(235, 236, 239);
        padding: 18px 18px 0 18px;
    }

    #commentList {
        width: 70%;
        margin: auto;
    }

    .comment-content {
        overflow-wrap: break-word;
    }

    .comment-bottom {
        font-size: 9pt;
        color: rgb(97, 97, 97);
        padding: 8px 0 8px 0;
    }

    .comment-bottom > a {
        color: rgb(97, 97, 97);
        text-decoration: none;
        margin: 0 6px 0 0;
    }

    .comment-area {
        padding: 0 0 0 46px;
    }

    .commenter {
        font-size: 12pt;
        font-weight: bold;
    }

    .commenter-writebox {
        padding: 15px 20px 20px 20px;
    }

    .comment-img {
        font-size: 36px;
        position: absolute;
    }

    .comment-item {
        position: relative;
    }

    .up_date {
        margin: 0 8px 0 0;
    }

    #comment-writebox {
        background-color: #e2e2e2;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
    }

    textarea {
        display: block;
        width: 100%;
        min-height: 17px;
        padding: 0 20px;
        border: 0;
        outline: 0;
        font-size: 13px;
        resize: none;
        box-sizing: border-box;
        background: transparent;
        overflow-wrap: break-word;
        overflow-x: hidden;
        overflow-y: auto;
    }

    #comment-writebox-bottom {
        padding: 3px 10px 10px 10px;
        min-height: 35px;
    }

    .btn {
        font-size: 10pt;
        color: black;
        background-color: #d2d4d7;
        text-decoration: none;
        padding: 9px 10px 9px 10px;
        margin: 10px 0px 10px 5px;
        border-radius: 5px;
        float: right;
    }

    #btn-write-comment, #btn-write-reply {
        color: #009f47;
        background-color: #e0f8eb;
    }

    #btn-cancel-reply {
        background-color: #eff0f2;
        margin-right: 10px;
    }

    #btn-write-modify {
        color: #009f47;
        background-color: #e0f8eb;
    }

    #btn-cancel-modify {
        margin-right: 10px;
    }

    #reply-writebox {
        display: none;
        background-color: white;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
        margin: 10px;
    }

    #reply-writebox-bottom {
        padding: 3px 10px 10px 10px;
        min-height: 35px;
    }

    #modify-writebox {
        background-color: white;
        border: 1px solid #e5e5e5;
        border-radius: 5px;
        margin: 10px;
    }

    #modify-writebox-bottom {
        padding: 3px 10px 10px 10px;
        min-height: 35px;
    }

    /* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        padding-top: 100px; /* Location of the box */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0, 0, 0); /* Fallback color */
        background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
    }

    /* Modal Content */
    .modal-content {
        background-color: #fefefe;
        margin: auto;
        padding: 20px;
        border: 1px solid #888;
        width: 50%;
    }

    /* The Close Button */
    .close {
        color: #aaaaaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }

    .paging {
        color: black;
        width: 100%;
        text-align: center;
    }

    .page {
        color: black;
        text-decoration: none;
        padding: 6px;
        margin-right: 10px;
    }

    .paging-active {
        background-color: rgb(216, 216, 216);
        border-radius: 5px;
        color: rgb(24, 24, 24);
    }

    .paging-container {
        width: 100%;
        height: 70px;
        margin-top: 50px;
        margin: auto;
    }
</style>
</head>
<body>

<div id="reply-writebox">
    <div class="commenter commenter-writebox">여긴 답글이고</div>
    <div class="reply-writebox-content">
        <textarea name="" id="" cols="30" rows="3" placeholder="답글을 남겨보세요"></textarea>
    </div>
    <div id="reply-writebox-bottom">
        <div class="register-box">
            <a href="#" class="btn" id="btn-write-reply">등록</a>
            <a href="#" class="btn" id="btn-cancel-reply">취소</a>
        </div>
    </div>
</div>
<div id="modalWin" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <p>
        <h2>댓글 수정</h2>
        <div id="modify-writebox">
            <div class="commenter commenter-writebox"></div>
            <div class="modify-writebox-content">
                <textarea name="" id="" cols="30" rows="5" placeholder="댓글을 남겨보세요"></textarea>
            </div>
            <div id="modify-writebox-bottom">
                <div class="register-box">
                    <a href="#" class="btn" id="btn-write-modify">등록</a>
                </div>
            </div>
        </div>
        </p>
    </div>
</div>

<%----%>

<%----%>

<script>

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

        $("#btn-write-comment").on("click", function () {

            let comment = document.querySelector("#commentText");
            let commentDTO = {
                "bno": "${boardDTO.bno}",
                "comment": comment.value
            }
            if (!confirm("등록하시겠습니까?")) return;
            $.ajax({
                url: '/comments',
                type: 'post',
                data: commentDTO,
                success: function (comment) {
                    $("#commentList ul").append(toHTML(comment));
                }
            })
        })
        // $("#a.btn-write").on("click", function(){
        $(document).on("click", "a.btn-write", function (e) {
            let target = e.target;
            let cno = target.getAttribute("data-cno");
            let bno = target.getAttribute("data-bno");
            // let comment = $("input[name=replyComment]").val();
            let pcno = $("#replyForm").parent().attr("data-pcno");

            console.log("답글쓰기 버튼 클릭");
            let repForm = $("#reply-writebox");
            repForm.appendTo($("li[data-cno=" + cno + "]"));
            repForm.css("display", "block");
            repForm.attr("data-pcno", pcno);
            repForm.attr("data-bno", bno);

            $("btn-write-reply").on("click", function () {

                $.ajax({
                    url: "/write"
                })

            })

        });

        $(document).on("click", "#btn-cancel-reply", function (e) {
            $("#reply-writebox").css("display", "none");
        });

        $(document).on("click", "a.btn-modify", function (e) {
            let target = e.target;
            let cno = target.getAttribute("data-cno");
            let bno = target.getAttribute("data-bno");
            let pcno = target.getAttribute("data-pcno");
            let li = $("li[data-cno=" + cno + "]");
            let commenter = $(".commenter", li).first().text();
            let comment = $(".comment-content", li).first().text();

            console.log("ashgdasdashdk")

            $("#modalWin .commenter").text(commenter);
            $("#modalWin textarea").text(comment);
            $("#btn-write-modify").attr("data-cno", cno);
            $("#btn-write-modify").attr("data-pcno", pcno);
            $("#btn-write-modify").attr("data-bno", bno);

            // 팝업창을 열고 내용을 보여준다.
            $("#modalWin").css("display", "block");
        });

        $(document).on("click", "a.btn-delete", function (e) {

            let target = e.target;
            let cno = target.getAttribute("data-cno");

            if (!confirm("삭제하시겠습니까?")) return;

            $.ajax({
                url: '/comments/' + cno + '?bno=' + bno,
                type: 'delete',
                success: function (result) {
                    alert(result);
                    location.href = '/board/read?bno=' + bno;
                }
            })
        });

        $("#btn-write-modify").click(function () {
            // 1. 변경된 내용을 서버로 전송
            // 2. 모달 창을 닫는다.
            $(".close").trigger("click");
        });

        $(".close").click(function () {
            $("#modalWin").css("display", "none");
        });
    });


    let toHTML = function (comment) {
        let tmp = "<ul>";

        tmp += '<li class="comment-item" data-cno=' + comment.cno;
        tmp += ' data-pcno=' + comment.pcno;
        tmp += ' data-bno=' + comment.bno + '>';
        tmp += ' <div class="comment-area">';
        tmp += ' <div class="commenter">' + comment.commenter + '</div>';
        tmp += ' <div class="commenter-content">' + comment.comment + '</div>';
        tmp += ' <div class="comment-bottom">';
        tmp += ' <span class="up_date">' + comment.up_date + '</span>';

        tmp += ' <a href="#" class="btn-write" data-cno=' + comment.cno;
        tmp += ' data-bno=' + comment.bno + ' data-pcno=' + comment.pcno;
        tmp += ' > 답글쓰기' + '</a>';

        tmp += ' <a href="#" class="btn-modify" data-cno=' + comment.cno;
        tmp += ' data-bno=' + comment.bno + ' data-pcno=' + comment.pcno;
        tmp += ' > 수정' + '</a>';

        tmp += ' <a href="#" class="btn-delete" data-cno=' + comment.cno;
        tmp += ' data-bno=' + comment.bno + ' data-pcno=' + comment.pcno;
        tmp += ' > 삭제' + '</a>';

        tmp += ' </div>';
        tmp += ' </div>';
        tmp += '</li>';
        tmp += "</ul>";
        return tmp;
    }
    let toListHTML = function (comments) {

        let tmp = "<ul>";

        comments.forEach(function (comment) {

            tmp += '<li class="comment-item" data-cno=' + comment.cno;
            tmp += ' data-pcno=' + comment.pcno;
            tmp += ' data-bno=' + comment.bno + '>';
            tmp += ' <div class="comment-area">';
            tmp += ' <div class="commenter">' + comment.commenter + '</div>';
            tmp += ' <div class="commenter-content">' + comment.comment + '</div>';
            tmp += ' <div class="comment-bottom">';
            tmp += ' <span class="up_date">' + comment.up_date + '</span>';

            tmp += ' <a href="#" class="btn-write" data-cno=' + comment.cno;
            tmp += ' data-bno=' + comment.bno + ' data-pcno=' + comment.pcno;
            tmp += ' > 답글쓰기' + '</a>';

            tmp += ' <a href="#" class="btn-modify" data-cno=' + comment.cno;
            tmp += ' data-bno=' + comment.bno + ' data-pcno=' + comment.pcno;
            tmp += ' > 수정' + '</a>';

            tmp += ' <a href="#" class="btn-delete" data-cno=' + comment.cno;
            tmp += ' data-bno=' + comment.bno + ' data-pcno=' + comment.pcno;
            tmp += ' > 삭제' + '</a>';

            tmp += ' </div>';
            tmp += ' </div>';
            tmp += '</li>';
        })
        tmp += "</ul>";
        return tmp;
    }
</script>
</body>