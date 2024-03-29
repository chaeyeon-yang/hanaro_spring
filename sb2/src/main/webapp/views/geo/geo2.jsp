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
<script>
    let geo2 = {
        map: null,
        // initialize
        init: function () {
            this.mapdisplay();
            $('#btn_s').click(() => {
                this.go(37.5447611,127.0564625);
            });
            $('#btn_b').click(() => {
                this.go(35.1290483,129.0446982);
            });
            $('#btn_j').click(() => {
                this.go(33.3846216,126.55344925);
            })
        },
        // map 객체 생성
        mapdisplay: function () {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(37.5447611,127.0564625), // 지도의 중심좌표
                    level: 8 // 지도의 확대 레벨
                };
            this.map = new kakao.maps.Map(mapContainer, mapOption);

            var market_position = new kakao.maps.LatLng(37.5447611,127.0564625);
            var marker = new kakao.maps.Marker({
                position: market_position
            });
            marker.setMap(this.map);
        },
        // 이동
        go: function (lat, lng) {
            // 이동하는 지역의 데이터를 가지고 온다.
            // loc(s, b, j)
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            this.map.panTo(moveLatLon);
        },
        getgeodata: function (loc) {

        },
        display: function (datas){}
    }

    $(function () {
        geo2.init()
    })
</script>
<div class="container" id="geo2">
    <h2>GEO2 Page</h2>
    <button id="btn_s" type="button" class="btn btn-primary">Seoul</button>
    <button id="btn_b" type="button" class="btn btn-primary">Busan</button>
    <button id="btn_j" type="button" class="btn btn-primary">Jeju</button>
    <div id="map"></div>
</div>

