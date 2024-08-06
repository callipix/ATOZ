<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>프로젝트 개요</title>
    <head>
        <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
        <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
    </head>
        <script src="<c:url value='/js/cursorEffect.js'/>"></script>
<style>
    .container-fluid {
        width: 1100px;
    }
    .my-3.ps-4.text-dark > * > * {
        margin-left: 10px;
    }
    .border-top mt-7 pt-7 > * {
        margin-bottom: 10px;
    }
</style>
<jsp:include page="header.jsp" />
<body style="background-color: #eef5f9">
<br><br>
<div class="container-fluid">
    <div class="position-relative mb-4">
        <div class="d-flex justify-content-between align-items-center">
            <div>
                <h4>Project Introduce</h4>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a class="text-primary text-decoration-none" href="<c:url value='/'/>">Home
                            </a>
                        </li>
                        <li class="breadcrumb-item d-flex justify-content-center align-items-center ps-0">
                            <iconify-icon icon="tabler:chevron-right"></iconify-icon>
                        </li>
                        <li class="breadcrumb-item" aria-current="page">추가예정</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
    <div class="card overflow-hidden">
        <div class="position-relative">
            <a href="javascript:void(0)">
                <img src="<c:url value='/bootstrap/assets/images/blog/blog-img5.jpg'/>" class="card-img-top rounded-0 object-fit-cover" alt="xtreme-img" height="440">
            </a>

            <div class="position-relative" style="height: 35px; margin-right: auto;">
                <span class="badge text-bg-light mb-9 me-9 position-absolute" style="right: 10px; bottom: 20px; background-color: transparent !important; color: white !important; font-weight: bold">2024.07.31 14:21 최초등록</span>
                <span class="badge text-bg-light mb-9 me-9 position-absolute" style="right: 10px; bottom: 40px; background-color: transparent !important; color: white !important; font-weight: bold">2024.08.01 17:40 업데이트</span>
                <span class="badge text-bg-light mb-9 me-9 position-absolute" style="right: 10px; bottom: 60px; background-color: transparent !important; color: white !important; font-weight: bold">2024.08.02 18:02 업데이트</span>
                <span class="badge text-bg-light mb-9 me-9 position-absolute" style="right: 10px; bottom: 80px; background-color: transparent !important; color: white !important; font-weight: bold">2024.08.04 23:07 업데이트</span>
            </div>

        <%--            <span class="badge text-bg-light mb-9 me-9 position-absolute bottom-0 end-0">2024.07.31 14:21 최초등록</span>--%>
<%--            <span class="badge text-bg-light mb-9 me-9 position-absolute bottom-0 end-0">2024.08.01 17:40 업데이트</span>--%>
            <img src="<c:url value='/bootstrap/assets/images/profile/user-5.jpg'/>" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Esther Lindsey">
        </div>
        <div class="card-body p-4">
            <span class="badge text-bg-light mt-3">Infomation</span>
            <h2 class="fs-9 fw-semibold my-4">일하고 싶은데.. 공부하면서 만들어본 미니 프로젝트</h2>
            <div class="d-flex align-items-center gap-4">
                <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-eye text-dark fs-5"></i>여긴 조회수 들어갈 곳
                </div>
                <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-message-2 text-dark fs-5"></i>여긴 코멘트 수 들어갈 곳
                </div>
                <div class="d-flex align-items-center fs-2 ms-auto">
                    <i class="ti ti-point text-dark"></i>여긴 작성 날짜랑 요일 들어갈 곳
                </div>
            </div>
        </div>
        <div class="card-body border-top p-4">
            <h2 class="fs-8 fw-semibold mb-3">
            <div class="border-top mt-7 pt-7">
<%--                <h3 class="fw-semibold mb-2">Quotes</h3>--%>
                <div class="p-3 bg-light rounded border-start border-2 border-primary">
                    <h4 class="mb-0 fs-4 fw-semibold">기본은 쉬운게 아니라 중요한 것이다
                        <i class="ti ti-quote fs-7"></i>
                    </h4>
                </div>
            </div>
            </h2>
<%--            --%>
            <div class="border-top mt-7 pt-7">
                <div style="text-align:center">
                    <h4>처음엔 가계부 관련된 프로젝트를 해보고 싶었는데.. 막상 설계 해보니 고려해야할 요소들이
                        <br>너무 많아서 기본기도 없는데 이것저것 해보자는 생각보단 기존에 배웠던 내용들을 바탕으로
                        <br>알고있는 내용들을 다시 한번 재점검 하고자 시작한 미니 프로젝트
                    </h4>
                </div>
                <br>
                <div style="display: flex; align-items: center">
                    <h3 class="fw-semibold">이번 미니프로젝트 목표 → <h4 class="fw-semibold">&nbsp;2024.08.04 기준 1-9 달성</h4></h3>
                </div>
                <ol class="my-3 text-dark">
                    <li>기본적인 CRUD 다시 한번 체크 및 재정리</li>
                    <li>기존에 사용해보지 않았던 DB 사용해보기(기존 : Oracle) → MySQL(*) & PostgreSQL</li>
                    <li>페이징 및 검색 다시 한번 복습</li>
                    <li>테스트 툴 최대한 활용하기 → Junit , Postman</li>
                    <li>Debugging 활용하여 에러 해결하기</li>
                    <li>DB 트랜잭션 적용하여 오류시 데이터의 일관성 유지</li>
                    <li>AWS를 이용한 별도의 서버 구축 및 파일업로드 활용(EC2, S3)</li>
                    <li>특정 기능을 Rest API로 구현해보기</li>
                    <li>설정파일 properties로 관리하기</li>
                    <li>Validation으로 서버에서 유효성 검증하기</li>
                    <li>스프링 시큐리티 사용하여 접근권한 설정하기 → 보안강화</li>
                </ol>
            </div>
<%--            --%>
            <p class="mb-3">
                현재까지 발견한 오류 또는 해결해야할 내용들
                <br>
                <span style="text-decoration: line-through;">
                글작성중 이미지 추가&삭제하고 글등록시 AWS에 최종 이미지만 업로드돼야 하는데 계속 남아있음(게시판에는 내가 올린 이미지만 존재)
                </span> → 이건 수정 완료
                <br>
                글삭제시 DB랑 AWS에서 삭제해야하는데 이게 복잡하네.. → 일부 해결완료(70~80%?)..
                <br>
                Validation을 이용한 서버단 유효성 검증 체크
                <br>
                디자인이 조잡하다..일부 css 적용되지 않는 문제
                <br>
                Home탭에서 역순보기/한번에 열기시 이벤트 동작 오류있음..몇시간 찾아봤지만 해결실패하여 우선 보류..
            </p>
            <p class="text-dark mb-0">
                <strong>현재 페이지도 나중에 내용들을 DB화 해서 데이터 별도 저장 예정(관리자만 등록↔수정)</strong>
                <br>
                <strong>통계 관련된것들도 다뤄보고싶다..</strong>
                <br>
                <strong>이번 한번만 하고 끝이 아니라 계속해서 발전시킬 예정</strong>
            </p>
                <br>
            <span class="mb-0">
                <em>디자인은 양해좀..</em>
            </span>
            <div class="border-top mt-7 pt-7">
                <h3 class="fw-semibold">개발기간 및 과정</h3>
                <ul class="my-3 ps-4 text-dark">
                <h4>2024.07.17 - 2024.08.02 현재 진행중 계속 업데이트 예정</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>기본적인 가입 인증 로직 설계
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>간단한 게시판 CRUD, 검색 & 페이징 처리
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>AWS를 활용한 별도 서버 구축해보기
                    </li>
                </ul>
            </div>
            <div class="border-top mt-7 pt-7">
                <h3 class="fw-semibold">프로젝트 구축환경</h3>
                <ul class="my-3 ps-4 text-dark">
                <h4>BackEnd</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>IDE : IntelliJ IDEA 2024.1.4
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Java 11 JDK
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Spring 5.3.37
                    </li>
                    <br>
                <h4>Database</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>MySQL 8.0.28
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>MyBatis 3.5.9
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>파일업로드 - AWS S3
                    </li>
                    <br>
                <h4>FrontEnd</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Javascript ES6
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Template engine : JSP, jQuery 3.7.1
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Bootstrap(일부만), HTML5, CSS3
                    </li>
                    <br>
                <h4>ETC..</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Server : AWS EC2 WindowServer 2022
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Web Container : Tomcat 9.0.91
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Postman, Git
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>
</body>
</html>