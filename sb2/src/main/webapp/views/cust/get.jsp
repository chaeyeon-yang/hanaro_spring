<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    p{
        color:red;
    }
</style>
<script>
    $(document).ready(function(){
        $('#ptag').text('Replace Text');
        $('h5').click(function(){
            alert('ok');
            $(this).text('Click Event');
        });
    });


</script>

<div class="container">
    <h2>회원정보 조회</h2>
    <br />
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>PWD</th>
            <th>NAME</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${custs}">
            <tr>
                <td><a href="<c:url value="/html/get"/>?id=${c.id}">${c.id}</a></td>
                <td>${c.pwd}</td>
                <td>${c.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
