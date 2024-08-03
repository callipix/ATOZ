<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
        <link rel="stylesheet" href="<c:url value='/css/header.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/cursorEffect.css'/>">
        <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
    <script src="<c:url value='/js/cursorEffect.js'/>"></script>
</head>
<body>
<div class="card">
    <div class="card-body">
        <h4 class="mb-4 fw-semibold">To be updated..</h4>
        <form>
            <textarea class="form-control mb-4" rows="5" placeholder="여긴 아직 아무것도 없지만.. 여길 포함해서 아랫부분 전부 나중에 추가 예정!"></textarea>
            <button class="btn btn-primary">Post Comment</button>
        </form>
        <div class="d-flex align-items-center gap-3 mb-4 mt-7 pt-8">
            <h4 class="mb-0">Comments</h4>
            <span class="badge bg-primary-subtle text-primary fs-4 fw-semibold px-6 py-8 rounded">3</span>
        </div>
        <div class="position-relative">
            <div class="p-4 rounded-2 text-bg-light mb-3">
                <div class="d-flex align-items-center gap-3">
                    <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                    <h6 class="mb-0 fs-4">wait...!!</h6>
                    <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                </div>
                <p class="my-3">규모 크게 잡았다가 막상 해보니 할게 너무 많아서 기본적인것만도 벅차다..</p>
                <p class="my-3">그래도 생각보다 너무 재밌었다. 기존에 애매하게 알고있던 것들 정리되는 느낌</p>
                <div class="d-flex align-items-center gap-2">
                    <a class="d-flex align-items-center justify-content-center text-bg-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                        <i class="ti ti-arrow-back-up"></i>
                    </a>
                </div>
            </div>
            <div class="p-4 rounded-2 text-bg-light">
                <div class="d-flex align-items-center gap-3">
                    <img src="<c:url value='/bootstrap/assets/images/profile/user-4.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                    <h6 class="mb-0 fs-4">Seth Ortiz</h6>
                    <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span>
                </div>
                <p class="my-3">
                    추가해 보고싶은 기능들 : 알림, 채팅, 통계관련, 캘린더, 가계부 등등
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
</body>
</html>
