<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-27
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
  let left = {
    init: function () {
      $('#btn_board_add').click(() => {
          if ('${sessionScope.id}' == '' || '${sessionScope.id}' == null) {
            $('#btn_board_add').removeAttr('href');
            alert('로그인해야 접근이 가능합니다.')
          } else {

          }
      })
    }
  }
  $(function () {
    left.init();
  })
</script>

<ul class="nav nav-pills flex-column">
  <li class="nav-item">
    <a id="btn_board_add" class="nav-link" href="<c:url value="/board/add" />">Board Add</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/board/get" />">Board Get</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/board/allpage?pageNo=1" />">Board Paging</a>
  </li>
  <li>
    <a class="nav-link" href="<c:url value="/weather"/>">Weather</a>
  </li>
  <li>
    <a class="nav-link" href="<c:url value="/pic"/>">pic</a>
  </li>
  <li>
    <a class="nav-link" href="<c:url value="/summary"/>">summary</a>
  </li>
</ul>
