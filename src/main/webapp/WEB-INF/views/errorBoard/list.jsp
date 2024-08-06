<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<!-- Core Css -->
<title>에러게시판 게시글 리스트</title>
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
    .btn.bg-primary-subtle.text-primary, .search-input, .search-form {
        margin-right: 10px;
        width: auto;;
    }
    .text-truncate {
        max-width: 300px; /* 원하는 너비를 설정하세요 */
        display: inline-block; /* 또는 block, flex 등 상황에 맞게 설정 */
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>
<body>
<jsp:include page="../header.jsp" />
<br>

<script>
    let msg = "${msg}";

    if(msg =="WRT_OK") alert("글쓰기가 완료되었습니다.")
</script>
<div class="container-fluid">
    <div class="position-relative mb-4">
        <div>
            <br>
            <h4>그동안 경험했던 에러와 오류들을 기록할 트러블슈팅 게시판</h4>
        </div>
    </div>
    <%-- 검색 서치바 시작--%>
    <div class="search-container">
        <h5>로그인을 해야 글쓰기 버튼이 활성화!! -> 미리 버튼 활성화 뒤에 클릭시 로그인 요청하도록 수정 예정</h5>
        <form action="<c:url value='/errorBoard/list'/>" class="search-form" method="get">
            <select class="btn bg-primary-subtle text-primary" name="option">
               (<option value="eAndT" ${ph.sc.option=='eAndT' ? "selected" : ""}>에러코드+제목</option>)
                <option value="A"     ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                <option value="E"     ${ph.sc.option=='E'     ? "selected" : ""}>에러코드</option>
                <option value="T"     ${ph.sc.option=='T'     ? "selected" : ""}>제목만</option>
                <option value="W"     ${ph.sc.option=='W'     ? "selected" : ""}>작성자</option>)
            </select>
            <input type="text" name="keyword" class="search-input" style="height: 37px" value="${ph.sc.keyword}" placeholder="검색어를 입력하세요.">
            <input type="submit" class="btn bg-primary-subtle text-primary" value="검색">
            <br>
            <c:if test="${sessionScope.id ne null}">
                    <div class="d-flex justify-content-end align-items-center">
                        <div class="me-2">
                            <button style="width: 100px;" type="button" class="btn bg-primary-subtle text-primary" onclick="location.href='<c:url value="write"/>'">글쓰기
                            </button>
                        </div>
                    </div>
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
                            <span class="badge text-bg-primary fs-2 fw-semibold">나중에 카테고리 세분화 되면</span>
                        </div>
                        <div>
                            <a href="<c:url value='/errorBoard/read?errBno=${errorBoardDTO.errBno}'/>" class="fs-7 my-4 fw-semibold text-white d-block lh-sm text-primary">여긴 일주일동안 조회수 상위였던 게시물 추가 예정</a>
                            <div class="d-flex align-items-center gap-4">
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-eye fs-5"></i>
                                    조회수 들어갈곳
                                </div>
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-message-2 fs-5"></i>
                                    댓글수 들어갈곳
                                </div>
                                <div class="d-flex align-items-center gap-1 text-white fw-normal ms-auto">
                                    <i class="ti ti-point"></i>
                                    <small>작성 날짜 들어갈곳 (형식 :ex)Fri, Jan 13)</small>
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
                            <span class="badge text-bg-primary fs-2 fw-semibold">나중에 카테고리 세분화 되면</span>
                        </div>
                        <div>
                            <a href="../main/blog-detail.html" class="fs-7 my-4 fw-semibold text-white d-block lh-sm">여긴 일주일동안 추천수 상위였던 게시물 추가 예정</a>
                            <div class="d-flex align-items-center gap-4">
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-eye fs-5"></i>
                                    조회수
                                </div>
                                <div class="d-flex align-items-center gap-2 text-white fs-3 fw-normal">
                                    <i class="ti ti-message-2 fs-5"></i>
                                    추천수
                                </div>
                                <div class="d-flex align-items-center gap-1 text-white fw-normal ms-auto">
                                    <i class="ti ti-point"></i>
                                    <small>작성날짜</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:forEach var="errorBoardDTO" items="${boardList}">
        <div class="col-md-6 col-lg-4">
            <div class="card overflow-hidden hover-img">
                    <a href="<c:url value='/errorBoard/read?errBno=${errorBoardDTO.errBno}'/>">
                <div class="position-relative">

                        <img src="<c:url value='/bootstrap/assets/images/blog/blog-img6.jpg'/>" class="card-img-top" alt="xtreme-img">
                    <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">${errorBoardDTO.writer}</span>
                    <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Addie Keller">
                </div>
                <div class="card-body p-4">
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3" name="title">${errorBoardDTO.title}</span>
                    <br>
                    <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3 text-truncate" name="title">에러코드 : ${errorBoardDTO.errCode}</span>
                    <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="<c:url value='/errorBoard/read?errBno=${errorBoardDTO.errBno}'/>"></a>
                    <div class="d-flex align-items-center gap-4">
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-eye text-dark fs-5"></i>${errorBoardDTO.viewCnt}
                        </div>
                        <div class="d-flex align-items-center gap-2">
                            <i class="ti ti-message-2 text-dark fs-5"></i>${errorBoardDTO.commentCnt}
                        </div>
                            <div class="d-flex align-items-center fs-2 ms-auto">
                        <c:choose>
                            <c:when test="${errorBoardDTO.regDate.time >= startOfToday}">
                                <i class="ti ti-point text-dark" name="regDate">
                                    <fmt:formatDate value="${errorBoardDTO.regDate}" pattern="HH:mm" type="time" />
                                </i>
                            </c:when>
                            <c:otherwise>
                                <i class="ti ti-point text-dark" name="regDate">
                                    <fmt:formatDate value="${errorBoardDTO.regDate}" pattern="yyyy-MM-dd" type="date" />
                                </i>
                            </c:otherwise>
                        </c:choose>
                            </div>
                    </div>
                </div>
            </div>
            </a>
        </div>
        </c:forEach>
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
                        <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center ${i == ph.sc.page ? 'text-white' : ''}" href="<c:url value='/errorBoard/list${ph.sc.getQueryString(i)}' />">${i}</a>
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