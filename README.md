# hanaro_spring

## JSP, Thymeleaf (JDBC, JPA)

### Sb2 서버

로그인 화면

- db 회원정보와 일치할 시 로그인 가능

회원가입 화면
- 아이디 중복체크

메인 화면

- 인기 게시물 (조회수 순)
- 현재 서울 날씨 정보 (openweathermap api, 공공데이터 날씨 api)
- 스레드 스케쥴링, 일정시간마다 로그 찍기
- 브라우징 다국어 처리
- jsp 톰캣 배포

게시글 화면

- 게시글 작성 (로그인 시 접근 가능)
- 게시글 상세 조회 (댓글, 조회수)
- 게시글 수정
- 게시글 삭제
- 게시글 목록 조회
- 게시글 목록 조회 (페이징 처리)

회원정보 화면

- 회원 정보 목록

JQUERY 화면

- jquery 문법을 익히기 위한 여러 테스트

AJAX 화면

- 서버 시간 받아오기
- 아이디 사용 가능 여부 받아오기

GEO 화면

- kakao map api 로 현재 위치 표시하기
- 버튼 클릭시 해당 지역으로 지도 이동
- 마커 hover 시 미리보기 사진, 설명 띄우기 (클릭 시 해당 가게 상세 페이지 이동)

CHART 화면

- live graph chart 데이터 바꿔서 뿌리기
- 성별 선택에 따른 live circle chart 뿌리기

### Admin 서버

로그인, 회원가입

채팅 화면 (Web Socket)

- 전체 메세지 보내기
- 나에게 메세지 보내기
- 특정인에게 메세지 보내기

Live Data

- sb2 서버 접속량을 Live Data 그래프로 뿌리기

Cust

- 회원 추가
- 회원 조회
- 회원 수정
- 회원 삭제

Item

- 아이템 조회
- 아이템 추가
- 이미지 파일 업로드

### Single Sign On(동시 로그인 제어)

### 관리자 서버
- 채팅 기능(전체 보내기, 나에게 보내기)
- 챗봇 기능(naver api)

