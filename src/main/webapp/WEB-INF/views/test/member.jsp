<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<a href="#" id="memberList">회원 목록 보기</a>
<script>
    const memberList = document.querySelector('#memberList');
    const test = document.querySelector('#test');
    memberList.addEventListener('click',function(e){
        e.preventDefault();
        // alert("회원 목록 보기 버튼 클릭");

        let str = '';
        $.ajax({
            url : '/myApp/mymember/memberList',
            type : 'get',
            success : function(result){
                alert(result);
                result.forEach(function (testMember){
                    str += `<td>testMember.mem_id</td>`;
                    str += `<td>testMember.mem_pass</td>`;
                    str += `<td>testMember.mem_name</td>`;
                    str += `<td>testMember.mem_tel</td>`;
                    str += `<td>testMember.mem_addr</td>`;
                })
                test.innerHTML(str);
            }
        })

    })
</script>
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
    <tr id="test">
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>전화</td>
        <td>주소</td>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
</body>
</html>
