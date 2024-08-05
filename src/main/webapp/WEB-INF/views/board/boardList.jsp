<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value='/css/board.css'/>">
    <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>자유게시판 게시글리스트</title>
</head>
<style>
    .text-white {
        color: white !important;
    }
    .active>.page-link{
        background-color: #73685d;
    }
</style>
<body>
<script>
    let msg = "${msg}";
    if(msg==="LIST_ERR")  alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
    if(msg==="READ_ERR")  alert("삭제되었거나 없는 게시물입니다.");
    if(msg==="DEL_ERR")   alert("삭제되었거나 없는 게시물입니다.");

    if(msg==="DEL_OK")    alert("성공적으로 삭제되었습니다.");
    if(msg==="WRT_OK")    alert("성공적으로 등록되었습니다.");
    if(msg==="MOD_OK")    alert("성공적으로 수정되었습니다.");
</script>
<jsp:include page="../header.jsp" />
<br>
<div class="search-container">
<h5>로그인을 해야 글쓰기 버튼이 활성화!! -> 미리 버튼 활성화 뒤에 클릭시 로그인 요청하도록 수정 예정</h5>
    <form action="<c:url value='/board/boardList'/>" class="search-form" method="get">
        <select class="search-option" name="option">
            (<option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>)
        </select>
        <input type="text" name="keyword" class="search-input"  value="${ph.sc.keyword}" placeholder="검색어를 입력하세요.">
        <input type="submit" class="search-button" value="검색">
        <br>
        <br>
    <c:if test="${sessionScope.id ne null}">
        <button id="writeBtn" type="button" class="btn-write" onclick="location.href='<c:url value="/board/write"/>'"><i class="fa fa-pencil"></i> 글쓰기</button>
    </c:if>
    </form>
</div>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th class="no">번호</th>
            <th class="title">제목</th>
            <th class="writer">작성자</th>
            <th class="regdate">등록일</th>
            <th class="viewcnt">조회수</th>
        </tr>
        </thead>
        <c:forEach var="boardDTO" items="${boardList}">
        <tr>
            <td class="no">${boardDTO.rownum}</td>
            <td class="title"><a href="<c:url value="/board/read?bno=${boardDTO.bno}"/>"><c:out value="${boardDTO.title}"/></a></td>
            <td class="writer">${boardDTO.writer}</td>
            <c:choose>
                <c:when test="${boardDTO.regDate.time >= startOfToday}">
                    <td class="regdate"><fmt:formatDate value="${boardDTO.regDate}" pattern="HH:mm" type="time"/></td>
                </c:when>
                <c:otherwise>
                    <td class="regdate"><fmt:formatDate value="${boardDTO.regDate}" pattern="yyyy-MM-dd" type="date"/></td>
                </c:otherwise>
            </c:choose>
            <td class="viewcnt">${boardDTO.viewCnt}</td>
        </tr>
        </c:forEach>
    </table>
    <br>
</div>
<!-- 기존페이징 시작 -->
<%--<div class="paging-container">--%>
<%--    <div class="paging">--%>
<%--        <c:if test="${totalCnt==null || totalCnt==0}">--%>
<%--            <div> 게시물이 없습니다. </div>--%>
<%--        </c:if>--%>
<%--        <c:if test="${totalCnt!=null && totalCnt!=0}">--%>
<%--            <c:if test="${ph.showPrev}">--%>
<%--                <a class="page" href="<c:url value="/board/boardList${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>--%>
<%--            </c:if>--%>
<%--            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--                <a class="page ${i == ph.sc.page ? "paging-active" : ""}" href="<c:url value="/board/boardList${ph.sc.getQueryString(i)}"/>">${i}</a>--%>
<%--            </c:forEach>--%>
<%--            <c:if test="${ph.showNext}">--%>
<%--                <a class="page" href="<c:url value="/board/boardList${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>--%>
<%--            </c:if>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- 기존페이징 끝 -->

<nav aria-label="...">
    <ul class="pagination justify-content-center mb-0 mt-4">
        <c:if test="${totalCnt==null || totalCnt==0}">
            <div> 게시물이 없습니다. </div>
        </c:if>
        <c:if test="${totalCnt != null && totalCnt != 0}">
            <c:if test="${ph.showPrev}">
                <li class="page-item">
                    <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center" href="<c:url value='/board/boardList${ph.sc.getQueryString(ph.beginPage - 1)}' />">
                        <i class="ti ti-chevron-left"></i>
                    </a>
                </li>
            </c:if>
            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                <li class="page-item ${i == ph.sc.page ? 'active' : ''}">
                    <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center ${i == ph.sc.page ? 'text-white' : ''}" href="<c:url value='/board/boardList${ph.sc.getQueryString(i)}' />" >${i}</a>
                </li>
            </c:forEach>
            <c:if test="${ph.showNext}">
                <li class="page-item">
                    <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center" href="<c:url value='/board/boardList${ph.sc.getQueryString(ph.endPage + 1)}' />">
                        <i class="ti ti-chevron-right"></i>
                    </a>
                </li>
            </c:if>
        </c:if>
    </ul>
</nav>

</body>
</html>