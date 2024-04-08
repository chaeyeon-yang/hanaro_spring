<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/08
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .btn {
        margin-top: 20px;
        margin-right: 10px;
        background-color: green;
        color: white;
        margin-bottom: 20px;
    }

    #delete_btn {
        background-color: darkred;
    }
</style>
<script>
    let boardUpdate = {
        init:function(){
            $('#board_update_form > #update_btn').click(() => {
                let c = confirm('수정하시겠습니까?');
                if(c == true){
                    let title = $('#title').val();
                    let content = $('#content').val();
                    if(title == '' || title == null){
                        alert('제목을 입력 하세요');
                        $('#title').focus();
                        return;
                    }
                    if(content == '' || content == null){
                        alert('내용을 입력 하세요');
                        $('#content').focus();
                        return;
                    }
                }
                boardUpdate.send();
            });
            $('#board_update_form > #delete_btn').click(() => {
                let c = confirm('삭제하시겠습니까?');
                if(c == true){
                    let id = $('input[name="boardId"]').val();
                    location.href = '<c:url value="/board/delete"/>?id='+id;
                }
            });

        },
        send:function(){
            $('#board_update_form').attr({
                'method':'post',
                'action':'<c:url value="/board/update"/>'
            });
            $('#board_update_form').submit();
        }
    };
    $(function () {
        boardUpdate.init();
    })
</script>

<div class="container detail">
    <form id="board_update_form">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요." name="title" value="${board.boardTitle}">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea rows="8" class="form-control" id="content" placeholder="내용을 입력하세요." name="content">${board.boardContent}</textarea>
        </div>
        <div class="form-group">
            <label for="custId">글쓴이</label>
            <input readonly="readonly" type="text" class="form-control" id="custId"  name="title" value="${board.custId}">
        </div>
        <input type="hidden" class="form-control" name="boardId" value="${board.boardId}">

        <c:if test="${sessionScope.id == board.custId}">
            <button type="button" class="btn" id="update_btn">수정하기</button>
            <button type="button" class="btn" id="delete_btn">삭제하기</button>
        </c:if>
    </form>
</div>
