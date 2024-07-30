<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<!-- Core Css -->

<link rel="shortcut icon" type="image/png" href="<c:url value='/bootstrap/assets/images/logos/favicon.png'/>" />
<link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/board.css'/>">
<link type="text/css" rel="stylesheet" charset="UTF-8" href="https://www.gstatic.com/_/translate_http/_/ss/k=translate_http.tr.26tY-h6gH9w.L.W.O/am=Phg/d=0/rs=AN8SPfor9mOnrVSOJ5Dp4JexmA5DU8Siog/m=el_main_css">
<style>
    .container-fluid {
        max-width: 70%;
    }
    .card.card-body {
        text-align: center;
    }
    .col-md-4.col-xl-3 {
        margin: auto;
        display: flex;
    }
    .search-container > * > select  {
        font-weight: bold;
    }
</style>
<body>
<jsp:include page="../header.jsp" />
<br>

<script>
    let msg = "${msg}";
</script>
<div class="container-fluid">
    <div class="position-relative mb-4">
        <div>
            <br>
            <h4>그동안 경험했던 에러와 오류들을 기록하는 게시판 07.30 내로 구현 예정</h4>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a class="text-primary text-decoration-none" href=main/index.html">Home
                        </a>
                    </li>
                    <li class="breadcrumb-item d-flex justify-content-center align-items-center ps-0">
                        <iconify-icon icon="tabler:chevron-right"></iconify-icon>
                    </li>
                    <li class="breadcrumb-item" aria-current="page">Blog</li>
                </ol>
            </nav>
        </div>
        <div>
            <div class="d-flex justify-content-end align-items-center">
                <div class="me-2">
                    <button type="button" class="btn bg-primary-subtle text-primary" onclick="location.href='<c:url value="errorWrite"/>'">글쓰기
                    </button>
                </div>
            </div>
        </div>
    </div>
    <%-- 검색 서치바 시작--%>
    <div class="search-container">
        <h5>로그인을 해야 글쓰기 버튼이 활성화!! -> 미리 버튼 활성화 뒤에 클릭시 로그인 요청하도록 수정 예정</h5>
        <form action="<c:url value='/errorBoard/list'/>" class="search-form" method="get">
            <select class="btn bg-primary-subtle text-primary" name="option">
                (<option value="eAndT" ${ph.sc.option=='E' || ph.sc.option=='' ? "selected" : ""}>에러코드+제목</option>)
                <option value="A"     ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                <option value="E"     ${ph.sc.option=='E' ? "selected" : ""}>에러코드</option>
                <option value="T"     ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                <option value="W"     ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>)
            </select>
            <input type="text" name="keyword" class="search-input" style="height: 37px" value="${ph.sc.keyword}" placeholder="검색어를 입력하세요.">
            <input type="submit" class="btn bg-primary-subtle text-primary" value="검색">
            <br>
            <br>
            <c:if test="${sessionScope.id ne null}">
                <button id="writeBtn" type="button" class="btn-write" onclick="location.href='<c:url value="/board/write"/>'"><i class="fa fa-pencil"></i> 글쓰기</button>
            </c:if>
        </form>
    </div>
    <%-- 검색 서치바 끝--%>
    <br>

    <div class="row">
        <div class="col-md-6 col-lg-8">
            <div class="card blog blog-img-one position-relative overflow-hidden hover-img">
                <div class="card-body position-relative">
                    <div class="d-flex flex-column justify-content-between h-100">
                        <div class="d-flex align-items-start justify-content-between">
                            <div class="position-relative" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Mollie Underwood">
                                <img src="<c:url value='/bootstrap/assets/images/profile/user-4.jpg'/>" alt="xtreme-img" class="rounded-circle img-fluid" width="40" height="40">
                            </div>
                            <span class="badge text-bg-primary fs-2 fw-semibold">Gadget</span>
                        </div>
                        <div>
                            <a href="../main/blog-detail.html" class="fs-7 my-4 fw-semibold text-white d-block lh-sm text-primary">Early Black Friday
                                Amazon deals: cheap TVs, headphones, laptops</a>
                            <div class="d-flex align-items-center gap-4">
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-eye fs-5"></i>
                                    6006
                                </div>
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-message-2 fs-5"></i>
                                    3
                                </div>
                                <div class="d-flex align-items-center gap-1 text-white fw-normal ms-auto">
                                    <i class="ti ti-point"></i>
                                    <small>Fri, Jan 13</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card blog blog-img-two position-relative overflow-hidden hover-img">
                <div class="card-body position-relative">
                    <div class="d-flex flex-column justify-content-between h-100">
                        <div class="d-flex align-items-start justify-content-between">
                            <div class="position-relative" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Francisco Quinn">
                                <img src="<c:url value='/bootstrap/assets/images/profile/user-5.jpg'/>" alt="xtreme-img" class="rounded-circle img-fluid" width="40" height="40">
                            </div>
                            <span class="badge text-bg-primary fs-2 fw-semibold">Health</span>
                        </div>
                        <div>
                            <a href="../main/blog-detail.html" class="fs-7 my-4 fw-semibold text-white d-block lh-sm">Presented by Max
                                Rushden with Barry Glendenning, Philippe Auclair</a>
                            <div class="d-flex align-items-center gap-4">
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-eye fs-5"></i>
                                    713
                                </div>
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-message-2 fs-5"></i>
                                    3
                                </div>
                                <div class="d-flex align-items-center gap-1 text-white fw-normal ms-auto">
                                    <i class="ti ti-point"></i>
                                    <small>Wed, Jan 18</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="<c:url value='/bootstrap/assets/images/blog/blog-img6.jpg'/>" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Addie Keller">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Gadget</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">As yen
                        tumbles, gadget-loving Japan goes
                        for iPhones</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>9,125
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>3
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Mon, Jan 16
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img11.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-2.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Walter Palmer">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Social</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">Intel loses
                        bid to revive antitrust case
                        against patent foe Fortress</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>4,150
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>38
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Sun, Jan 15
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img8.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-3.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Miguel Kennedy">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Health</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">COVID
                        outbreak deepens as more lockdowns
                        loom in China</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>9,480
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>12
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Sat, Jan 14
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img5.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-5.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Esther Lindsey">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Lifestyle</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">Streaming
                        video way before it was cool, go
                        dark tomorrow</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>2252
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>3
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Sat, Jan 14
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img3.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-3.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Leroy Greer">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Design</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">Apple is
                        apparently working on a new
                        ‘streamlined’ accessibility</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>5860
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>38
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Fri, Jan 13
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img2.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-2.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Tommy Butler">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Lifestyle</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">After
                        Twitter Staff Cuts, Survivors Face
                        ‘Radio Silence</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>6315
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>12
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Wed, Jan 11
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img4.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-4.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Donald Holmes">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Design</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">Why Figma is
                        selling to Adobe for $20
                        billion</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>7570
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>38
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Wed, Jan 11
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                <div class="position-relative">
                    <a href="../main/blog-detail.html">
                        <img src="../assets/images/blog/blog-img1.jpg" class="card-img-top" alt="xtreme-img">
                    </a>
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                    <img src="../assets/images/profile/user-6.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Eric Douglas">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Gadget</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="../main/blog-detail.html">Garmins
                        Instinct Crossover is a rugged
                        hybrid smartwatch</a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>6763
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>12
                        </div>
                        <div class="d-flex align-items-center fs-2 ms-auto">
                            <i class="ti ti-point text-dark"></i>Tue, Jan 10
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <nav aria-label="...">
        <ul class="pagination justify-content-center mb-0 mt-4">
            <c:if test="${totalCnt==null || totalCnt==0}">
                <div> 게시물이 없습니다. </div>
            </c:if>
            <c:if test="${totalCnt != null && totalCnt != 0}">
                <c:if test="${ph.showPrev}">
                    <li class="page-item">
                        <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center" href="<c:url value='/errorBoard/list${ph.sc.getQueryString(ph.beginPage - 1)}' />">
                            <i class="ti ti-chevron-left"></i>
                        </a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <li class="page-item ${i == ph.sc.page ? 'active' : ''}">
                        <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="<c:url value='/errorBoard/list${ph.sc.getQueryString(i)}' />">${i}</a>
                    </li>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <li class="page-item">
                        <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center" href="<c:url value='/errorBoard/list${ph.sc.getQueryString(ph.endPage + 1)}' />">
                            <i class="ti ti-chevron-right"></i>
                        </a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </nav>
</div>
<br><br>
</body>