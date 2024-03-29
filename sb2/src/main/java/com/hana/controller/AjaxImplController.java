package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.SearchDto;
import com.hana.app.data.dto.ShopDto;
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
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
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

    @RequestMapping("/geo/getdata")
    public Object geogetdata() {
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","국밥.jpeg",37.5547611, 127.0654625));
        list.add(new ShopDto(101,"파스타","파스타.jpeg",37.5747611, 127.0554625));
        list.add(new ShopDto(102, "햄버거","햄버거.jpeg", 37.5147611,127.0154625 ));

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
