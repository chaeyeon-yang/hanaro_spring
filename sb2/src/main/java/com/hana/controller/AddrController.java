package com.hana.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AddrService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/detail")
    public String detail(Model model,
                         @RequestParam("id") Integer id) {
        AddrDto addrDto = null;
        try {
            addrDto = addrService.get(id);
            model.addAttribute("addr", addrDto);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"detail");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(Model model,
                         @RequestParam("id") Integer id,  RedirectAttributes redirectAttributes) {
        try {
            addrService.del(id);
            redirectAttributes.addFlashAttribute("message", "삭제 성공");
            return "redirect:/mypage/";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, @RequestParam("addrName") String addrName, @RequestParam("addrDetail") String addrDetail,  HttpSession httpSession) {
        var userId = httpSession.getAttribute("id").toString();

        try {
            addrService.add(new AddrDto(0, addrName,addrDetail, userId));
            return "redirect:/mypage/";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
