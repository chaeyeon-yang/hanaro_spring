package com.hana.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hana.app.data.dto.AddrDto;
import com.hana.app.service.AddrService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class AddrController {
    String dir = "mypage/";

    final AddrService addrService;

    @RequestMapping("/")
    public String main(Model model, HttpSession httpSession){
        var userId = httpSession.getAttribute("id").toString();
        List<AddrDto> addrs = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            addrs = addrService.getAddr(userId);

            String addrsJson = objectMapper.writeValueAsString(addrs);

            model.addAttribute("addrs", addrsJson);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"center");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
}
