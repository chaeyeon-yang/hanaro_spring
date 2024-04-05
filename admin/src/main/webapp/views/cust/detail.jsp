<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/04
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let detailUpdate = {
        init:function(){
            $('#register_form > #modify').click(function(){
                let c = confirm('수정하시겠습니까?');
                if(c == true){
                    detailUpdate.send();
                }
            });
            $('#register_form > #delete').click(function(){
                let c = confirm('삭제하시겠습니까?');
                if(c == true){
                    let id = $('#id').val();
                    location.href = '<c:url value="/cust/delete"/>?id='+id;
                }
            });
        },
        send:function(){
            $('#register_form').attr({
                'method':'post',
                'action': '<c:url value="/cust/detailUpdate"/>'
            });
            $('#register_form').submit();
        },
    };
    $(function(){
        detailUpdate.init();
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
                <form id="register_form">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input readonly="readonly" type="text" value="${cust.id}" class="form-control" id="id" placeholder="Enter id" name="id">

                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password"  value="${cust.pwd}"  class="form-control" id="pwd" placeholder="Enter password" name="pwd">

                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" value="${cust.name}"  class="form-control" id="name" placeholder="Enter name" name="name">

                    </div>
                    <button type="button" class="btn btn-primary" id="modify">MODIFY</button>
                    <button type="button" class="btn btn-primary" id="delete">DELETE</button>
                </form>
            </div>
        </div>
    </div>
</div>
