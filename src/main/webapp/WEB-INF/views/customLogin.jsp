<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>customLogin page</h1>
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2>

<form method="post" action="/login">
    <div>
        <input type="text" name="username" value="admin">
    </div>
    <div>
        <input type="password" name="password" value="admin">
    </div>
    <div>
        <input type="checkbox" name="remember-me"> Remember Me
    </div>
    <div>
        <input type="submit" value="로그인">
    </div>
    <sec:csrfInput/>
    <fieldset>
        <label>로그인</label> <br>
        <div id="googleLoginBtn" style="cursor: pointer">
            <img id="googleLoginImg" src="./images/btn_google_signin_light_pressed_web.png">
        </div>
    </fieldset>
</form>
</body>
<script>
    const onClickGoogleLogin = (e) => {
        //구글 인증 서버로 인증코드 발급 요청
        window.location.replace("https://accounts.google.com/o/oauth2/v2/auth?"
        +"client_id=406164117494-h3u2e82ej7vsqgq259nj62o8m98r9gue.apps.googleusercontent.com"
       +"&redirect_uri=http://localhost:8080/login/google/auth"
    +"&response_type=code"
        +"&scope=email%20profile%20openid"
        +"&access_type=offline")
    }

    const googleLoginBtn = document.getElementById("googleLoginBtn");
    googleLoginBtn.addEventListener("click", onClickGoogleLogin);

</script>
</html>
