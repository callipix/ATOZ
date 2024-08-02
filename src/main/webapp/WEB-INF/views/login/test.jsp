<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" dir="ltr" data-bs-theme="light" data-color-theme="Blue_Theme" data-layout="vertical">

<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- Favicon icon-->
    <link rel="shortcut icon" type="image/png" href="<c:url value='/bootstrap/assets/images/logos/favicon.png'/>"/>

    <!-- Core Css -->
    <link rel="stylesheet" href="<c:url value='/bootstrap/assets/css/styles.css'/>"/>

    <title>Xtream Template by WrapPixel</title>
</head>

<body>
<jsp:include page="../header.jsp" />
<!-- Preloader -->
<div class="preloader">
    <img src="<c:url value='/bootstrap/assets/images/logos/logo-icon.svg'/>"/> alt="loader" class="lds-ripple img-fluid" />
</div>

        <div class="body-wrapper">
            <div class="container-fluid">
                <div class="position-relative mb-4">
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <h4>Blog</h4>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item">
                                        <a class="text-primary text-decoration-none" href="../main/index.html">Home
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
                                    <div class="breadbar"></div>
                                </div>
                                <div>
                                    <small>LAST MONTH</small>
                                    <h4 class="text-primary mb-0">$58,256</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-8">
                        <div class="card blog blog-img-one position-relative overflow-hidden hover-img">
                            <div class="card-body position-relative">
                                <div class="d-flex flex-column justify-content-between h-100">
                                    <div class="d-flex align-items-start justify-content-between">
                                        <div class="position-relative" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Mollie Underwood">
                                            <img src="<c:url value='/bootstrap/assets/images/profile/user-4.jpg'/>"/> alt="xtreme-img" class="rounded-circle img-fluid" width="40" height="40">
                                        </div>
                                        <span class="badge text-bg-primary fs-2 fw-semibold">Gadget</span>
                                    </div>
                                    <div>
                                        <a href="<c:url value='/bootstrap/main/blog-detail.html'/>"></a> class="fs-7 my-4 fw-semibold text-white d-block lh-sm text-primary">Early Black Friday
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
                                            <img src="../assets/images/profile/user-5.jpg" alt="xtreme-img" class="rounded-circle img-fluid" width="40" height="40">
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
                                    <img src="../assets/images/blog/blog-img6.jpg" class="card-img-top" alt="xtreme-img">
                                </a>
                                <span class="badge text-bg-light fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                    min Read</span>
                                <img src="../assets/images/profile/user-3.jpg" alt="xtreme-img" class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Addie Keller">
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
                <nav aria-label="...">
                    <ul class="pagination justify-content-center mb-0 mt-4">
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center" href="javascript:void(0)">
                                <i class="ti ti-chevron-left"></i>
                            </a>
                        </li>
                        <li class="page-item active" aria-current="page">
                            <a class="page-link border-0 rounded-circle round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">4</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">5</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">...</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 mx-1 d-flex align-items-center justify-content-center" href="javascript:void(0)">10</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link border-0 rounded-circle text-dark round-32 d-flex align-items-center justify-content-center" href="javascript:void(0)">
                                <i class="ti ti-chevron-right"></i>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <!----Footer--->
            <footer class="footer text-center py-3">
                All Rights Reserved by Xtreme admin. Designed and Developed by
                <a class="text-primary" href="https://www.wrappixel.com">WrapPixel</a>.
            </footer>
            <!----Footer End--->
        </div>
        <script>
            function handleColorTheme(e) {
                document.documentElement.setAttribute("data-color-theme", e);
            }
        </script>
        <button class="btn btn-primary p-3 rounded-circle d-flex align-items-center justify-content-center customizer-btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
            <i class="icon ti ti-settings fs-7 text-white"></i>
        </button>

        <div class="offcanvas customizer offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
            <div class="d-flex align-items-center justify-content-between p-3 border-bottom">
                <h4 class="offcanvas-title fw-semibold" id="offcanvasExampleLabel">
                    Settings
                </h4>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body h-n80" data-simplebar>
                <h6 class="fw-semibold fs-4 mb-2">Theme</h6>

                <div class="d-flex flex-row gap-3 customizer-box" role="group">
                    <input type="radio" class="btn-check light-layout" name="theme-layout" id="light-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary " for="light-layout"> <iconify-icon icon="solar:sun-2-outline" class="icon fs-7 me-2"></iconify-icon>Light</label>
                    <input type="radio" class="btn-check dark-layout" name="theme-layout" id="dark-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="dark-layout"><iconify-icon icon="solar:moon-outline" class="icon fs-7 me-2"></iconify-icon>Dark</label>
                </div>

                <h6 class="mt-5 fw-semibold fs-4 mb-2">Theme Direction</h6>
                <div class="d-flex flex-row gap-3 customizer-box" role="group">
                    <input type="radio" class="btn-check" name="direction-l" id="ltr-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="ltr-layout"><iconify-icon icon="solar:align-left-linear" class="icon fs-7 me-2"></iconify-icon>LTR</label>

                    <input type="radio" class="btn-check" name="direction-l" id="rtl-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="rtl-layout">
                        <iconify-icon icon="solar:align-right-linear" class="icon fs-7 me-2"></iconify-icon>RTL
                    </label>
                </div>

                <h6 class="mt-5 fw-semibold fs-4 mb-2">Theme Colors</h6>

                <div class="d-flex flex-row flex-wrap gap-3 customizer-box color-pallete" role="group">
                    <input type="radio" class="btn-check" name="color-theme-layout" id="Blue_Theme" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary d-flex align-items-center justify-content-center" onclick="handleColorTheme('Blue_Theme')" for="Blue_Theme" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="BLUE_THEME">
                        <div class="color-box rounded-circle d-flex align-items-center justify-content-center skin-1">
                            <i class="ti ti-check text-white d-flex icon fs-5"></i>
                        </div>
                    </label>

                    <input type="radio" class="btn-check" name="color-theme-layout" id="Aqua_Theme" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary d-flex align-items-center justify-content-center" onclick="handleColorTheme('Aqua_Theme')" for="Aqua_Theme" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="AQUA_THEME">
                        <div class="color-box rounded-circle d-flex align-items-center justify-content-center skin-2">
                            <i class="ti ti-check text-white d-flex icon fs-5"></i>
                        </div>
                    </label>

                    <input type="radio" class="btn-check" name="color-theme-layout" id="Purple_Theme" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary d-flex align-items-center justify-content-center" onclick="handleColorTheme('Purple_Theme')" for="Purple_Theme" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="PURPLE_THEME">
                        <div class="color-box rounded-circle d-flex align-items-center justify-content-center skin-3">
                            <i class="ti ti-check text-white d-flex icon fs-5"></i>
                        </div>
                    </label>

                    <input type="radio" class="btn-check" name="color-theme-layout" id="green-theme-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary d-flex align-items-center justify-content-center" onclick="handleColorTheme('Green_Theme')" for="green-theme-layout" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="GREEN_THEME">
                        <div class="color-box rounded-circle d-flex align-items-center justify-content-center skin-4">
                            <i class="ti ti-check text-white d-flex icon fs-5"></i>
                        </div>
                    </label>

                    <input type="radio" class="btn-check" name="color-theme-layout" id="cyan-theme-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary d-flex align-items-center justify-content-center" onclick="handleColorTheme('Cyan_Theme')" for="cyan-theme-layout" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="CYAN_THEME">
                        <div class="color-box rounded-circle d-flex align-items-center justify-content-center skin-5">
                            <i class="ti ti-check text-white d-flex icon fs-5"></i>
                        </div>
                    </label>

                    <input type="radio" class="btn-check" name="color-theme-layout" id="orange-theme-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary d-flex align-items-center justify-content-center" onclick="handleColorTheme('Orange_Theme')" for="orange-theme-layout" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="ORANGE_THEME">
                        <div class="color-box rounded-circle d-flex align-items-center justify-content-center skin-6">
                            <i class="ti ti-check text-white d-flex icon fs-5"></i>
                        </div>
                    </label>
                </div>

                <h6 class="mt-5 fw-semibold fs-4 mb-2">Layout Type</h6>
                <div class="d-flex flex-row gap-3 customizer-box" role="group">
                    <div>
                        <input type="radio" class="btn-check" name="page-layout" id="vertical-layout" autocomplete="off" />
                        <label class="btn p-9 btn-outline-primary" for="vertical-layout">
                            <iconify-icon icon="solar:slider-vertical-minimalistic-linear" class="icon fs-7 me-2"></iconify-icon>Vertical
                        </label>
                    </div>
                    <div>
                        <input type="radio" class="btn-check" name="page-layout" id="horizontal-layout" autocomplete="off" />
                        <label class="btn p-9 btn-outline-primary" for="horizontal-layout">
                            <iconify-icon icon="solar:slider-minimalistic-horizontal-outline" class="icon fs-7 me-2"></iconify-icon>
                            Horizontal
                        </label>
                    </div>
                </div>

                <h6 class="mt-5 fw-semibold fs-4 mb-2">Container Option</h6>

                <div class="d-flex flex-row gap-3 customizer-box" role="group">
                    <input type="radio" class="btn-check" name="layout" id="boxed-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="boxed-layout">
                        <iconify-icon icon="solar:cardholder-linear" class="icon fs-7 me-2"></iconify-icon>
                        Boxed
                    </label>

                    <input type="radio" class="btn-check" name="layout" id="full-layout" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="full-layout">
                        <iconify-icon icon="solar:scanner-linear" class="icon fs-7 me-2"></iconify-icon> Full
                    </label>
                </div>

                <h6 class="fw-semibold fs-4 mb-2 mt-5">Sidebar Type</h6>
                <div class="d-flex flex-row gap-3 customizer-box" role="group">
                    <a href="javascript:void(0)" class="fullsidebar">
                        <input type="radio" class="btn-check" name="sidebar-type" id="full-sidebar" autocomplete="off" />
                        <label class="btn p-9 btn-outline-primary" for="full-sidebar"><iconify-icon icon="solar:sidebar-minimalistic-outline" class="icon fs-7 me-2"></iconify-icon> Full</label>
                    </a>
                    <div>
                        <input type="radio" class="btn-check " name="sidebar-type" id="mini-sidebar" autocomplete="off" />
                        <label class="btn p-9 btn-outline-primary" for="mini-sidebar">
                            <iconify-icon icon="solar:siderbar-outline" class="icon fs-7 me-2"></iconify-icon>Collapse
                        </label>
                    </div>
                </div>

                <h6 class="mt-5 fw-semibold fs-4 mb-2">Card With</h6>

                <div class="d-flex flex-row gap-3 customizer-box" role="group">
                    <input type="radio" class="btn-check" name="card-layout" id="card-with-border" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="card-with-border"><iconify-icon icon="solar:library-broken" class="icon fs-7 me-2"></iconify-icon>Border</label>

                    <input type="radio" class="btn-check" name="card-layout" id="card-without-border" autocomplete="off" />
                    <label class="btn p-9 btn-outline-primary" for="card-without-border">
                        <iconify-icon icon="solar:box-outline" class="icon fs-7 me-2"></iconify-icon>Shadow
                    </label>
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
<script src="../assets/js/vendor.min.js"></script>
<!-- Import Js Files -->
<script src="<c:url value='/bootstrap/assets/js/breadcrumb/breadcrumbChart.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/libs/apexcharts/dist/apexcharts.min.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/js/vendor.min.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/libs/simplebar/dist/simplebar.min.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/js/theme/app.init.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/js/theme/theme.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/js/theme/app.min.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/js/theme/sidebarmenu.js'/>"/></script>
<script src="<c:url value='/bootstrap/assets/js/theme/feather.min.js'/>"/></script>

<!-- solar icons -->
<script src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
</body>

</html>