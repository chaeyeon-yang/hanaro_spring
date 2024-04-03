<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    var addrJson = JSON.parse('${addrs}');
    window.onload = function() {


        // JSON 배열을 반복하여 테이블 행을 추가합니다.
        addrJson.forEach(function(addr) {
            $('.table-striped tbody').empty().append(
                '<tr><td><a href="<c:url value="/mypage/detail"/>' + '?id=' + addr.addrId + '">' + addr.addrId + '</a></td><td>' + addr.addrName + '</td><td>' + addr.addrDetail + '</td><td>' + addr.custId + '</td></tr>'
            );
        });
    }
</script>
<div class="container">
    <h2>MY Page</h2>
    <h5>내 주소 목록</h5>
    <br />
    <table class="table table-striped">
        <thead>
        <tr>
            <th>주소 ID</th>
            <th>NAME</th>
            <th>DETAIL</th>
            <th>회원 ID</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
