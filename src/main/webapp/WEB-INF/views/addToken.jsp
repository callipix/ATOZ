<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        error: function (xhr) {
            // if (xhr.status === 401) {
            //     $.ajax({
            //         url: "/reissue",
            //         type: "post",
            //         xhrFields: {
            //             withCredentials: true
            //         },
            //         success: function (response) {
            //             alert(response)
            //         },
            //         error: function (xhr, status, error) {
            //             console.log("에러 발생 for header-endpoint xhr: ", xhr);
            //             console.log("에러 발생 for header-endpoint status: ", status);
            //             console.log("에러 발생 for header-endpoint error: ", error);
            //         },
            //     })
            // }
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
            error: function (xhr) {

            }
        })
    }
</script>
<body>
</body>
</html>