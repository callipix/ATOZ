<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<script>
    $.ajax({
        url: "/secureEndpoint",
        type: "GET",
        xhrFields: {
            withCredentials: true
        },
        success: function (response, status, xhr) {
            let access = xhr.getResponseHeader("access")
            localStorage.setItem("access", access);
            addHeader();
        },
        error: function (xhr) {
        }
    });

    function addHeader() {
        let access = localStorage.getItem("access");

        $.ajax({
            url: "/headerEndpoint",
            type: "GET",
            xhrFields: {
                withCredentials: true
            },
            headers: {
                'access': access,
                'Content-Type': 'application/json'
            },
            success: function () {
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