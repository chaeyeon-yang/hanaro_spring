<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangchaeyeon
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #geo3 > #map {
        width: 500px;
        height: 500px;
        border: 2px solid lightcyan;
    }
</style>
<script>
    let geo3 = {
        map: null,
        init: function () {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(37.5448181,  127.0565111), // 지도의 중심좌표
                    level: 8 // 지도의 확대 레벨
                };

            // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
            geo3.map = new kakao.maps.Map(mapContainer, mapOption);
            var market_position = new kakao.maps.LatLng(37.5447611,127.0564625);
            var marker = new kakao.maps.Marker({
                position: market_position
            });
            marker.setMap(geo3.map);
            geo3.getshop();

        },
        getshop: function () {
            // $.ajax()
            // lat, lng, title, img, target
            var datas = [
                {'lat': 37.5548181, 'lng':127.0665111, 'title':'순대국', 'img':'a.jpg', 'target':'http://www.naver.com'},
                {'lat': 37.5748181, 'lng':127.0555111, 'title':'파스타', 'img':'a.jpg', 'target':'http://www.nate.com'},
                {'lat': 37.5148181, 'lng':127.0155111, 'title':'햄버거', 'img':'a.jpg', 'target':'http://www.daum.net'},
            ];
            geo3.display(datas);
        },
        display:function(datas) {
            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png';
            $(datas).each(function (index, item) {
                // marker 생성
                // window 생성
                // event
                var imageSize = new kakao.maps.Size(30, 30);
                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
                var marketPosition = new kakao.maps.LatLng(item.lat, item.lng);
                var marker = new kakao.maps.Marker({
                    map: geo3.map,
                    position: marketPosition,
                    title: item.title,
                    image: markerImage
                });
                // infowindow
                var infoContent = '<h3>'+item+'</h3>';
                infoContent += '<img src="<c:url value="/img/'+item.img+'" />" />';

                var infowindow = new kakao.maps.InfoWindow({
                    content : infoContent,
                    position: marketPosition
                });
            });
        }
    }
    $(function () {
        geo3.init()
    })
</script>
<div class="container" id="geo3">
    <h2>GEO3 Page</h2>
    <div id="map"></div>
</div>

