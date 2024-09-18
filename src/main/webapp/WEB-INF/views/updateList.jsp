<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<link rel="stylesheet" href="<c:url value='/css/updateList.css'/>"/>
<link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>"/>
<a href="https://www.cursors-4u.com/cursor/2009/01/30/cute-running-puppy.html" target="_blank" title="Cute Running Puppy"><img src="https://cur.cursors-4u.net/cursor.png" border="0" alt="Cute Running Puppy" style="position:absolute; top: 0px; right: 0px;" /></a>
<script src="<c:url value='/js/cursorEffect.js'/>"></script>
<style>
    .allHeader{
        width: 1300px;
    }
    .mainHeader, .bottomHeader, .bottomHeader > h1 {
        justify-content: center;
    }
    .updateList, .bottomHeader{
        width: 70%;
        margin: auto;
    }
</style>
<body>
<div class="allHeader">
    <div class="mainHeader">
        <h1>업데이트 내역</h1>

        <div class="uplistBtn">
            <button id="reverseOrder"><b>역순보기</b></button>
            <button id="openAll"><b>한번에 열기</b></button>
        </div>

        <div class="headerText" style="display: flex"><h5 style="text-decoration: line-through">역순정렬 일부 오류..</h5><h5>&nbsp;&nbsp;→ 해결? 다른 오류 발생</h5></div>
    </div>
    <div class="updateList">
        <div class="accordion-main">
            <button class="accordion"><b>2024.07.18</b></button>
            <div class="panel">
                <h5>전체 프로젝트 생성 후 설정(pom파일 라이브러리 추가)</h5>
                <h5>회원가입기능 쿼리문, 비즈니스로직, 테스트코드 작성(Junit4)</h5>
                <h5>가입시 문자인증(coolSMS) 추가 & 테스트까지 완료</h5>
                <h5>MySQL 스프링 연동 및 가입기능 테스트</h5>
                <h5>트랜잭션 설정 후 간단한 데이터 추가 작동 테스트 - 확인 완료</h5>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.19</b></button>
            <div class="panel">
                <h5>로그인폼, 회원가입폼 UI 작성, 회원가입 프론트 코드 작성</h5>
                <h5>로그인, 회원가입 페이지 뷰 컨트롤러 페이지 이동 확인</h5>
                <h5>현재까지 프로젝트 내역 AWS에 올려서 간단 테스트, 동작 확인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/d693c326cb7af8f2ab5cbc030d7798abf60b6827"><h5>프로젝트 기본세팅</h5></a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/ac070257c730473be567a1b2ea0996083a0086ac"><h5>프론트 - 메인 헤더 UI 및 로그인, 회원가입 페이지 설계</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.20</b></button>
            <div class="panel">
                <h5>문자인증 api 회원가입과 연동하여 테스트(coolSMS)</h5>
                <h5>회원가입 & 로그인 비즈니스 로직 재설계</h5>
                <h5>회원가입 & 로그인 테스트 코드 작성 DB 연동 테스트(Junit4)</h5>
                <h5>회원가입 : 프론트 - 백 연동 테스트</h5>
                <h5>회원가입 DB 연동(프론트-백) 테스트 작동 확인(Postman, Junit4)</h5>
                <h5>회원가입 & 로그인 기능 구현 완료 - 인증 로직 고도화 예정</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/a11e98d1d2ba70ebba33647ff30189417e024341"><h5>문자인증 라이브러리 추가 및 apikey : properties로 생성 & 관리, 로그인 & 회원가입 비즈니스로직 작성</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.21</b></button>
            <div class="panel">
                <h5>로그인 기능 일부 수정 및 게시판 추가</h5>
                <h5>게시판 기본 CRUD 쿼리문 & Mapper 작성</h5>
                <h5>게시글 리스트 테스트코드 작성</h5>
                <h5>게시글 리스트 페이징 추가 및 테스트</h5>
                <h5>인텔리제이 깃 연동중에 실수로 날려먹어서 재작성</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/97beccff4305a15d8e90855746b684a21a08e354"><h5>게시판 DTO 생성 및 검색, 페이징 테스트</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.22</b></button>
            <div class="panel">
                <h5>게시판 글쓰기, 게시글 조회 기능 추가</h5>
                <h5>검색기능 추가</h5>
                <h5>게시판 페이징 & 검색 일부 오류 확인 → 쿼리 변경</h5>
                <h5>게시판 페이징 & 검색기능 수정 - 작동 확인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/4d2baae2ee3d9003f5b51d06d8d36d67198e5498"><h5>게시판 글쓰기, 조회, 페이징</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/1919cc23171d03cba51826862a99e4ae34dfa09d"><h5>게시판 검색, 페이징</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.23</b></button>
            <div class="panel">
                <h5>게시글 수정/삭제기능 추가 → 인증 로직 고도화 예정</h5>
                <h5>게시글 UI 일부 수정</h5>
                <h5>AWS에 올려서 일부 기능 동작 테스트 → Context Path 경로 설정 오류 확인</h5>
                <h5>로컬에선 이상없이 작동했는데.. Context Path 경로 오류잡느라 하루종일 날렸다</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/6609602d4ffd31a1a3d2138105693d10153b6953"><h5>백-프론트 연동 게시판 글쓰기, 조회, 페이징</h5></a>

                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.24</b></button>
            <div class="panel">
                <h5>댓글 DB 테이블 설계</h5>
                <h5>댓글 쿼리문 mapper 작성</h5>
                <h5>댓글 백단 로직 설계 - Rest API 이용</h5>
                <h5>댓글 백단 테스트코드 작성 후 테스트 → 테스트코드 & Postman 모두 이상없이 작동 확인, 트랜잭션까지 테스트 완료</h5>
                <h5>댓글 프론트단 UI 설계</h5>
                <h5>댓글 프론트 - 백 연동 테스트 → 답글기능 일부 오류발생, 댓글만 등록, 삭제완료 </h5>
                <h5>댓글 프론트 - 백 연동 → 수정기능 진행중, 답글(대댓글) 우선 보류</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/51efaef52952d4ff15240564ad3f8ae4e58378df"><h5>댓글기능 구현</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/9b7f73f086058451ce7a497e6129304384505c78"><h5>댓글기능 일부 수정</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.25</b></button>
            <div class="panel">
                <h5>파일업로드 & 에디터 추가(ckeditor5) → 에디터만 추가 완료(07.25)</h5>
                <h5>에디터 추가하는데 경로설정 오류로 하루종일 날려먹었다..</h5>
                <h5>에디터 추가 후 게시판 조회 수정 쓰기 삭제 모두 문제발생해서 싹다 새로 잡는중..</h5>
                <h5>파일업로드 DB 테이블 설계</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/1e479cfebedd52a3d3ce423beb47eee5e796beb2"><h5>글쓰기 에디터 추가 설치(npm)</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/3411b23299a00ae2987551f7335e25419ddc6ff1"><h5>게시글 쓰기/조회/수정 페이지 분리 및 에디터 일부 수정</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.07.26</b></button>
            <div class="panel">
                <h5>에디터 추가 하면서 게시판 기능 에러로 조회 수정 쓰기 삭제 새로 작성중...</h5>
                <h5>게시판 조회 수정 쓰기 삭제 일부 해결</h5>
                <h5>게시판 기능 정상작동 하면 이후 파일업로드 추가 예정</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/3411b23299a00ae2987551f7335e25419ddc6ff1"><h5>AWS S3 Bucket 생성 및 키생성, 버킷 설정파일 properties로 생성 및 관리</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/ef48f6083cf0e56ccebe42b972b35247dea00d5f"><h5>업데이트 내역 페이지 추가, AWS S3 파일업로드를 위한 FilesDTO,업로드 컨트롤러 및 서비스 클래스 작성</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/9b7f73f086058451ce7a497e6129304384505c78"><h5>AWS S3 사용하기 위한 스프링 라이브러리 추가</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.07.27 - 07.28</b></button>
            <div class="panel">
                <h5>AWS S3 스프링 연동 실행문제랑 ckeditor 플러그인 extends 오류로 이틀 내내 날렸다.. AWS는 해결완료 ckeditor는 해결실패 </h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/ce39a2be413b0158e4c5560a0f1a8f767635fa56"><h5>파일정보 DB 테이블, BOARD_CATEGORY 테이블 추가</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/aa81052b2629186916629255044f72353c7d5985"><h5>S3 & 스프링 연동 → 에러 해결 및 S3, DB 파일 업로드까지 확인</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.07.29</b></button>
            <div class="panel">
                <h5>게시판 글 작성 : 이미지 삭제시 S3 파일삭제 , DB 파일정보 삭제 구현</h5>
                <h5>게시판, 회원가입 고도화 작업 예정 → 프론트-백 유효성 검증 로직 추가 예정</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/7a28d3ec5b48f878858f2ccbb303be25822cf5d9"><h5>글작성 중 이미지 변경시 S3, DB에 해당부분 반영</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/2218eb91d345e0d23207d019ad99d90119a21bd0"><h5>마우스 커서 이펙트 추가 및 에러게시판 프론트 코드 작성</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.07.30</b></button>
            <div class="panel">
                <h5>게시판 일부 css 수정</h5>
                <h5>에러코드 게시판 DB 테이블 추가, 게시판 기능 추가되면 이후 여기에 에러기록 예정</h5>
                <h5>에러코드 게시판 페이징처리, 검색기능 추가</h5>
                <h5>에러코드 게시판 일부 오류 확인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/4157a63f39f76f7f6b0cf9b6967249fe700d0165"><h5>에러코드 게시판 테스트</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/792377eb6af20b1d2c3dff19503d15f7f240bcbf"><h5>에러코드 게시판 페이징 및 검색기능 일부 추가</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/50eea7d7b35c17e9ea4a3232b6380c7ca3b18045"><h5>페이징 UI 일부 변경</h5></a>
                </div>

            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.07.31</b></button>
            <div class="panel">
                <h5>에러코드 게시판 글쓰기는 가능하나 이미지 업로드 → 삭제시 AWS에서 반영 안되는 문제로 해결 예정(등록자체는 가능)</h5>
                <h5> → 에러해결 진행중인데.. 잘 안된다</h5>
                <h5>회원가입시 닉네임 이메일 중복체크 추가 예정</h5>
                <h5>회원가입시 서버 유효성검증(Validation) 체크 추가 예정</h5>
                <h5>스프링 시큐리티로 권한설정 예정</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/249080f925204775c8e102ff8665a5660bb0b73d"><h5>에러게시판 DTO 생성 및 기능 구현</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.08.01</b></button>
            <div class="panel">
                <h5>게시물 삭제시 AWS에서 반영 안되는 문제 → 우선 보류(DB까지 수정해야 해서 일이 커졌다..)</h5>
                <h5>현재까지 내역들 AWS로 테스트 해보기</h5>
                <h5>예정 목록중 스프링 시큐리티로 권한추가 → 이걸 먼저 해야할듯 한데..</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/1a3b1cd6c10219036314253fba669f7c4e2e30c2"><h5>404에러페이지 추가 및 일부 css 수정, AWS에 올려서 테스트 중</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.08.02</b></button>
            <div class="panel">
                <h5>게시물 삭제시 AWS에서 반영 안되는 문제 → 일부 해결(DB테이블 수정, 일부 파일업로드 로직 수정, DB 쿼리문 변경..)</h5>
                <h5>현재까지 내역들 AWS로 테스트 예정</h5>
                <h5>파일업로드 가지고만 만 3일을 해먹었다..!</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/0533708d06f7dcbab0d74357414e63efa6f8a1f0"><h5>게시글 작성중 이미지 변경시 DB 반영안되던 문제 일부 해결</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.08.03</b></button>
            <div class="panel">
                <h5>건의게시판 테이블 추가 및 등록,삭제,수정 기능 추가 및 AWS 서버 테스트</h5>
                <h5>→ 비즈니스로직 설계 및 DAO & Mapper 작성</h5>
                <h5>→ 컨트롤러 추가중, UI : 08.04 추가 예정</h5>
                <h5>게시글 작성시 AWS 업로드 일부 오류 수정 + lombok dependency 추가(v1.18.30)</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/4cc5603a88a2390985bec74c1de181bedeb89115"><h5>(1)건의사항  CRUD 비즈니스로직 작성중</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/0352cac49f1a4f563c246cbb418e6d1b23988695"><h5>(2)건의사항  CRUD 비즈니스로직 작성 진행중(UI 일부 추가)</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.08.04</b></button>
            <div class="panel">
                <h5>건의사항 기능 구현 → Rest API</h5>
                <h5>건의사항 댓글목록 페이징 처리 예정 및 일부 CSS 수정</h5>
                <h5>집에서 VirtualBox로 리눅스에서 서버 테스트하다가 하루날렸다!(DB 연동 및 외부접근시 포트포워딩 에러)</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/91c262cd01492c83f45da3bc0c55d456813eedb1"><h5>건의사항 기능 추가(수정 미구현)</h5></a>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/e7519808f092a6cf93605d43e03ff37239b5cfd8"><h5>게시글 수정시 일부 문제점 발생, 변경</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.08.05</b></button>
            <div class="panel">
                <h5>게시글 삭제시 DB에서 삭제 안되던 문제 진행중..</h5>
                <h5>게시글 업데이트시에도 DB에서 업데이트 안되던 문제 발생</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/77194b23c647ebca62490d5d4cf5103df97e7e0d"><h5>게시글 삭제시 해당 오류 진행중..</h5></a>
                </div>
            </div>
        </div>
        <div class="accordion-main">
            <button class="accordion"><b>2024.08.06</b></button>
            <div class="panel">
                <h5>게시글 삭제&수정시 DB/AWS 에서 반영 안되던 문제 일부 해결</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/881d565637e04b1508d2f5c18e88fe0e1bc16bf7"><h5>건의사항 페이징, 게시물 삭제/업데이트시 오류 일부 해결</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.01</b></button>
            <div class="panel">
                <h5>기존 코드 리팩토링</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    <a href="https://github.com/callipix/myApp/commit/90cc7a0c837319a1910a3434b5273fcedd4d067f"><h5>로깅 코드 변경(sout → slf4j) 및 일부 클래스 패키지 구조 변경</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.02-03</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 설정 및 의존성 추가</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/16f2c38e31093a9421fa2dd105999467df859959"><h5>부하테스트용 notice 테이블 추가 및 일부 DTO 변경</h5></a>
                </div>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/561f09247b093b98937fa1030c0792f12d5b9b2d"><h5>시큐리티 관련 의존성 추가 및 시큐리티 필터 설정 및 DTO 수정(Getter&Setter 롬복 어노테이션 사용)</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.04</b></button>
            <div class="panel">
                <h5>시큐리티 OAuth2 인증 로그인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/1beee5aba8b2646962eec308bdf485d73563e392"><h5>OAuth2 인증 properties 클래스 추가 및 OAuth2 커스텀 객체 작성</h5></a>
                </div>

                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/c37a5c81bb6aca0a7fcfc2ef4af988801cbce754"><h5>비밀번호 암호화, 뷰 페이지 일부 수정</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.06</b></button>
            <div class="panel">
                <h5>시큐리티 OAuth2 인증 로그인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/afb0e08d6f2ed3e369d51179acdaf809fd6d78c9"><h5>유효성 검증(Validation) 일부 수정 및 </h5></a>
                </div>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/7a993b2cde7902bda033919380115877be4b459a"><h5>시큐리티 활성화 이후 권한에 따른 페이지 접근 테스트(ok)</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.07</b></button>
            <div class="panel">
                <h5>시큐리티 OAuth2 연동 구글 로그인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/df6d07b3e0021a099e6c541a53aaeeb6d2cb5e8f"><h5>OAuth2 구글 연동 로그인 및 jsp 세션체크 변경(Security tag 사용)</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.08</b></button>
            <div class="panel">
                <h5>시큐리티 OAuth2 연동 문제 일부 해결(로그인시 loadUser 호출 안되던 문제)</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/d174be64d1fcefdb367f82e1bad0bb792836ba4a"><h5>loadUser 호출 안되던 문제 해결</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.09</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 JWT 설정(필터 및 토큰 생성 로직 작성)</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/881d565637e04b1508d2f5c18e88fe0e1bc16bf7"><h5>jwt 관련 의존성 추가 및 시큐리티 필터 설정, 토큰 발행 클래스 작성</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.10</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 JWT : Redis 설정</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/4051a2ad9c06fed9a21818eb7c97f8ebd96c4254"><h5>Redis 서버 구축 및 테스트(ok) jwt 발행 및 Custom LoginFilter 작성</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.11</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 JWT 발행 설정 및 필터 작성중(기본로그인 + 소셜)</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/1e4597e6f04f54c5c940fba6b3fc62c94ed681c0"><h5>건의사항 페이징, 게시물 삭제/업데이트시 오류 일부 해결</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.12 - 13</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 JWT 발행 설정 및 필터 작성중(기본로그인 + 소셜)</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/e8059647975ac13b697ccdab7a4e45712c0878b0"><h5>refresh token 발급 및 뷰 페이지 수정 및 token 발급 DB 저장 확인, Redis 서버 실행 임시 중단</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.14</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 JWT 기본로그인 + 소셜로그인</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/cf2619eaad2a41b3e85728bd1f43ea3dd232ff56"><h5>OAuth2 로그인 후 헤더에 토큰값 전송 체크</h5></a>
                </div>

                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/3c7d1ecbc569160d05528ba509b4a52842e2a9d4"><h5>패키지 경로 변경 및 설정 과정 중 불필요한 클래스 제거 및 중복코드 삭제</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.15</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 로그아웃</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/2856111710001c08ad60ec78270d42a56840faaa"><h5>Logout Custom Filter 작성, 로그아웃시 DB에 있던 refresh token 삭제까지 완료</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.16</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 jwt 로그아웃</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/dc950d92c5aad582a1c1a335d93ade7743a0a1f0"><h5>뷰 페이지 수정 및 체크</h5></a>
                </div>

                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/dc950d92c5aad582a1c1a335d93ade7743a0a1f0"><h5>토큰 만료시 재발행 컨트롤러 추가 및 뷰 페이지 수정</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.17</b></button>
            <div class="panel">
                <h5>스프링 시큐리티 jwt 로그아웃</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/881d565637e04b1508d2f5c18e88fe0e1bc16bf7"><h5>일반로그인도 jwt 발급 방식의 로그아웃, 로그아웃시 서버 : DB 토큰 제거<br>클라이언트 : 로컬스토리지(access token), 쿠키(refresh token) 제거<br>DTO 수정 : equals, hashcode 오버라이드 메서드 삭제 후 @EqualsAndHashCode 어노테이션 추가</h5></a>
                </div>
            </div>
        </div>

        <div class="accordion-main">
            <button class="accordion"><b>2024.09.18</b></button>
            <div class="panel">
                <h5>Spring security OAuth2 인증, jwt 발급 로그인 마무리</h5>
                <div style="align-items: center; display: flex">
                    <img src="<c:url value='/img/github.png'/>"/>
                    &nbsp;&nbsp;
                    <a href="https://github.com/callipix/myApp/commit/1680da996d8c553a7538b841e8dba2776fa02fe7"><h5>BoardController 일부 메서드 오류 및 뷰 페이지 수정</h5></a>
                </div>
            </div>
        </div>

    </div>

</div>
<div class="bottomHeader">
    <h1>업데이트 예정</h1>
    <h4>스프링 시큐리티 적용해서 인증 & 권한설정 수정 및 보안강화 기본적인사항 끝나면 바로 적용 예정 → 우선순위 중상</h4>
    <h4>게시판 비동기 처리로 변경하기 → 급하긴 한데 가능할지..</h4>
    <h4>아이디 비밀번호 찾기 추가 → 우선순위 중</h4>
    <h4>좋아요 기능 추가 → 우선순위 중하 </h4>
    <h4>소셜 로그인(선택) → 우선순위 하</h4>
    <h4 style="text-decoration: line-through;">무한 대댓글 → 우선순위 하</h4>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function initializeAccordion() {
        let acc = document.getElementsByClassName("accordion");
        for (let i = 0; i < acc.length; i++) {
            acc[i].removeEventListener("click", handleAccordionClick); // 기존 이벤트 리스너 제거
            acc[i].addEventListener("click", handleAccordionClick); // 새로운 이벤트 리스너 추가
        }
    }

    function handleAccordionClick() {
        this.classList.toggle("active");
        let panel = this.nextElementSibling;
        if (panel.style.maxHeight) {
            panel.style.maxHeight = null;
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
        }
    }

    document.addEventListener("DOMContentLoaded", function() {
        initializeAccordion();

        document.getElementById('reverseOrder').addEventListener('click', function() {
            let list = document.querySelector('.updateList');
            let groups = Array.from(list.querySelectorAll('.accordion-main'));

            groups.reverse().forEach(function(group) {
                list.appendChild(group);
            });

            initializeAccordion();
        });

        document.getElementById('openAll').addEventListener('click', function() {
            let acc = document.getElementsByClassName('accordion');
            let panels = document.getElementsByClassName('panel');
            let openAll = document.querySelector('#openAll');
            let allOpen = true;

            // Check if all panels are open
            for (let i = 0; i < panels.length; i++) {
                if (panels[i].style.display === 'none' || panels[i].style.display === '') {
                    allOpen = false;
                    break;
                }
            }
            initializeAccordion();

            if (allOpen) {
                // If all are open, close all
                for (let i = 0; i < acc.length; i++) {
                    acc[i].classList.remove('active');
                    openAll.innerHTML = '한번에 열기';
                    panels[i].style.display = 'none';
                    panels[i].style.maxHeight = null;
                }
            } else {
                // If any are closed, open all
                for (let i = 0; i < acc.length; i++) {
                    openAll.innerHTML = '닫기';
                    acc[i].classList.add('active');
                    panels[i].style.display = 'block';
                    panels[i].style.maxHeight = panels[i].scrollHeight + 'px'; // For smooth expand effect
                }
            }
            initializeAccordion();
        });
    });
</script>

</body>