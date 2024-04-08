<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    p{
        color:red;
    }
</style>


<div class="container">
    <h2>게시글 목록</h2>
    <br />
    <table class="table table-striped" id="board_table">
        <thead>
        <tr>
            <th>ID</th>
            <th>PWD</th>
            <th>NAME</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><a href="<c:url value="/html/get"/>?id=${c.id}">${c.id}</a></td>
                <td>${c.pwd}</td>
                <td>${c.name}</td>
            </tr>
        </tbody>
    </table>
</div>
