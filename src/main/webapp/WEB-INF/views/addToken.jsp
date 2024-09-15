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

    $.ajax({
        url: "/secure-endpoint",
        type: "GET",
        xhrFields: {
            withCredentials: true
        },
        success: function (response, status, xhr) {
            const access = xhr.getResponseHeader("access")

            localStorage.setItem("access", access);
            addHeader();
            // location.href = '/';
        },
        error: function (xhr, status, error) {
            console.log("에러 발생1: ", error);
        }
    });

    function addHeader() {
        let data = localStorage.getItem("access");

        $.ajax({
            url: "/header-endpoint",
            type: "GET",
            xhrFields: {
                withCredentials: true
            },
            headers: {
                'access': data,
                'Content-Type': 'application/json'
            },
            success: function (response) {

                location.href = "/";
            },
            error: function (xhr, status, error) {
                console.log("에러 발생2: ", error);
            }
        })

    }

</script>
<body>

</body>
</html>