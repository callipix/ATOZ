<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        window.onload = function () {
            const message = '<%= session.getAttribute("message") %>';
            if (message) {
                alert(message);
                <% session.removeAttribute("message"); %> // 메시지 제거
            }
            location.href = "/";
        }
    </script>
</head>
<body>
</body>
</html>
