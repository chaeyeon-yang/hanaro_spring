<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/03
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    label {
        font-size: large;
    }
    .btn {
        background-color: green;
        color: white;
        margin-bottom: 20px;
    }
    #delete {
        background-color: darkred;
    }
</style>

<script>
    $(document).ready(function() {
        $("#delete").click(function() {
            let res = window.confirm("정말 삭제하시겠습니까?");
            if(res) {
                window.location.href ="delete?id=" + ${addr.addrId};
            }
        });
    });
</script>

<div class="container">
    <h2>주소 상세</h2>
    <hr>
    <div>
        <label>주소 아이디 : </label>
        <span>${addr.addrId}</span>
    </div>
    <br />
    <div>
        <label>주소명 : </label>
        <span>${addr.addrName}</span>
    </div>
    <br />
    <div>
        <label>상세주소 : </label>
        <span>${addr.addrDetail}</span>
    </div>
    <br />
    <div>
        <label>회원 아이디 : </label>
        <span>${addr.custId}</span>
    </div>
    <br /><br />
    <button type="button" class="btn">수정하기</button>
    <button type="button" class="btn" id="delete">삭제하기</button>

</div>
