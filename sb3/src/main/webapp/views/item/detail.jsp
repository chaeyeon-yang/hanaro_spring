<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h2>Item Detail</h2>
    <h3><img style="width: 200px"  src="<c:url value="/imgs"/>/${item.imgName}"></h3>
    <h5>${item.itemName}</h5>
    <div>
        <fmt:formatNumber type="number" pattern="###,###원" value="${item.itemPrice}" />
    </div>
    <div>${item.regDate}</div>
    <div>${item.updateDate}</div>
</div>