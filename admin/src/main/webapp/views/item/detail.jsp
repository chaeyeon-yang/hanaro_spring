<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/04
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %><script>
    let item_detail = {
        init:function(){
            $('#item_update_form > #update').click(() => {
                let c = confirm('수정하시겠습니까?');
                if(c == true){
                    this.send();
                }
            });
            $('#item_update_form > #delete').click(() => {
                let c = confirm('삭제하시겠습니까?');
                if(c == true){
                    let id = $('#id').val();
                    location.href = '<c:url value="/cust/delete"/>?id='+id;
                }
            });
        },
        send:function(){
            $('#item_update_form').attr({
                'method':'post',
                'enctype': 'multipart/form-data',
                'action': '<c:url value="/item/updateimpl"/>'
            });
            $('#item_update_form').submit();
        },
    };
    $(function(){
        item_detail.init();
    });
</script>

<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form id="item_update_form">
                    <div class="form-group">
                        <label for="itemId">ID:</label>
                        <input readonly="readonly" type="text" value="${item.itemId}" class="form-control" id="itemId" placeholder="Enter id" name="itemId">
                    </div>
                    <div class="form-group">
                        <label for="itemName">NAME:</label>
                        <input type="text"  value="${item.itemName}"  class="form-control" id="itemName" placeholder="Enter name" name="itemName">
                    </div>
                    <div class="form-group">
                        <label for="itemPrice">PRICE:</label>
                        <input type="text" value="${item.itemPrice}"  class="form-control" id="itemPrice" placeholder="Enter price" name="itemPrice">
                    </div>
                    <div class="form-group">
                        <img style="width: 200px" src="<c:url value="/imgs/"/>/${item.imgName}">
                        <input type="hidden" name="imgName" value="${item.imgName}" />
                    </div>
                    <div class="form-group">
                        <label for="newImage">New Image:</label>
                        <input type="file"  class="form-control" id="newImage" placeholder="Enter newImage" name="image">
                    </div>
                    <div class="form-group">
                        <div>등록일:
                            <fmt:parseDate value="${item.regDate}"
                                           pattern="yyyy-MM-dd" var="parsedDateTime2" type="both" />
                            <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${ parsedDateTime2 }" /></div>
                        <div>수정일:
                            <fmt:parseDate value="${item.updateDate}"
                                           pattern="yyyy-MM-dd" var="parsedDateTime2" type="both" />
                            <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${ parsedDateTime2 }" />
                        </div>
                    </div>
                    <button type="button" class="btn btn-primary" id="update">UPDATE</button>
                    <button type="button" class="btn btn-primary" id="delete">DELETE</button>
                </form>
            </div>
        </div>
    </div>
</div>
