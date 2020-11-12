<%--
  Created by IntelliJ IDEA.
  User: jiwonpark
  Date: 2020/11/08
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>cutomLogout page</h1>
<form action="/customLogout" method="post">
    <sec:csrfInput/>
    <button>로그아웃</button>
</form>
</body>
</html>
