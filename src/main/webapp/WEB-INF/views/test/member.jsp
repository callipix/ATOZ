<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<style>
    #addInfo {
        display: none;
    }
    #btnList {
        text-align: center;
    }
</style>
<body>
<a href="/myApp/mymember/memberList" id="memberList">회원 목록 보기</a>

<br>
<table border="1">
    <thead>
    <tr>
        <td colspan="5" style="text-align: right">
            <button type="button" id="addMember">
                회원추가
            </button>
        </td>
    </tr>
    <tr>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>전화</td>
        <td>주소</td>
    </tr>
    </thead>
    <tbody id="test">
    <tr>
    </tr>
    </tbody>
</table>
<br>

<form id="addInfo" method="post" action="/myApp/mymember/addMember">
    <table border="1">
        <tr>
            <td>회원ID</td>
            <td>
                <input type="text" id="MEM_ID" name="MEM_ID">
                <button type="button" id="idChk">중복확인</button>
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="MEM_PASS"></td>
        </tr>
        <tr>
            <td>비밀번호확인</td>
            <td>
                <input type="password">
            </td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="MEM_TEL"></td>
        </tr>
        <tr>
            <td>회원이름</td>
            <td><input type="text" name="MEM_NAME"></td>
        </tr>
        <tr>
            <td>회원주소</td>
            <td><input type="text" name="MEM_ADDR"></td>
        </tr>
        <tr>
            <td>프로필사진</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td colspan="2" id="btnList" name="btnList">
                <button type="submit" id="save" name="save">저장</button>
                <button type="button">취소</button>
                <button type="button">회원목록</button>
            </td>
        </tr>
    </table>
</form>
<table border="1" id="detail">

</table>

<script>
    const memberList = document.querySelector('#memberList');
    const test = document.querySelector('#test');
    const idChk = document.querySelector('#idChk')
    const inputId = document.querySelector('#MEM_ID');
    const addMemberBtn = document.querySelector('#addMember');
    const addInfo = document.querySelector('#addInfo');
    const save = document.querySelector('#save');
    const detail = document.querySelector('#detail');

    memberList.addEventListener('click',function(e) {
        e.preventDefault();
        // alert("회원 목록 보기 버튼 클릭");
        // $.ajax({
        //     url : '/myApp/mymember/memberList',
        //     type : 'get',
        //     success : function(result){
        //         test.innerHTML = toHTML(result);
        //     }
        // })
        fetch('/myApp/mymember/memberList', {
            method: 'GET'
        })
            .then(response => {
                return response.json();
            })
            .then(result => {
                test.innerHTML = toHTML(result);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    })
    let toHTML = function(result){
        let str = ``;
        result.forEach(function(testMember){
            str += `<tr>`;
            str += `<td><a href='#' class="btnId" data-id=\${testMember.mem_ID} >\${testMember.mem_ID}</td>`;
            str += `<td>\${testMember.mem_PASS}</td>`;
            str += `<td>\${testMember.mem_NAME}</td>`;
            str += `<td>\${testMember.mem_TEL}</td>`;
            str += `<td>\${testMember.mem_ADDR}</td>`;
            str += `</tr>`;
        })
        return str;
    }
    idChk.addEventListener('click' , function(){
        let id = inputId.value;
        fetch('/myApp/mymember/idCheck?id=' + encodeURIComponent(id), {
            method: 'GET'
        })
            .then(response => response.text())  // 서버 응답을 텍스트로 읽기
            .then(result => {
                if (result === '1') {
                    alert('중복된 아이디가 있습니다.');
                    return;
                }
                alert("사용가능합니다.");
            })
            .catch(error => {
                console.error('Error:', error);
            });
    })
    addInfo.addEventListener('submit' , function(e){
        e.preventDefault();
        let formData = new FormData(this);
        $.ajax({
            url : '/myApp/mymember/addMember',
            method : 'post',
            data : formData,
            contentType: false,  //
            processData: false,  //
            success : function(result){
                alert(result);
                let str = ``;
                str += `<tr>`;
                str += `<td><a href='#' class="btnId" data-id=\${result.mem_ID} >\${result.mem_ID}</td>`;
                str += `<td>\${result.mem_PASS}</td>`;
                str += `<td>\${result.mem_NAME}</td>`;
                str += `<td>\${result.mem_TEL}</td>`;
                str += `<td>\${result.mem_ADDR}</td>`;
                str += `</tr>`;
                test.innerHTML += str;
            }
        })
    })
    addMemberBtn.addEventListener('click' , function (){
        addInfo.style.display = 'block';
    });
    document.addEventListener('click', function(e){
        let target = e.target;
        if(target && target.matches('.btnId')){
            addInfo.style.display = 'none';
            let memID = target.getAttribute("data-id");
            let str = ``;
            $.ajax({
                url : '/myApp/mymember/memDetail',
                type : 'post',
                data : {"memID" : memID},
                success : function (result) {
                    str +=  `<tr><td colSpan="2"></td></tr>`;
                    str +=  `<tr><td>회원ID</td><td>\${result.mem_ID}</td></tr>`;
                    str +=  `<tr><td>비밀번호</td><td>\${result.mem_PASS}</td></tr>`;
                    str +=  `<tr><td>회원이름</td><td>\${result.mem_NAME}</td></tr>`;
                    str +=  `<tr><td>전화번호</td><td>\${result.mem_TEL}</td></tr>`;
                    str +=  `<tr><td>회원주소</td><td>\${result.mem_ADDR}</td></tr>`;
                    str +=  `<tr><td colSpan="2"><button>수정</button><button>삭제</button><button>회원목록</button</td></tr>`;
                    detail.innerHTML = str;
                }
            })
        }
    })
</script>
</body>
</html>
