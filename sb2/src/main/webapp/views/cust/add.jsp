<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/js/0327.js" />"></script>

<style>
    .btn {
        background-color: green;
        color: white;
        margin-bottom: 20px;
    }
</style>
<script>
    $(function(){
        register.init('<c:url value="/registerimpl"/>');
    });
</script>
<div class="container">
    <h2>회원 등록</h2>
    <form id="register_form">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">

        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">

        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <button type="button" class="btn">REGISTER</button>
    </form>
</div>
