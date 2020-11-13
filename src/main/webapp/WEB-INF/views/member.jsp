<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>member</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <sec:csrfMetaTags/>
</head>
<body>
<form action="/signup" method="post">
    <sec:csrfInput/>
    <div class="form-group">
        아이디<input type="text" name="username" id="user-id" placeholder="ID" required>
        <div class="check-font" id="check"></div>
        <button id="id-check" type="button" onclick="idCheck()">중복체크</button>
    </div>
    <div>
        비밀번호<input type="password" name="password">
    </div>
    <div>
        이름<input type="text" name="name">
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
        <input type="radio" id="client" name="auth" value="ROLE_CLIENT">
        <label for="client">CLIENT</label>
    </div>
    <div>
        <input type="radio" id="partners" name="auth" value="ROLE_PARTNERS">
        <label for="partners">PARTNERS</label>
    </div>
    <div>
        <input type="submit" value="회원가입">
    </div>
</form>
<script>

    function idCheck(){
        var id = $('#user-id').val();

        $.ajax({
            url : '/member/idCheck?username='+id,
            type : 'get',
            success : function (data){
                console.log(data);

                if (data == 1){
                    $("#check").text("사용중인 아이디입니다 :p");
                }else if (data == 0){
                    $("#check").text("사용가능한 아이디입니다 :p");
                }else {
                    alert("error");
                }
            }
        })
    }

</script>
</body>
</html>
