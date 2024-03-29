<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <!-- KAKAO Map API -->
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=57527925f0a428a9f87c78617fc07348"></script>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="<c:url value="/js/0327.js" />"></script>


    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>
<body >

<div class="jumbotron text-center " style="margin-bottom:0">
    <h1>HTML5 & JavaScript</h1>
    <p>Resize this responsive page to see the effect!</p>
</div>
<c:choose>
    <c:when test="${id == null}">
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/login"/>">LOGIN</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/register"/>">REGISTER</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="#"/>">ABOUT US</a>
            </li>
        </ul>
    </c:when>
    <c:otherwise>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="#"/>">${id}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>">LOGOUT</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="#"/>">ABOUT US</a>
            </li>
        </ul>
    </c:otherwise>
</c:choose>

<%--Start Nav Bar--%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="<c:url value='/'/>">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/html/"/>">HTML</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jquery/">JQuery</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/ajax/">Ajax</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/geo/">Geo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chart/">Chart</a>
            </li>
        </ul>
    </div>
</nav>
<%--End Nav Bar--%>

<%--Start Center Area--%>
<div class="container-fluid" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">
            <c:choose>
                <c:when test="${left == null}">
                    <jsp:include page="left.jsp" />
                </c:when>
                <c:otherwise>
                    <jsp:include page="${left}.jsp" />
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-10">
            <c:choose>
                <c:when test="${center == null}">
                    <jsp:include page="center.jsp" />
                </c:when>
                <c:otherwise>
                    <jsp:include page="${center}.jsp" />
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%--End Center Area--%>

<%--Start Bottom Area--%>
<div class="text-center bg-dark" style="margin-bottom:0">
    <p>Footer</p>
</div>
<%--End Bottom Area--%>

</body>
</html>