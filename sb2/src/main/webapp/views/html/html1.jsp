<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    p {
        color: red;
    }
</style>

<script>
    $(document).ready(function () {
        $('#ptag').text('Replace Text');
        $('p').click(function (){
            alert('ok')
            $(this).text('Click Event')
        });
    })
</script>

<div class="container">
    <h2>HTML1 PAGE</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <div class="fakeimg">Fake Image</div>
    <p id="ptag">Some text..</p>
    <span>Span</span>
    <a href="#">A TAG</a>
</div>

