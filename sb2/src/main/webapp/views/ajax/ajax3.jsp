<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let ajax3 = {
        init: function () {
            setInterval(function() {
                $.ajax({
                    url: '<c:url value="/getsearchrank"/>',
                    success: function (data) {
                        console.log(data)
                        ajax3.display(data); // 받은 데이터를 출력하는 함수 호출
                    }
                });
            }, 5000); // 5초마다 실행 (시간은 밀리초 단위로 설정)
        },
        display: function(data) {
            let result = "";

            for(let i = 0; i < data.length; i++) {
                result += data[i].rank + "번 "+data[i].title+"\n";
            }
            $('#result').text(result);
        }
    };

    $(function () {
        ajax3.init();
    })
</script>

<div class="container">
    <h2>Ajax3 Page</h2>
    <div id="result"></div>
</div>
