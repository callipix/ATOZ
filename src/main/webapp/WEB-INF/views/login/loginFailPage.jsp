<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script>
        window.onload = function() {
            const message = '<%= session.getAttribute("message") %>';
            console.log("message = " + message);
            if (message) {
                alert(message);
                <% session.invalidate(); %>
            }
            location.href="loginForm";
        }
    </script>
</head>
<body>
</body>
</html>
