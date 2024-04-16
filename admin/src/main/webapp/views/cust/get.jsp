<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-28
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let cust_get = {
        init:function(){},
        update:function(id){
            let c = confirm('수정하시겠습니까?');
            if(c == true){
                location.href = '<c:url value="/cust/detail"/>?id='+id;
            }
        },
        delete:function(id){
            let c = confirm('삭제하시겠습니까?');
            if(c == true){
                location.href = '<c:url value="/cust/delete"/>?id='+id;
            }
        }
    };
    $(function(){
        cust_get.init();
    });
</script>
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">회원 목록</h1>
    <p class="mb-4"> 우리 서비스를 이용하는 회원의 정보입니다. <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Sb2 이용 회원</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>PWD</th>
                            <th>NAME</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>PWD</th>
                            <th>NAME</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="c" items="${custs}">
                            <tr>
                                <td><a href="<c:url value="/cust/detail"/>?id=${c.id}">${c.id}</a></td>
                                <td>${c.pwd}</td>
                                <td>${c.name}</td>
                                <td><button onclick="cust_get.update('${c.id}')" type="button" class="btn btn-primary">Update</button></td>
                                <td><button onclick="cust_get.delete('${c.id}')" type="button" class="btn btn-primary">Delete</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


