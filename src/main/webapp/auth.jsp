<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello Worldddd!" %>
</h1>
<br/>
<main>
    <a href="secured.html">Главная</a>
    <form action="j_security_check" method="POST">
        <label>
            <span>Имя</span>
            <input name="j_username" type="text">
        </label>
        <label>
            <span>Пароль</span>
            <input name="j_password" type="password">
        </label>
        <input type="submit" value="Authorization">
    </form>
</main>
</body>
</html>