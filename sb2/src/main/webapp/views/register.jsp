<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    $(function () {
        register.init('<c:url value="/registerimpl"/>')
    })
</script>

<div class="container">
    <h2>REGISTER PAGE</h2>
    <form id="register_form" action="<c:url value="/registerimpl"/>" method="post">
        <div class="form-group">
            <label for="name">이름</label>
            <input class="form-control" required id="name" type="text" placeholder="이름을 입력해주세요." name="name" />
        </div>
        <div class="form-group">
            <label for="id">아이디</label>
            <input class="form-control" required id="id" type="text" placeholder="아이디를 입력해주세요." name="id" />
        </div>
        <div class="form-group">
            <label for="pwd">비밀번호</label>
            <input class="form-control" required id="pwd" type="password" placeholder="비밀번호를 입력해주세요." name="pwd" />
        </div>
        <button type="submit" class="btn btn-primary">회원가입 하기</button>
    </form>
</div>
