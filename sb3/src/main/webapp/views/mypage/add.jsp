<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/03
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .btn {
        background-color: green;
        color: white;
        margin-bottom: 20px;
    }
</style>
<script>
    $(function(){
        addrRegister.init('<c:url value="/mypage/addimpl"/>');
    });
</script>
<div class="container">
    <form class="addr_register">
        <div class="form-group">
            <label for="addrName">주소명</label>
            <input type="text" class="form-control" id="addrName" name="addrName" aria-describedby="emailHelp">
            <small class="form-text text-muted">주소 이름을 적어주세요.</small>
        </div>
        <div class="form-group">
            <label for="addrDetail">상세주소</label>
            <input type="text" class="form-control" id="addrDetail" name="addrDetail">
            <small class="form-text text-muted">전체 주소를 적어주세요.</small>
        </div>
        <button type="submit" class="btn btn-primary" id="addr_register_btn">등록하기</button>
    </form>
</div>
