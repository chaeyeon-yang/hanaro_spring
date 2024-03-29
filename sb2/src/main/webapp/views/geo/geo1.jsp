<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #geo1 > #kakaomap {
        width: 500px;
        height: 500px;
        border: 2px solid lightcyan;
    }
</style>
<script>
    let geo1 = {
        map:null,
        latitude: 37.5448181,
        longitude: 127.0565111,
        init:function (){

            if (navigator.geolocation) {
                // GeoLocation을 이용해서 접속 위치를 얻어옵니다
                navigator.geolocation.getCurrentPosition(function(position) {

                    geo1.lat = position.coords.latitude; // 위도
                    geo1.lon = position.coords.longitude; // 경도

                    var locPosition = new kakao.maps.LatLng(geo1.lat, geo1.lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                        message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다

                    // 마커와 인포윈도우를 표시합니다
                    displayMarker(locPosition, message);
                    geo1.map = new kakao.maps.Map(mapContainer, mapOption);
                    geo1.display();
                });

            } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
                alert("error")
            }

            var mapContainer = document.getElementById('kakaomap'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(this.latitude, this.longitude), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };

            // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
            geo1.map = new kakao.maps.Map(mapContainer, mapOption);
            geo1.display();
        },
        display:function (){
            // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
            var mapTypeControl = new kakao.maps.MapTypeControl();

            // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
            // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
            this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

            // 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
            var zoomControl = new kakao.maps.ZoomControl();
            this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            // 마커가 표시될 위치입니다
            var markerPosition  = new kakao.maps.LatLng(37.5448181, 127.0565111);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(this.map);

            var iwContent = '<div style="padding:5px;">Hello World!<br><img src="<c:url value="/img/윤도운.jpeg"/>"></div>'// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

            // 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                content : iwContent
            });

            kakao.maps.event.addListener(marker, 'mouseover', function () {
                infowindow.open(geo1.map, marker)
            })

            kakao.maps.event.addListener(marker, 'mouseout', function () {
                infowindow.close()
            })

            kakao.maps.event.addListener(marker, 'click', function () {
                location.href="http://www.nate.com"
            })

            // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
            infowindow.open(this.map, marker);
        }
    };

    $(function (){
        geo1.init();
    })
</script>
<div class="container">
    <h2>GEO1 Page</h2>
    <div class="container" id="geo1">
        <div id="kakaomap"></div>
    </div>
</div>