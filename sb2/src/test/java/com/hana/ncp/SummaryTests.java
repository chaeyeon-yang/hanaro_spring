package com.hana.ncp;

import com.hana.util.NcpUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SummaryTests {
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;

    @Test
    void contextLoads() {
        String document = "오늘은 정말 긴 하루였다. 아침에는 안과에 갔고 집에와서 토마토 카레를 먹었다! 새콤하고 맛있는 카레였다. 그리고 오후에는 우리집 강아지 삼식이와 산책했다. 삼식이가 기뻐해서 나도 기뻤다. 풀 냄새를 맡는 삼식이가 너무 귀여웠다. 오늘은 정말 행복한 하루였다";
        JSONObject obj = (JSONObject) NcpUtil.getSummary(ncpId, ncpSecret, document);
        log.info(obj.toJSONString());
    }
}
