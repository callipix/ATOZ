<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<link rel="stylesheet" href="<c:url value='/css/updateList.css'/>"/>

<!-- 마우스 커서 캐릭터 코드 시작-->
<style type="text/css">* {cursor: url(https://cur.cursors-4u.net/nature/nat-4/nat354.ani),
url(https://cur.cursors-4u.net/nature/nat-4/nat354.png),
auto !important;}</style>
<a href="https://www.cursors-4u.com/cursor/2009/01/30/cute-running-puppy.html" target="_blank" title="Cute Running Puppy"><img src="https://cur.cursors-4u.net/cursor.png" border="0" alt="Cute Running Puppy" style="position:absolute; top: 0px; right: 0px;" /></a>
<!-- 마우스 커서 캐릭터 코드 끝-->

<!-- 마우스 커서 이펙트 코드 시작-->
<script type="text/javascript">
    // <![CDATA[
    var colours=new Array("#a6f", "#60f", "#60f", "#a6f", "#ccc"); // colours for top, right, bottom and left borders and background of bubbles
    var bubbles=66; // maximum number of bubbles on screen
    var over_or_under="over"; // set to "over" for bubbles to always be on top, or "under" to allow them to float behind other objects

    /****************************
     * JavaScript Bubble Cursor  *
     *(c)2010-13 mf2fm web-design*
     *  http://www.mf2fm.com/rv  *
     * DON'T EDIT BELOW THIS BOX *
     ****************************/
    var x=ox=400;
    var y=oy=300;
    var swide=800;
    var shigh=600;
    var sleft=sdown=0;
    var bubb=new Array();
    var bubbx=new Array();
    var bubby=new Array();
    var bubbs=new Array();
    var sploosh=false;

    function addLoadEvent(funky) {
        var oldonload=window.onload;
        if (typeof(oldonload)!='function') window.onload=funky;
        else window.onload=function() {
            if (oldonload) oldonload();
            funky();
        }
    }

    addLoadEvent(buble);

    function buble() { if (document.getElementById) {
        var i, rats, div;
        for (i=0; i<bubbles; i++) {
            rats=createDiv("3px", "3px");
            rats.style.visibility="hidden";
            rats.style.zIndex=(over_or_under=="over")?"1001":"0";

            div=createDiv("auto", "auto");
            rats.appendChild(div);
            div=div.style;
            div.top="1px";
            div.left="0px";
            div.bottom="1px";
            div.right="0px";
            div.borderLeft="1px solid "+colours[3];
            div.borderRight="1px solid "+colours[1];

            div=createDiv("auto", "auto");
            rats.appendChild(div);
            div=div.style;
            div.top="0px";
            div.left="1px";
            div.right="1px";
            div.bottom="0px"
            div.borderTop="1px solid "+colours[0];
            div.borderBottom="1px solid "+colours[2];

            div=createDiv("auto", "auto");
            rats.appendChild(div);
            div=div.style;
            div.left="1px";
            div.right="1px";
            div.bottom="1px";
            div.top="1px";
            div.backgroundColor=colours[4];
            if (navigator.appName=="Microsoft Internet Explorer") div.filter="alpha(opacity=50)";
            else div.opacity=0.5;
            document.body.appendChild(rats);
            bubb[i]=rats.style;
        }
        set_scroll();
        set_width();
        bubble();
    }}

    function bubble() {
        var c;
        if (Math.abs(x-ox)>1 || Math.abs(y-oy)>1) {
            ox=x;
            oy=y;
            for (c=0; c<bubbles; c++) if (!bubby[c]) {
                bubb[c].left=(bubbx[c]=x)+"px";
                bubb[c].top=(bubby[c]=y-3)+"px";
                bubb[c].width="3px";
                bubb[c].height="3px"
                bubb[c].visibility="visible";
                bubbs[c]=3;
                break;
            }
        }
        for (c=0; c<bubbles; c++) if (bubby[c]) update_bubb(c);
        setTimeout("bubble()", 20);
    }

    document.onmousedown=splash;
    document.onmouseup=function(){clearTimeout(sploosh);};

    function splash() {
        ox=-1;
        oy=-1;
        sploosh=setTimeout('splash()', 100);
    }

    function update_bubb(i) {
        if (bubby[i]) {
            bubby[i]-=bubbs[i]/2+i%2;
            bubbx[i]+=(i%5-2)/5;
            if (bubby[i]>sdown && bubbx[i]>sleft && bubbx[i]<sleft+swide+bubbs[i]) {
                if (Math.random()<bubbs[i]/shigh*2 && bubbs[i]++<8) {
                    bubb[i].width=bubbs[i]+"px";
                    bubb[i].height=bubbs[i]+"px";
                }
                bubb[i].top=bubby[i]+"px";
                bubb[i].left=bubbx[i]+"px";
            }
            else {
                bubb[i].visibility="hidden";
                bubby[i]=0;
                return;
            }
        }
    }

    document.onmousemove=mouse;
    function mouse(e) {
        if (e) {
            y=e.pageY;
            x=e.pageX;
        }
        else {
            set_scroll();
            y=event.y+sdown;
            x=event.x+sleft;
        }
    }

    window.onresize=set_width;
    function set_width() {
        var sw_min=999999;
        var sh_min=999999;
        if (document.documentElement && document.documentElement.clientWidth) {
            if (document.documentElement.clientWidth>0) sw_min=document.documentElement.clientWidth;
            if (document.documentElement.clientHeight>0) sh_min=document.documentElement.clientHeight;
        }
        if (typeof(self.innerWidth)=='number' && self.innerWidth) {
            if (self.innerWidth>0 && self.innerWidth<sw_min) sw_min=self.innerWidth;
            if (self.innerHeight>0 && self.innerHeight<sh_min) sh_min=self.innerHeight;
        }
        if (document.body.clientWidth) {
            if (document.body.clientWidth>0 && document.body.clientWidth<sw_min) sw_min=document.body.clientWidth;
            if (document.body.clientHeight>0 && document.body.clientHeight<sh_min) sh_min=document.body.clientHeight;
        }
        if (sw_min==999999 || sh_min==999999) {
            sw_min=800;
            sh_min=600;
        }
        swide=sw_min;
        shigh=sh_min;
    }

    window.onscroll=set_scroll;
    function set_scroll() {
        if (typeof(self.pageYOffset)=='number') {
            sdown=self.pageYOffset;
            sleft=self.pageXOffset;
        }
        else if (document.body && (document.body.scrollTop || document.body.scrollLeft)) {
            sdown=document.body.scrollTop;
            sleft=document.body.scrollLeft;
        }
        else if (document.documentElement && (document.documentElement.scrollTop || document.documentElement.scrollLeft)) {
            sleft=document.documentElement.scrollLeft;
            sdown=document.documentElement.scrollTop;
        }
        else {
            sdown=0;
            sleft=0;
        }
    }

    function createDiv(height, width) {
        var div=document.createElement("div");
        div.style.position="absolute";
        div.style.height=height;
        div.style.width=width;
        div.style.overflow="hidden";
        div.style.backgroundColor="transparent";
        return (div);
    }
    // ]]>
</script>
<!-- 마우스 커서 이펙트 코드 끝-->
<style>
    .mainHeader {
        margin: 20px 100px 0px 100px;
        display: flex;
        align-items: center;
    }
    .bottomHeader {
        margin: 20px 100px 0px 100px;
    }
    #reverseOrder,#openAll, .headerText {
        margin-left: 20px;
        border-radius: 10px;
        font-weight: bold;
    }
</style>
<body>
<div class="mainHeader">
    <div>
        <h1>업데이트 내역</h1>
    </div>

    <div class="uplistBtn">
        <button id="reverseOrder"><b>역순보기</b></button>
        <button id="openAll"><b>한번에 열기</b></button>
    </div>

    <div class="headerText" style="display: flex"><h5 style="text-decoration: line-through">역순정렬 일부 오류..</h5><h5>&nbsp;&nbsp;→ 해결? 다른 오류 발생</h5></div>
</div>
</div>
<div class="updateList">

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.17</b></button>
        <div class="panel">
            <h5>전체 프로젝트 설정 후 생성</h5>
            <h5>pom 파일 라이브러리 추가</h5>
            <h5>회원가입기능 쿼리문 뽑아보기</h5>
            <h5>회원가입기능 백단 메서드 작성</h5>
            <h5>회원가입기능 메서드 테스트코드 작성 - Junit4</h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.18</b></button>
        <div class="panel">
            <h5>가입시 문자인증(coolSMS) 추가 - 테스트 성공</h5>
            <h5>api-key, api-secret을 properties 파일로 별도분리하여 읽어오도록 설정</h5>
            <h5>MySQL 스프링 연동</h5>
            <h5>가입기능 테스트</h5>
            <h5>트랜잭션 설정 후 간단한 데이터 추가 작동 테스트 - 확인 완료</h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.19</b></button>
        <div class="panel">
            <h5>로그인폼, 회원가입폼 UI 작성, 회원가입 프론트 코드 작성</h5>
            <h5>로그인, 회원가입 페이지 뷰 컨트롤러 페이지 이동 확인</h5>
            <h5>현재까지 프로젝트 내역 AWS에 올려서 간단 테스트, 동작 확인</h5>
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
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.21</b></button>
        <div class="panel">
            <h5>로그인 기능 일부 수정 및 게시판 추가</h5>
            <h5>게시판 기본 CRUD 쿼리문 작성</h5>
            <h5>게시판 Mapper 파일 작성</h5>
            <h5>게시판 리스트 불러오기 테스트코드 작성</h5>
            <h5>게시판 페이징 쿼리문 boardMapper에 추가</h5>
            <h5>게시판 리스트 페이징 테스트</h5>
            <h5>인텔리제이 깃 연동중에 실수로 날려먹어서 재작성</h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.22</b></button>
        <div class="panel">
            <h5>게시판 글쓰기, 게시글 조회 기능 추가</h5>
            <h5>검색기능 추가</h5>
            <h5>게시판 페이징 & 검색 일부 오류 확인 → 쿼리 변경</h5>
            <h5>게시판 페이징 & 검색기능 수정 - 작동 확인</h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.23</b></button>
        <div class="panel">
            <h5>게시글 수정/삭제기능 추가 → 인증 로직 고도화 예정</h5>
            <h5>게시글 UI 일부 수정</h5>
            <h5>AWS에 올려서 일부 기능 동작 테스트 → Context Path 경로 설정 오류 확인</h5>
            <h5>로컬에선 이상없이 작동했는데.. Context Path 경로 오류잡느라 하루종일 날렸다</h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.24</b></button>
        <div class="panel">
            <h5>댓글 DB 테이블 설계</h5>
            <h5>댓글 쿼리문 mapper 작성</h5>
            <h5>댓글 백단 로직 설계 - Rest API 이용</h5>
            <h5>댓글 백단 테스트코드 작성 후 테스트 -> Postman으로 이상없이 작동 모두 확인, 트랜잭션까지 테스트 완료</h5>
            <h5>댓글 프론트단 UI 설계</h5>
            <h5>댓글 프론트-백 연동 테스트 → 답글기능 일부 오류발생, 댓글만 등록, 삭제완료 </h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.25</b></button>
        <div class="panel">
            <h5>댓글 프론트 - 백 연동 → 수정기능 진행중, 답글(대댓글) 우선 보류</h5>
            <h5>파일업로드 & 에디터 추가(ckeditor5) -> 에디터만 추가 완료(07.25)</h5>
            <h5>에디터 추가하는데 경로설정 오류로 하루종일 날려먹었다..</h5>
            <h5>에디터 추가 후 게시판 조회 수정 쓰기 삭제 모두 문제발생해서 싹다 새로 잡는중..</h5>
            <h5>파일업로드 DB 테이블 설계</h5>
        </div>
    </div>

    <div class="accordion-main">
        <button class="accordion"><b>2024.07.26</b></button>
        <div class="panel">
            <h5>에디터 추가 하면서 게시판 기능 에러로 조회 수정 쓰기 삭제 새로 작성중...</h5>
            <h5>게시판 조회 수정 쓰기 삭제 일부 해결</h5>
            <h5>게시판 기능 정상작동 하면 이후 파일업로드 추가 예정</h5>
        </div>
    </div>
    <div class="accordion-main">
        <button class="accordion"><b>2024.07.27</b></button>
        <div class="panel">
            <h5>AWS S3 스프링 연동 실행문제로 6시간 날렸다.. 해결은 했는데..</h5>
        </div>
    </div>
    <div class="accordion-main">
        <button class="accordion"><b>2024.07.28</b></button>
        <div class="panel">
            <h5>ckEditor 플러그인 오류로 4시간 내내 이것만 붙잡았는데.. 해결 실패 별별짓을 다했는데..</h5>
        </div>
    </div>
    <div class="accordion-main">
        <button class="accordion"><b>2024.07.29</b></button>
        <div class="panel">
            <h5>게시판 글 작성 : 이미지 삭제시 S3 파일삭제 , DB 파일정보 삭제 구현</h5>
            <h5>게시판 일부 css 수정</h5>
            <h5>에러코드 게시판 DB 테이블 추가, 앞으로 여기에 에러기록 예정</h5>
            <h5>게시판, 회원가입 고도화 작업 예정 -> 프론트-백 유효성 검증 로직 추가 예정</h5>
            <h5></h5>
        </div>
    </div>
</div>
<div class="bottomHeader">
    <h1>업데이트 예정</h1>
    <h4>검색기능 → 2024.07.22 완료</h4>
    <h4>게시글 수정/삭제기능 추가하기 → 2024.07.23 완료, 인증 로직 고도화 예정</h4>
    <h4>파일 첨부 - 이미지</h4>
    <h4>게시판 글쓰기 기능 에디터 추가하기(스마트에디터 or ckeditor5)</h4>
    <h4>날짜별 작업 내용마다 깃 링크 연동하기</h4>
    <h4>댓글기능 추가 → 고도화 예정</h4>
    <h4>관리자 페이지 - 접속모니터링(선택)</h4>
    <h4>스프링 시큐리티 적용해서 인증&권한설정 수정 및 보안강화</h4>
    <h4>아이디 비밀번호 찾기 추가</h4>
    <h4>소셜 로그인(선택)</h4>
    <h4>좋아요 기능 추가</h4>
    <h4 style="text-decoration: line-through;">무한 대댓글</h4>
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