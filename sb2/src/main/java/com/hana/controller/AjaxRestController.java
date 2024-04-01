package com.hana.controller;

import com.hana.app.data.dto.Chart2Dto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.SearchDto;
import com.hana.app.data.dto.ShopDto;
import com.hana.app.data.dto.chart.Chart1Dto;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


// Controller: 요청이 오면 jsp를 리턴하고, jsp가 서버에서 만들어져서 html로 변환됨 (화면을 보냄)
// RestController: 값만 바로 쏴버리는 형태 + Ajax
@RestController
@Slf4j
public class AjaxRestController {

    private String aa;

    public AjaxRestController() {
        log.info("start ---------");
        aa ="aaaa";
    }

    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        log.info(this.aa+ "---------");
        return date;
    }

    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id) {
        String result = "1";
        if (id.equals("qqq")) {
            result = "0";
        }
        return result;
    }

    @RequestMapping("/chart/getdata")
    public Object chartgetdata() {
        // JSONArray - json 안에 객체를 넣을 때
        JSONArray ja = new JSONArray();
        List<Chart2Dto> list = new ArrayList<>();
        list.add(new Chart2Dto("S001",10,20,30,40,10,5));
        list.add(new Chart2Dto("S002",13,19,24,30,20,15));
        list.add(new Chart2Dto("S003",8,18,29,31,24,6));
        list.add(new Chart2Dto("S004",9,12,19,10,8,9));

        for (Chart2Dto c:list) {
            JSONObject jo = new JSONObject();
            // [{name, data:[]}]
            jo.put("name", c.getName());
            jo.put("data", c.getM());

            ja.add(jo);
        }

        return ja;
    }


    @RequestMapping("/chart/getchart1data")
    public Object getchart1data() {
        // JSONArray - json 안에 객체를 넣을 때
        JSONArray ja = new JSONArray();
        List<Chart1Dto> list = new ArrayList<>();
        list.add(new Chart1Dto("name1", 434, 290, 307));
        list.add(new Chart1Dto("name2",272, 153, 156));
        list.add(new Chart1Dto("name3",13, 7, 8));


        list.stream().forEach(c -> {
            JSONObject jo = new JSONObject();
            // [{name, data:[]}]
            jo.put("name", c.getName());
            jo.put("data", c.getM());

            ja.add(jo);
        });

        return ja;
    }

//    @RequestMapping("/chart/getchart2data")
//    public Object getchart2data() {
//        JSONArray ja = new JSONArray();
//        List<Chart2Dto> list = new ArrayList<>();
//
//        JSONArray ja2 = new JSONArray();
//        ja2.add(new CircleDto("Spain",505992,92 ));
//        ja2.add(new CircleDto("France",551695,119 ));
//        ja2.add(new CircleDto("Poland",312679,121 ));
//        ja2.add(new CircleDto("Czech Republic",78865,136 ));
//        ja2.add(new CircleDto("Italy",301336,200 ));
//        ja2.add(new CircleDto("Switzerland",41284,213 ));
//        ja2.add(new CircleDto("Germany",357114,235 ));
//
////        Chart2Dto chart2Dto = Chart2Dto.builder()
////                .minPointSize(10)
////                .innerSize("20%")
////                .zMin(0)
////                .name("countries")
////                .borderRadius(5)
////                .circleList(ja2)
////                .build();
//
////        list.add(chart2Dto);
//
//        for (Chart2Dto c : list) {
//            JSONObject jo = new JSONObject();
//            jo.put("name", c.getName());
//            jo.put("data", c.getCircleList());
//
//            ja.add(jo);
//        }
//
//        return ja;
//    }


    @RequestMapping("/chart4")
    public Object chart4(@RequestParam("gender") String gender) {
        // JSONArray - json 안에 객체를 넣을 때
        JSONArray ja = new JSONArray();
        List<Chart2Dto> list = new ArrayList<>();
        list.add(new Chart2Dto("Female", 30,10,10,10,20,20));
        list.add(new Chart2Dto("Male",40,10,10,10,10,20));


        list.stream().filter(c-> c.getName().equals(gender)).forEach(c->{
            c.getM().stream().forEach(n->{
                JSONArray ja2 = new JSONArray();
                // [["",20],[],[],[]]
                ja2.add("OTT");
                ja2.add(n);
                ja.add(ja2);
            });
        });
        //{"data:":[], "title":"f"}
        JSONObject jo = new JSONObject();
        jo.put("data",ja);
        jo.put("title",gender);
        return jo;
    }
    @RequestMapping("/geo/getdata")
    public Object geogetdata() {
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","국밥.jpeg",37.5547611, 127.0654625));
        list.add(new ShopDto(101,"파스타","파스타.jpeg",37.5747611, 127.0554625));
        list.add(new ShopDto(102, "햄버거","햄버거.jpeg", 37.5147611,127.0154625 ));

        return list;
    }

    @RequestMapping("/geo/seongsu/likeplace")
    public Object geogetlikeplace() {
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"고운돈카츠","고운돈카츠.jpeg",37.5447624, 127.054203));
        list.add(new ShopDto(101,"소문난성수감자탕","파스타.jpeg",37.5428241, 127.0543732));

        return list;
    }

    @RequestMapping("/getdata")
    public Object getdata() {
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01", "pwd01", "dowoon"));
        list.add(new CustDto("id01", "pwd01", "dowoon"));
        list.add(new CustDto("id01", "pwd01", "dowoon"));
        list.add(new CustDto("id01", "pwd01", "dowoon"));

        return list;
    }
    @RequestMapping("/getsearchrank")
    public Object getsearchrank() {
        List<SearchDto> list = new ArrayList<>();
        Random random = new Random();
        List<Integer> usedRanks = new ArrayList<>();
        List<String> usedTitles = new ArrayList<>();
        String[] titles = {"김원필", "윤도운", "박성진", "강영현", "양채연"};

        for (int i = 0; i < 5; i++) {
            int randomRank;
            String randomTitle;
            do {
                randomRank = random.nextInt(5) + 1;
            } while (usedRanks.contains(randomRank));

            do {
                randomTitle = titles[random.nextInt(titles.length)];
            } while (usedTitles.contains(randomTitle));

            list.add(new SearchDto(randomRank, randomTitle));
            usedRanks.add(randomRank);
            usedTitles.add(randomTitle);
        }

        return list;
    }


}
