<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .div_bg {
        border: 2px solid #ff97ba !important;
    }
</style>
<script>
    let jquery2 = {
        init: function () {
            $('#append').click(function (){
                $('#result').append('<h2>Append ...</h2>')
            })
            $('#prepend').click(function (){
                $('#result').append('<h2>Prepend ...</h2>')
            })
            $('#after').click(function (){
                $('#result').append('<h2>After ...</h2>')

            })
            $('#before').click(function (){
                $('#result').append('<h2>Before ...</h2>')

            })
            $('#remove').click(function (){
                $('#result').append('<h2>Remove ...</h2>')
            })
            $('#empty').click(function (){
                $('#result').append('<h2>Empty ...</h2>')
            })
        }
    }
    $(function () {
        jquery2.init()
    })
</script>
<div class="container">
    <h2>JQuery2 Page</h2>
    <button id="append" type="button" class="btn btn-primary">APPEND</button>
    <button id="prepend" type="button" class="btn btn-primary">PREPEND</button>
    <button id="after" type="button" class="btn btn-primary">AFTER</button>
    <button id="before" type="button" class="btn btn-primary">BEFORE</button>
    <button id="remove" type="button" class="btn btn-primary">REMOVE</button>
    <button id="empty" type="button" class="btn btn-primary">EMPTY</button>
    <div id="result" class="container div_bg"> </div>
</div>
