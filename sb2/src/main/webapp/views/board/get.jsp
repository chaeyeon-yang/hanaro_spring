<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    p{
        color:red;
    }
</style>


<div class="container">
    <h2>게시글 목록</h2>
    <br />
    <table class="table table-striped" id="board_table">
        <thead>
        <tr>
            <th>게시글</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList}" var="b">
            <tr>
                <td><a href="<c:url value="/board/detail"/>?id=${b.boardId}">${b.boardId}</a></td>
                <td>${b.custId}</td>
                <td>${b.boardTitle}</td>
                <td>${b.boardUpdate}</td>
                <td>${b.boardCnt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
