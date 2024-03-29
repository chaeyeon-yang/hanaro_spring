<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #geo2 > #map {
        width: 500px;
        height: 500px;
        border: 2px solid lightcyan;
    }
</style>
<div class="container" id="geo2">
    <h2>GEO2 Page</h2>
    <button id="btn_s" type="button" class="btn btn-primary">Seoul</button>
    <button id="btn_b" type="button" class="btn btn-primary">Busan</button>
    <button id="btn_j" type="button" class="btn btn-primary">Jeju</button>
    <div id="map"></div>
</div>

