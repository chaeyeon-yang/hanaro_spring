<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/09
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let allpage = {
        init: function () {
        }
    };
    $(function () {
        allpage.init();
    });
</script>

<div class="container">
    <h2>게시글 페이지네이션</h2>
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
        <c:forEach items="${cpage.getList()}" var="b">
            <tr>
                <td><a href="<c:url value="/board/detail"/>?id=${b.boardId}">${b.boardId}</a></td>
                <td>${b.custId}</td>
                <td>${b.boardTitle}
                    <c:if test="${b.commentCnt != 0}">
                        <span>[${b.commentCnt}]</span>
                    </c:if>
                </td>
                <td><fmt:parseDate value="${b.boardUpdate}"
                                   pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="yyyy년 MM월 dd일 HH시 mm분" value="${ parsedDateTime }" /></td>
                <td>${b.boardCnt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="../page.jsp" />
</div>
