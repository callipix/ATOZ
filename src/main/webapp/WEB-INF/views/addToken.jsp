<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<script>
    let cookies = document.cookie;
    alert(cookies);
    $.ajax({
        url: "/secure-endpoint",
        type: "GET",
        xhrFileds: {
            withCredentials: true
        },
        success: function (response, status, xhr) {
            const token = xhr.getResponseHeader("Authorization")
            alert("Authorization = " + token);
            localStorage.setItem("Authorization", token);
            location.href = "/";
        },
        error: function (xhr, status, error) {
            console.log("에러 발생: ", error);
        }
    });
</script>
<body>

</body>
</html>
