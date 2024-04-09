<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-27
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    let center = {
        init: function () {
            $.ajax({
                url: '<c:url value="/wh"/>',
                success: (result) => {
                    let text = result.response.body.items.item[0].wfSv;
                    $('#wh').text(text)
                }
            })
        }
    }
    $(function () {
        center.init()
    })
</script>

<div class="container">
    <h2>인기 게시물</h2>
    <h5>Title description, Sep 2, 2017</h5>
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
        <c:forEach items="${ranks}" var="b">
            <tr>
                <td><a href="<c:url value="/board/detail"/>?id=${b.boardId}">${b.boardId}</a></td>
                <td>${b.custId}</td>
                <td>${b.boardTitle}</td>
                <td><fmt:parseDate value="${b.boardUpdate}"
                                   pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="yyyy년 MM월 dd일 HH시 mm분" value="${ parsedDateTime }" /></td>
                <td>${b.boardCnt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <p>Weather..</p>
    <p id="wh"></p>
</div>
