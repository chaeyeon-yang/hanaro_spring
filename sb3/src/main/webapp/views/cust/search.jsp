<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/04/03
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(document).ready(function(){
        $("#button-addon2").click(function(){
            let userId = $("#idInput").val(); // 입력된 아이디 값을 가져옴
            console.log("입력받은 아이디: " + userId);

            $.get("/cust/searchimpl", {id: userId}, function(data, status, xhr){
                // dataType을 'json'으로 명시하면, jQuery가 응답을 자동으로 JSON 객체로 변환합니다.
                console.log(data);

                $('#custTable tbody').empty().append(
                    '<tr><td><a href="<c:url value="/cust/detail"/>' + '?id=' + data.id + '">' + data.id + '</a></td><td>' + data.pwd + '</td><td>' + data.name + '</td></tr>'
                );
            });
        });
    });
</script>

<div class="container">
    <h2>회원 검색</h2>
    <br />
    <form id="searchForm" class="input-group mb-3">
        <input type="text" id="idInput" class="form-control" placeholder="회원 아이디를 입력하세요." aria-label="Recipient's username" aria-describedby="button-addon2" name="id">
        <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
        </div>
    </form>

    <br />
        <table class="table table-striped" id="custTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>PWD</th>
                    <th>NAME</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
</div>
