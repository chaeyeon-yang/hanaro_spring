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
        boardRegister.init();
    });
</script>
<div class="container">
    <h2>게시글 작성</h2>
    <form id="board_register_form">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요." name="title">

        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea rows="8" class="form-control" id="content" placeholder="내용을 입력하세요." name="content"></textarea>
        </div>

        <button type="button" class="btn">게시하기</button>
    </form>
</div>
