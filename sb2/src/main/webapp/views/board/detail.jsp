<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/08
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let detail = {
        init: function () {
        }
    };
    $(function () {
        detail.init();
    });
</script>

<div class="container">
    <h3>${board.boardTitle}</h3>
    <h5>조회수: ${board.boardCnt}</h5>
    <div>${board.boardContent}</div>
</div>
