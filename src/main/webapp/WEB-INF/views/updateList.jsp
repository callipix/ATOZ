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
        <h5>로그인폼, 회원가입폼 UI 작성, 회원가입 프론트 코드 작성</h5>
        <h5>로그인, 회원가입 페이지 뷰 컨트롤러 페이지 이동 확인</h5>
        <h5>현재까지 프로젝트 내역 AWS에 올려서 간단 테스트, 동작 확인</h5>
    </div>
    <button class="accordion"><b>2024.07.20</b></button>
    <div class="panel">
        <h5>문자인증 api 테스트(coolSMS)</h5>
        <h5>회원가입 & 로그인 비즈니스 로직 재설계</h5>
        <h5>회원가입 & 로그인 테스트 코드 작성 DB 연동 테스트</h5>
        <h5>회원가입 : 프론트 - 백 연동 테스트</h5>
        <h5>회원가입 DB 연동(프론트-백) 테스트 작동 확인</h5>
        <h5>회원가입 & 로그인 기능 구현 완료 - 인증 로직 고도화 예정</h5>
    </div>
    <button class="accordion"><b>2024.07.21</b></button>
    <div class="panel">
        <h5>로그인 기능 일부 수정 및 게시판 추가</h5>
        <h5>게시판 기본 CRUD 쿼리문 작성</h5>
        <h5>게시판 Mapper 파일 작성</h5>
        <h5>게시판 리스트 불러오기 테스트코드 작성</h5>
        <h5>게시판 페이징 쿼리문 boardMapper에 추가</h5>
        <h5>게시판 리스트 페이징 테스트</h5>
        <h5>인텔리제이 깃 연동중에 실수로 날려먹어서 재작성</h5>
    </div>
    <button class="accordion"><b>2024.07.22</b></button>
    <div class="panel">
        <h5>게시판 글쓰기, 게시글 조회 기능 추가</h5>
        <h5>검색기능 추가</h5>
        <h5>게시판 페이징 & 검색 일부 오류 확인 → 쿼리 변경</h5>
        <h5>게시판 페이징 & 검색기능 수정 - 작동 확인</h5>
    </div>
    <button class="accordion"><b>2024.07.23</b></button>
    <div class="panel">
        <h5>게시글 수정/삭제기능 추가 → 인증 로직 고도화 예정</h5>
        <h5>게시글 UI 일부 수정</h5>
        <h5>AWS에 올려서 일부 기능 동작 테스트 → Context Path 경로 설정 오류 확인</h5>
        <h5>로컬에선 이상없이 작동했는데.. Context Path 경로 오류잡느라 하루종일 날렸다</h5>
    </div>
    <button class="accordion"><b>2024.07.24</b></button>
    <div class="panel">
        <h5>댓글 DB 테이블 설계</h5>
        <h5>댓글 쿼리문 mapper 작성</h5>
        <h5>댓글 백단 로직 설계 - Rest API 이용</h5>
        <h5>댓글 백단 테스트코드 작성 후 테스트 -> Postman으로 이상없이 작동 모두 확인, 트랜잭션까지 테스트 완료</h5>
        <h5>댓글 프론트단 UI 설계</h5>
        <h5>댓글 프론트-백 연동 테스트</h5>
    </div>
    <h1 >업데이트 예정</h1>
    <h4>검색기능 → 2024.07.22 완료</h4>
    <h4>게시글 수정/삭제기능 추가하기 → 2024.07.23 완료, 인증 로직 고도화 예정</h4>
    <h4>파일 첨부 - 이미지</h4>
    <h4>게시판 글쓰기 기능 에디터 추가하기(스마트에디터 or ckeditor5)</h4>
    <h4>날짜별 작업 내용마다 깃 링크 연동하기</h4>
    <h4>댓글기능 추가 → 고도화 예정</h4>
    <h4>관리자 페이지 - 접속모니터링(선택)</h4>
    <h4>스프링 시큐리티로 인증기능 수정 및 보안강화</h4>
    <h4>아이디 비밀번호 찾기 추가</h4>
    <h4>소셜 로그인(선택)</h4>
    <h4>좋아요 기능 추가</h4>
    <h4 style="text-decoration: line-through;">무한 대댓글</h4>
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