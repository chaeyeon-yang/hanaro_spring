package com.hana.weather;

import com.hana.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
@Slf4j
public class Test {

    @org.junit.jupiter.api.Test
    void contextLoads() throws IOException, ParseException, java.text.ParseException {
        String key = "3JjM4ywSiOm68eVL9D4idMkcUiZ5GKlKWAl1H44IotvQ5ypCVmj%2ByLqMeSXwP4c3ckD0bo7iCyN8JkOwgtkINg%3D%3D";
        String loc = "109";
        JSONObject jsonObject = (JSONObject) WeatherUtil.getWeather(loc, key);
        log.info("----------LOG----------------"+jsonObject.toJSONString());
    }
}
