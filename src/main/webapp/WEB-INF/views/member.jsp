<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<head>
    <title>member</title>
</head>
<body>
<form action="/signup" method="post">
    <sec:csrfInput/>
    <div>
        <input type="text" name="username">ID
    </div>
    <div>
        <input type="password" name="password">PASSWORD
    </div>
    <div>
        <input type="text" name="name">NAME
    </div>
    <div>
        <input type="radio" id="member" name="auth" value="ROLE_MEMBER">
        <label for="member">MEMBER</label>
    </div>
    <div>
        <input type="radio" id="admin" name="auth" value="ROLE_ADMIN">
        <label for="admin">ADMIN</label>
    </div>
    <div>
        <input type="submit" value="회원가입">
    </div>
</form>
</body>
</html>
