<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true"%>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" type="image/png"  href="<c:url value='/assets/images/logos/favicon.png'/>">
  <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>" />
  <title>이력서 페이지</title>
  <style>
    .container-fluid {
      width: 1100px;
      margin: auto;
    }
  </style>
<body>
<jsp:include page="../header.jsp" />
<br><br>
<div class="container-fluid">
          <div class="position-relative mb-4">
            <div class="d-flex justify-content-between align-items-center">
              <div>
                <h4>User Profile</h4>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a class="text-primary text-decoration-none" href="../main/index.html">Home
                      </a>
                    </li>
                    <li class="breadcrumb-item d-flex justify-content-center align-items-center ps-0">
                      <iconify-icon icon="tabler:chevron-right"></iconify-icon>
                    </li>
                    <li class="breadcrumb-item" aria-current="page">User Profile</li>
                  </ol>
                </nav>
              </div>
              <div>
              </div>
            </div>
          </div>
          <div class="card overflow-hidden">
            <div class="card-body p-0">
              <img src="<c:url value='/bootstrap/assets/images/backgrounds/profilebg.jpg'/>" alt="xtreme-img" class="img-fluid">
              <div class="row align-items-center">
                <div class="col-lg-4 order-lg-1 order-2">
                  <div class="d-flex align-items-center justify-content-around m-4">
                    <div class="text-center">
                      <i class="ti ti-file-description fs-6 d-block mb-2"></i>
                      <h4 class="mb-0 lh-1">938</h4>
                      <p class="mb-0 ">Posts</p>
                    </div>
                    <div class="text-center">
                      <i class="ti ti-user-circle fs-6 d-block mb-2"></i>
                      <h4 class="mb-0 lh-1">3,586</h4>
                      <p class="mb-0 ">Followers</p>
                    </div>
                    <div class="text-center">
                      <i class="ti ti-user-check fs-6 d-block mb-2"></i>
                      <h4 class="mb-0 lh-1">2,659</h4>
                      <p class="mb-0 ">Following</p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 mt-n3 order-lg-2 order-1">
                  <div class="mt-n5">
                    <div class="d-flex align-items-center justify-content-center mb-2">
                      <div class="d-flex align-items-center justify-content-center round-110">
                        <div class="border border-4 border-white d-flex align-items-center justify-content-center rounded-circle overflow-hidden round-100">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-1.jpg'/>" alt="xtreme-img" class="w-100 h-100">
                        </div>
                      </div>
                    </div>
                    <div class="text-center">
                      <h5 class="mb-0">Lee Jae Hoon</h5>
                      <p class="mb-0">Developer</p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-4 order-last">
                  <ul class="list-unstyled d-flex align-items-center justify-content-center justify-content-lg-end my-3 mx-4 pe-xxl-4 gap-3">
                    <li>
                      <a class="d-flex align-items-center justify-content-center btn btn-primary p-2 fs-4 rounded-circle" href="javascript:void(0)" width="30" height="30">
                        <i class="ti ti-brand-facebook"></i>
                      </a>
                    </li>
                    <li>
                      <a class="btn btn-secondary d-flex align-items-center justify-content-center p-2 fs-4 rounded-circle" href="javascript:void(0)">
                        <i class="ti ti-brand-dribbble"></i>
                      </a>
                    </li>
                    <li>
                      <a class="btn btn-danger d-flex align-items-center justify-content-center p-2 fs-4 rounded-circle" href="javascript:void(0)">
                        <i class="ti ti-brand-youtube"></i>
                      </a>
                    </li>
                    <li>
                      <button class="btn btn-primary text-nowrap" id="addStoryBtn">Add To Story</button>
                    </li>
                  </ul>
                </div>
              </div>
              <ul class="nav nav-pills user-profile-tab justify-content-end mt-2 bg-primary-subtle rounded-2 rounded-top-0" id="pills-tab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active hstack gap-2 rounded-0 py-6" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile" aria-selected="true">
                    <i class="ti ti-user-circle fs-5"></i>
                    <span class="d-none d-md-block">Profile</span>
                  </button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link hstack gap-2 rounded-0 py-6" id="pills-followers-tab" data-bs-toggle="pill" data-bs-target="#pills-followers" type="button" role="tab" aria-controls="pills-followers" aria-selected="false" tabindex="-1">
                    <i class="ti ti-heart fs-5"></i>
                    <span class="d-none d-md-block">Followers</span>
                  </button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link hstack gap-2 rounded-0 py-6" id="pills-friends-tab" data-bs-toggle="pill" data-bs-target="#pills-friends" type="button" role="tab" aria-controls="pills-friends" aria-selected="false" tabindex="-1">
                    <i class="ti ti-user-circle fs-5"></i>
                    <span class="d-none d-md-block">Friends</span>
                  </button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link hstack gap-2 rounded-0 py-6" id="pills-gallery-tab" data-bs-toggle="pill" data-bs-target="#pills-gallery" type="button" role="tab" aria-controls="pills-gallery" aria-selected="false" tabindex="-1">
                    <i class="ti ti-photo-plus fs-5"></i>
                    <span class="d-none d-md-block">Gallery</span>
                  </button>
                </li>
              </ul>
            </div>
          </div>
          <div class="tab-content" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab" tabindex="0">
              <div class="row">
                <div class="col-lg-4">
                  <div class="card shadow-none border">
                    <div class="card-body">
                      <h4 class="mb-3">Introduction</h4>
                      <p class="card-subtitle">안녕하세요 개발자가 되고싶은 이재훈입니다.</p>
                      <div class="vstack gap-3 mt-4">
                        <div class="hstack gap-6">
                          <i class="ti ti-briefcase text-dark fs-6"></i>
                          <h6 class=" mb-0">Sir, P P Institute Of Science</h6>
                        </div>
                        <div class="hstack gap-6">
                          <i class="ti ti-mail text-dark fs-6"></i>
                          <h6 class=" mb-0">xyzstevejobs@gmail.com</h6>
                        </div>
                        <div class="hstack gap-6">
                          <i class="ti ti-device-desktop text-dark fs-6"></i>
                          <h6 class=" mb-0">www.xyz.com</h6>
                        </div>
                        <div class="hstack gap-6">
                          <i class="ti ti-map-pin text-dark fs-6"></i>
                          <h6 class=" mb-0">Newyork, USA - 100001</h6>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card shadow-none border">
                    <div class="card-body">
                      <h4 class="fw-semibold mb-3">Photos</h4>
                      <div class="row">
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-1.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-2.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-4.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-5.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-6.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-7.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-8.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                        <div class="col-4">
                          <img src="<c:url value='/bootstrap/assets/images/profile/user-9.jpg'/>" alt="xtreme-img" class="rounded-1 img-fluid mb-9">
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-8">
                  <div class="card shadow-none border">
                    <div class="card-body">
                      <div class="form-floating mb-3">
                        <textarea class="form-control h-140" placeholder="Leave a comment here" id="floatingTextarea2"></textarea>
                        <label for="floatingTextarea2">Share your thoughts</label>
                      </div>
                      <div class="d-flex align-items-center gap-6 flex-wrap">
                        <div class="hstack align-self-center gap-3">
                          <div class="hstack gap-6">
                            <a class="p-0 hstack justify-content-center round-32 btn btn-primary rounded-circle" href="javascript:void(0)">
                              <i class="ti ti-photo"></i>
                            </a>
                            <a href="javascript:void(0)" class="text-dark link-primary">Photo / Video</a>
                          </div>
                          <div class="hstack gap-6">
                            <a class="hstack p-0 round-32 justify-content-center btn btn-secondary rounded-circle" href="javascript:void(0)">
                              <i class="ti ti-notebook"></i>
                            </a>
                            <a href="javascript:void(0)" class="text-dark link-secondary">Article</a>
                          </div>
                        </div>
                        <button class="btn btn-primary ms-auto">Post</button>
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-body border-bottom">
                      <div class="d-flex align-items-center gap-6 flex-wrap">
                        <img src="<c:url value='/bootstrap/assets/images/profile/user-1.jpg'/>" alt="xtreme-img" class="rounded-circle" width="40" height="40">
                        <h6 class="mb-0">Steve Jobs</h6>
                        <span class="fs-2 hstack gap-2">
                          <span class="round-10 text-bg-light rounded-circle d-inline-block"></span> 15 min
                          ago
                        </span>
                      </div>
                      <p class="text-dark my-3">
                        Nu kek vuzkibsu mooruno ejepogojo uzjon gag fa ezik disan he nah. Wij wo pevhij tumbug rohsa
                        ahpi ujisapse lo vap labkez eddu suk.
                      </p>
                      <img src="<c:url value='/bootstrap/assets/images/products/s1.jpg'/>" alt="xtreme-img" height="360" class="rounded-2 w-100 object-fit-cover">
                      <div class="d-flex align-items-center my-3">
                        <div class="d-flex align-items-center gap-2">
                          <a class="round-32 rounded-circle btn btn-primary p-0 hstack justify-content-center" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Like">
                            <i class="ti ti-thumb-up"></i>
                          </a>
                          <span class="text-dark fw-semibold">67</span>
                        </div>
                        <div class="d-flex align-items-center gap-2 ms-4">
                          <a class="round-32 rounded-circle btn btn-secondary p-0 hstack justify-content-center" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Comment">
                            <i class="ti ti-message-2"></i>
                          </a>
                          <span class="text-dark fw-semibold">2</span>
                        </div>
                        <a class="text-dark ms-auto d-flex align-items-center justify-content-center bg-transparent p-2 fs-4 rounded-circle" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Share">
                          <i class="ti ti-share"></i>
                        </a>
                      </div>
                      <div class="position-relative">
                        <div class="p-4 rounded-2 text-bg-light mb-3">
                          <div class="d-flex align-items-center gap-6 flex-wrap">
                            <img src="<c:url value='/bootstrap/assets/images/profile/user-3.jpg'/>" alt="xtreme-img" class="rounded-circle" width="33" height="33">
                            <h6 class="mb-0">Deran Mac</h6>
                            <span class="fs-2">
                              <span class="p-1 text-bg-muted rounded-circle d-inline-block"></span> 8 min ago
                            </span>
                          </div>
                          <p class="my-3">Lufo zizrap iwofapsuk pusar luc jodawbac zi op uvezojroj duwage vuhzoc ja
                            vawdud le furhez siva
                            fikavu ineloh. Zot afokoge si mucuve hoikpaf adzuk zileuda falohfek zoije fuka udune lub
                            annajor gazo
                            conis sufur gu.
                          </p>
                          <div class="d-flex align-items-center">
                            <div class="d-flex align-items-center gap-2">
                              <a class="round-32 rounded-circle btn btn-primary p-0 hstack justify-content-center" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Like">
                                <i class="ti ti-thumb-up"></i>
                              </a>
                              <span class="text-dark fw-semibold">55</span>
                            </div>
                            <div class="d-flex align-items-center gap-2 ms-4">
                              <a class="round-32 rounded-circle btn btn-secondary p-0 hstack justify-content-center" href="javascript:void(0)" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Reply">
                                <i class="ti ti-arrow-back-up"></i>
                              </a>
                              <span class="text-dark fw-semibold">0</span>
                            </div>
                          </div>
                        </div>

                          </div>
                        </div>

                        </div>
                      </div>
                    </div>
                  </div>
          </div>
        </div>
</body>
<script>
  const addStoryBtn = document.querySelector('#addStoryBtn');
  addStoryBtn.addEventListener('click', function (){
    alert("아직 준비중입니다 ㅠㅠ");
  })
</script>