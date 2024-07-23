<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<link rel="stylesheet" href="<c:url value='/css/updateList.css'/>"/>
<body>
<div class="updateList">
    <h1>업데이트 내역</h1>
    <button class="accordion"><b>2024.07.15</b></button>
    <div class="panel">
        <h5>전체 프로젝트 설정 후 생성</h5>
        <h5>pom 파일 라이브러리 추가</h5>
    </div>

    <button class="accordion"><b>2024.07.16</b></button>
    <div class="panel">
        <h5>회원가입기능 쿼리문 뽑아보기</h5>
        <h5>회원가입기능 백단 메서드 작성</h5>
        <h5>회원가입기능 메서드 테스트코드 작성 - Junit4</h5>
        <h5>가입시 문자인증 추가</h5>
        <h5>왜 이것만 아코디언 적용시 메뉴바가 달라지지?</h5>
    </div>

    <button class="accordion"><b>2024.07.17</b></button>
    <div class="panel">
        <h5>api-key, api-secret을 properties 파일로 별도분리하여 읽어오도록 설정</h5>
    </div>
    <button class="accordion"><b>2024.07.18</b></button>
    <div class="panel">
        <h5>MySQL 스프링 연동</h5>
        <h5>가입기능 테스트</h5>
        <h5>트랜잭션 설정 후 데이터 작동 테스트</h5>
    </div>
    <button class="accordion"><b>2024.07.19</b></button>
    <div class="panel">
        <h5>현재까지 프로젝트 내역 AWS에 올려서 테스트</h5>
    </div>
    <button class="accordion"><b>2024.07.20</b></button>
    <div class="panel">
        <h5>프로젝트 전체 css 만지다가 하루날림</h5>
    </div>
    <button class="accordion"><b>2024.07.21</b></button>
    <div class="panel">
        <h5>게시판 페이징처리 </h5>
    </div>
    <button class="accordion"><b>2024.07.22</b></button>
    <div class="panel">
        <h5>인텔리제이 깃 연동하다가 실수로 날려먹어서 재작성</h5>
        <h5>검색기능 추가 완료</h5>
    </div>
    <button class="accordion"><b>2024.07.23</b></button>
    <div class="panel">
        <h5>게시글 수정/삭제기능 추가</h5>
    </div>
    <h1 >업데이트 예정</h1>
    <h4>검색기능 → 2024.07.22 완료</h4>
    <h4>게시글 수정/삭제기능 추가하기 → 2024.07.23 완료, 추후 인증 로직 고도화 예정</h4>
    <h4>댓글기능 추가</h4>
    <h4>파일 첨부 - 이미지</h4>
    <h4>아이디 비밀번호 찾기</h4>
    <h4>소셜 로그인</h4>
    <h4>좋아요 추가</h4>
    <h4>게시판 글쓰기 기능 에디터 추가하기(스마트에디터 or ckeditor5)</h4>
    <h4>스프링 시큐리티로 인증기능 추가</h4>
    <h4>댓글기능 고도화</h4>
</div>
<script>
    let acc = document.getElementsByClassName("accordion");
    for (let i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            let panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }
</script>

</body>