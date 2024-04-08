<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-27
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  a {
    color: green;
  }
</style>
<ul class="nav nav-pills flex-column">
  <p style="color: darkslategrey">아이템 정보</p>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/item/"/>">전체 아이템 리스트</a>
  </li>
</ul>
