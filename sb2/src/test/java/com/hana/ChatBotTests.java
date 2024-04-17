package com.hana;

import com.hana.util.ChatBotUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

@SpringBootTest
@Slf4j
class ChatBotTests {

    @Value("${app.key.chatbot_key}")
    private String secretKey = "bGVWb3Z0aURYdmNOY3V2Zk95VnBndEhuQlFIcVFMQUU=";
    @Value("${app.key.chatbot_url}")
    private String apiUrl = "https://xdpyx9zoyh.apigw.ntruss.com/custom/v1/14180/da2052c66f548292d68089066f0b9d314fa08914bff5e425f5f3a3b5812561c0";


    @Test
    void contextLoads() throws Exception {
        String msg = "힘들겠네";
        String result = ChatBotUtil.getMsg(apiUrl, secretKey,msg);
        log.info(result);
    }
}