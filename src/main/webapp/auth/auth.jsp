<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authentication</title>
    <link href="./auth.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Play:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<br/>
<main class="main">
    <div class="main_header">
        <h1 class="main-title">Пожалуйста, авторизируйтесь !</h1>
    </div>
    <form action="j_security_check" method="POST" class="auth_form">
        <label class="auth_name">
            <span>Имя</span>
            <input name="j_username" type="text">
        </label>
        <label>
            <span>Пароль</span>
            <input name="j_password" type="password">
        </label>
        <input type="submit" value="Authorization" class="auth_submit-btn">
    </form>
</main>
</body>
</html>