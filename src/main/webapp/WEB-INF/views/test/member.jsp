<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<a href="#" id="memberList">회원 목록 보기</a>

<br>
<table border="1">
    <thead>
    <tr>
        <td colspan="5" style="text-align: right">
            <button>
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

    </tbody>
</table>
<br>

<form>
    <table border="1">
        <tr>
            <td>회원ID</td>
            <td>
                <input type="text" id="inputId" name="inputId">
                <button type="button" id="idChk">중복확인</button>
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password"></td>
        </tr>
        <tr>
            <td>비밀번호확인</td>
            <td>
                <input type="password">
            </td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>회원이름</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>회원주소</td>
            <td><input type="text"></td>
        </tr>
        <tr>
            <td>프로필사진</td>
            <td><input type="text"></td>
        </tr>
    </table>
</form>

<script>
    const memberList = document.querySelector('#memberList');
    const test = document.querySelector('#test');
    const idChk = document.querySelector('#idChk')
    const inputId = document.querySelector('#inputId');
    memberList.addEventListener('click',function(e){
        e.preventDefault();
        // alert("회원 목록 보기 버튼 클릭");

        $.ajax({
            url : '/myApp/mymember/memberList',
            type : 'get',
            success : function(result){
                let str = '';
                result.forEach(function (testMember){
                    console.log(testMember);
                    str += `<tr>`;
                    str += `<td><a href='\${testMember.mem_ID}'>\${testMember.mem_ID}</td>`;
                    str += `<td>\${testMember.mem_PASS}</td>`;
                    str += `<td>\${testMember.mem_NAME}</td>`;
                    str += `<td>\${testMember.mem_TEL}</td>`;
                    str += `<td>\${testMember.mem_ADDR}</td>`;
                    str += `</tr>`;
                })
                console.log(str);
                test.innerHTML = str;
            }
        })
    })

    idChk.addEventListener('click' , function(){
        let id = inputId.value;
        alert("아이디 중복확인 클릭 " + id);
        $.ajax({
            url : '/myApp/idChk',
            method : 'get',
            data : id,
            success : function(result){
                if(result ==='1'){
                    alert('중복된 아이디가 있습니다.');
                }
            }
        })
    })

</script>
</body>
</html>
