package com.hana.ncp;

import com.hana.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
class CreditOcrTests {

    @Value("${app.dir.uploadimgdir}")
    String dir;

    @Test
    void contextLoads() {
        String imgname = "credit1.jpg";
        JSONObject jsonObject = (JSONObject) OCRUtil.getResult(dir,imgname);
        log.info(jsonObject.toJSONString());
        Map<String,String> map = OCRUtil.getCardData(jsonObject);
        map.values().forEach(txt->{log.info(txt);});

    }
}