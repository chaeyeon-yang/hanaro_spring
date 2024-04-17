<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/17
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let ocr = {
        init: function () {
        }
    };
    $(function () {
        ocr.init();
    });
</script>

<div class="container">
    <h2>Ocr</h2>
    <form id="item_add_form" action="<c:url value="/ocrimpl" />" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="image">Image:</label>
            <input type="file"  class="form-control" id="image" placeholder="Enter image" name="image">

        </div>

        <%--type을 submit으로 하면 자바스크립트 작성 필요없이 자동으로 데이터가 날아감--%>
        <%--사진 전송을 원하므로 enctype attribute 추가--%>
        <button id="btn_add" type="submit" class="btn btn-primary">Send</button>
    </form>
    <img width="200px" src="<c:url value="/imgs/${imgname}"/>" />
    <h3>${result.bizname}</h3>
    <h3>${result.bizowner}</h3>
    <h3>${result.bizdate}</h3>
    <h3>${result.bizadd}</h3>
</div>
