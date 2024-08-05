<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en" dir="ltr" data-bs-theme="light" data-color-theme="Blue_Theme" data-layout="horizontal">

<head>
  <!-- Required meta tags -->
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- Favicon icon-->
  <link rel="shortcut icon" type="image/png" href="<c:url value='/bootstrap/assets/images/logos/favicon.png'/>" />
  <!-- Core Css -->
  <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />

  <title>404 Error Page</title>
</head>

<body>
  <!-- Preloader -->
  <div class="preloader">
    <img src="<c:url value='/bootstrap/assets/images/logos/logo-icon.svg'/>" alt="loader" class="lds-ripple img-fluid" />
  </div>
  <div id="main-wrapper">
    <div class="position-relative overflow-hidden min-vh-100 w-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-lg-4">
            <div class="text-center">
              <img src="<c:url value='/bootstrap/assets/images/backgrounds/errorimg.svg'/>" alt="xtreme-img" class="img-fluid mb-3" width="500" />
              <h1 class="fw-semibold mb-7 fs-9"></h1>
              <h4 class="fw-semibold mb-7">뭔가 문제가 있을때 나오는 창</h4>
              <h4 class="fw-semibold mb-7">아직 구현되지 않았을 가능성이 큽니다.</h4>
              <a class="btn btn-primary" href="<c:url value='/'/>" role="button" style="font-weight: bold">일단 집으로</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--  Search Bar -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-hidden="true">
      <div class="modal-dialog modal-dialog-scrollable modal-lg">
        <div class="modal-content rounded-1">
          <div class="modal-header border-bottom">
            <input type="search" class="form-control fs-3" placeholder="Search here" id="search" />
            <a href="javascript:void(0)" data-bs-dismiss="modal" class="lh-1">
              <i class="ti ti-x fs-5 ms-3"></i>
            </a>
          </div>
          <div class="modal-body message-body" data-simplebar="">
            <h5 class="mb-0 fs-5 p-1">Quick Page Links</h5>
            <ul class="list mb-0 py-2">
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Modern</span>
                  <span class="fs-3 text-muted d-block">/dashboards/dashboard1</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Dashboard</span>
                  <span class="fs-3 text-muted d-block">/dashboards/dashboard2</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Contacts</span>
                  <span class="fs-3 text-muted d-block">/apps/contacts</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Posts</span>
                  <span class="fs-3 text-muted d-block">/apps/blog/posts</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Detail</span>
                  <span class="fs-3 text-muted d-block">/apps/blog/detail/streaming-video-way-before-it-was-cool-go-dark-tomorrow</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Shop</span>
                  <span class="fs-3 text-muted d-block">/apps/ecommerce/shop</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Modern</span>
                  <span class="fs-3 text-muted d-block">/dashboards/dashboard1</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Dashboard</span>
                  <span class="fs-3 text-muted d-block">/dashboards/dashboard2</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Contacts</span>
                  <span class="fs-3 text-muted d-block">/apps/contacts</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Posts</span>
                  <span class="fs-3 text-muted d-block">/apps/blog/posts</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  h6 mb-0 d-block">Detail</span>
                  <span class="fs-3 text-muted d-block">/apps/blog/detail/streaming-video-way-before-it-was-cool-go-dark-tomorrow</span>
                </a>
              </li>
              <li class="p-1 mb-1 px-2 rounded bg-hover-light-black">
                <a href="javascript:void(0)">
                  <span class="fs-3  fw-normal d-block">Shop</span>
                  <span class="fs-3 text-muted d-block">/apps/ecommerce/shop</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="dark-transparent sidebartoggler"></div>
  <!-- Import Js Files -->
  <script src="<c:url value='/bootstrap/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js'/>"></script>
  <script src="<c:url value='/bootstrap/assets/libs/simplebar/dist/simplebar.min.js'/>"></script>
  <script src="<c:url value='/bootstrap/assets/js/theme/app.horizontal.init.js'/>"></script>
  <script src="<c:url value='/bootstrap/assets/js/theme/theme.js'/>"></script>
  <script src="<c:url value='/bootstrap/assets/js/theme/app.min.js'/>"></script>
  <script src="<c:url value='/bootstrap/assets/js/theme/feather.min.js'/>"></script>

  <!-- solar icons -->
  <script src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
</body>

</html>