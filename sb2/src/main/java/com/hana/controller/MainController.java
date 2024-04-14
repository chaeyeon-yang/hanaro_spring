package com.hana.controller;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.BoardService;
import com.hana.app.service.CustService;
import com.hana.util.WeatherUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    final CustService custService;
    final BoardService boardService;
    final BCryptPasswordEncoder encoder;

    @Value("${app.key.wkey}")
    String wkey;

    @Value("${app.key.whkey}")
    String whkey;

    @Value("${app.url.serverurl}")
    String serverurl;

    @RequestMapping("/")
    public String main(Model model) throws Exception {
        Random r = new Random();
        int num = r.nextInt(100)+1;
        List<BoardDto> list = null;
        try {
            list = boardService.getRank();
        } catch (Exception e) {
            model.addAttribute("ranks", null);
        }

        model.addAttribute("ranks", list);
        log.info(num+"");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center","login");
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(Model model, HttpSession httpSession){
        if(httpSession != null){
            httpSession.invalidate();
        }
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model,
                            @RequestParam("id") String id,
                            @RequestParam("pwd") String pwd, HttpSession httpSession){
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            if (custDto == null) {
                throw new Exception();
            }
            if (!encoder.matches(pwd, custDto.getPwd())) {
                throw new Exception();
            }
            httpSession.setAttribute("id", id);
        } catch (Exception e){
            model.addAttribute("msg","ID또는 PWD가 틀렸습니다.");
            model.addAttribute("center","login");
            //throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               CustDto custDto, HttpSession httpSession){
        // 회원에게 받은 정보 -> 서버에 저장시 암호화
        // 그러나, 서버에 정보가 가는 도중에 해킹이 가능하다(따라서 화면에서 입력받을 때 부터 가상키패드 사용함)
        try {
            log.info("-------------logloglog");
//            log.info(encoder.encode(custDto.getPwd()));
//            log.info(encoder.encode(custDto.getPwd()).length()+"");
            // 회원가입 시 비밀번호 암호화
            custDto.setPwd(encoder.encode(custDto.getPwd()));
            custService.add(custDto);
            // 회원가입과 동시에 로그인 가능: 서버 세션에 사용자의 ID를 저장
            httpSession.setAttribute("id", custDto.getId());
        } catch (Exception e) {
            model.addAttribute("center","registerfail");
        }
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/registercheckid")
    public Object registercheckid(Model model, @RequestParam("id") String id) throws Exception {
        String result = "0";
        CustDto custDto = custService.get(id);
        if(custDto == null){
            result = "1";
        }
        return result;
    }

    @RequestMapping("/wh")
    @ResponseBody
    public Object wh(Model model) throws IOException, ParseException, org.json.simple.parser.ParseException {
        return WeatherUtil.getWeather("109", wkey);
    }

    @RequestMapping("/wh2")
    @ResponseBody
    public Object wh2(Model model) throws IOException, ParseException, org.json.simple.parser.ParseException {
        return WeatherUtil.getWeather2("1835848", whkey);
    }

    @RequestMapping("/weather")
    public String weather(Model model){
        model.addAttribute("center","weather");
        return "index";
    }

    @RequestMapping("/chat")
    public String chat(Model model){
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("center","chat");
        return "index";
    }
}
