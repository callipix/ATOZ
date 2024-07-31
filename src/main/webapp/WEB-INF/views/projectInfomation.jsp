<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Title</title>
    <head>
        <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
        <script src="<c:url value='/js/cursorEffect.js'/>"></script>
        <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
    </head>
<style>
    .container-fluid {
        width: 1100px;
    }
    .my-3.ps-4.text-dark > * > * {
        margin-left: 10px;
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
                        <li class="breadcrumb-item" aria-current="page">Blog Detail</li>
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
            <span class="badge text-bg-light mb-9 me-9 position-absolute bottom-0 end-0">2024.07.31 14:21 최초등록</span>
            <img src="<c:url value='/bootstrap/assets/images/profile/user-5.jpg'/>" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Esther Lindsey">
        </div>
        <div class="card-body p-4">
            <span class="badge text-bg-light mt-3">Infomation</span>
            <h2 class="fs-9 fw-semibold my-4">취업이 너무 안되서 뭐라도 해보려고 만들어본 홈페이지</h2>
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
                <h3 class="fw-semibold mb-2">Quotes</h3>
                <div class="p-3 bg-light rounded border-start border-2 border-primary">
                    <h4 class="mb-0 fs-4 fw-semibold">기본이라는건, 쉬운게 아니라 중요한 것이다
                        <i class="ti ti-quote fs-7"></i>
                    </h4>
                </div>
            </div>
            </h2>
<%--            --%>
            <div class="border-top mt-7 pt-7">
                <div style="display: flex; align-items: center">
                    <h3 class="fw-semibold">이번 미니프로젝트 목표 → <h4 class="fw-semibold">&nbsp;2024.07.31 기준 1-9 달성</h4></h3>
                </div>
                <ol class="my-3 text-dark">
                    <li>기본적인 CRUD 내용 다시 한번 체크 및 재정리</li>
                    <li>기존에 사용해보지 않았던 DB를 활용해보기(기존 : Oracle) → MySQL(*pick) & PostgreSQL</li>
                    <li>페이징 처리 및 검색에 대해 다시 한번 복습</li>
                    <li>테스트 툴을 최대한 활용해보기 → Junit , Postman</li>
                    <li>Debugging을 활용하여 에러 해결하기</li>
                    <li>DB 트랜잭션을 적용하여 오류시 데이터의 일관성 유지</li>
                    <li>AWS를 이용한 별도의 서버 구축 및 파일업로드 활용(EC2, S3)</li>
                    <li>특정 기능을 Rest API로 구현해보기</li>
                    <li>key와 관련된 파일들을(api-key..) properties파일로 만들어서 관리하기</li>
                    <li>Validation을 이용해서 서버에서 유효성 검증하기</li>
                    <li>스프링 시큐리티를 사용하여 접근권한 설정하기 → 보안강화</li>
                </ol>
            </div>
<%--            --%>
            <p class="mb-3">
                현재까지 발견한 오류 또는 해결해야할 내용들
                <br>
                오류게시판 글 작성 도중 이미지 추가&삭제 후 글작성시 AWS에 최종 이미지만 업로드돼야 하는데 계속 남아있음(게시판에는 내가 올린 이미지만 존재)
                <br>
                Validation을 이용한 서버단 유효성 검증 체크
                <br>
                디자인이 조잡하다..일부 css 적용되지 않는 문제
                <br>
                home탭에서 역순보기/한번에 열기시 이벤트 동작 오류있음..몇시간 찾아봤지만 해결실패하여 우선 보류..
            </p>
            <p class="mb-3">

            </p>
            <p class="text-dark mb-0">
                <strong>현재 페이지도 나중에 내용들을 DB화 해서 데이터 별도 저장 예정</strong>
                <br>
                <strong>통계 관련된것들도 다뤄보고싶다..</strong>
                <br>
                <strong>이번 한번만 하고 끝이 아니라 계속해서 발전시킬 예정</strong>
            </p>
                <br>
            <p class="mb-0">
                <em>This is italic text.</em>
            </p>
            <div class="border-top mt-7 pt-7">
                <h3 class="fw-semibold">개발기간 및 과정</h3>
                <ul class="my-3 ps-4 text-dark">
                <h4>2024.07.17 - 2024.07.31 진행중</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>1
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>2
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>3
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
                        <span class="p-1 text-bg-dark rounded-circle"></span>Javascript
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>JSP(template engine), jQuery 3.7.1
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>BootStrap(일부만), HTML ES6, CSS3
                    </li>
                    <br>
                <h4>Ect..</h4>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>AWS EC2 WindowServer
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Tomcat 9.0.91
                    </li>
                    <li class="d-flex align-items-center gap-2">
                        <span class="p-1 text-bg-dark rounded-circle"></span>Postman, Git
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-body">
            <h4 class="mb-4 fw-semibold">To be updated..</h4>
            <form>
                <textarea class="form-control mb-4" rows="5" placeholder="여긴 아직 아무것도 없지만.. 나중에 추가 예정!"></textarea>
                <button class="btn btn-primary">Post Comment</button>
            </form>
            <div class="d-flex align-items-center gap-3 mb-4 mt-7 pt-8">
                <h4 class="mb-0">Comments</h4>
                <span class="badge bg-primary-subtle text-primary fs-4 fw-semibold px-6 py-8 rounded">3</span>
            </div>
            <div class="position-relative">
                <div class="p-4 rounded-2 text-bg-light mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <img src="<c:url value='/bootstrap/assets/images/profile/user-2.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                        <h6 class="mb-0 fs-4">Don Russell</h6>
                        <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                    </div>
                    <p class="my-3">Es do ujurus nejson imju azgudpi toceztep ji cocicoci bosawrop korze ta.
                        Casetlu udumej umocu wanaro webmos ijafa ud muli amja softoj ma pijum.
                    </p>
                    <div class="d-flex align-items-center gap-2">
                        <a class="d-flex align-items-center justify-content-center text-bg-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                            <i class="ti ti-arrow-back-up"></i>
                        </a>
                    </div>
                </div>
                <div class="p-4 rounded-2 text-bg-light mb-3">
                    <div class="d-flex align-items-center gap-3">
                        <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                        <h6 class="mb-0 fs-4">Cordelia Potter</h6>
                        <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                    </div>
                    <p class="my-3">Huwso jewzehgu julriw niwgazep lewbob isujirmuz hemto pahop cewa zuhucze rinitba
                        etdebluj.
                        Obdevo bo fa siztes laobeir agoemugo rut sapaviw mulati do re dabelul wo tumnik wih mu.
                    </p>
                    <div class="d-flex align-items-center gap-2">
                        <a class="d-flex align-items-center justify-content-center text-bg-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                            <i class="ti ti-arrow-back-up"></i>
                        </a>
                    </div>
                </div>
                <div class="p-4 rounded-2 text-bg-light mb-3 ms-7">
                    <div class="d-flex align-items-center gap-3">
                        <img src="<c:url value='/bootstrap/assets/images/profile/user-6.jpg'/>" alt="xtreme-img" class="rounded-circle" width="40" height="40">
                        <h6 class="mb-0 fs-4">Irene Hanson</h6>
                        <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                    </div>
                    <p class="my-3">Uborofgic be rof lom sedge vapozi ohoinu nutremcuc ro ko atmeg anrov git ve vuj ki teb
                        or.
                        Lohi hafa faddegon horoz ebema kew idful ducam nev rol iga wikkobsu sucdu gud.
                    </p>
                </div>
                <div class="p-4 rounded-2 text-bg-light">
                    <div class="d-flex align-items-center gap-3">
                        <img src="<c:url value='/bootstrap/assets/images/profile/user-4.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                        <h6 class="mb-0 fs-4">Seth Ortiz</h6>
                        <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                    </div>
                    <p class="my-3">Icme rasejmat ciwo ifekemug owoca vicoz ukikitus famiftat nuk eroewu za upe.
                        Pobrikvup kivofvac tuba ot veh ozoab sa gesi hahoniha hop burbip volo hufotobo di uted vojoamu.
                    </p>
                    <div class="d-flex align-items-center gap-2">
                        <a class="d-flex align-items-center justify-content-center text-bg-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                            <i class="ti ti-arrow-back-up"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>