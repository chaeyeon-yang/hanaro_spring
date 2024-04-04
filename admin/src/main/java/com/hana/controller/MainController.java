package com.hana.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, @RequestParam("id") String id, HttpSession httpSession){
        httpSession.setAttribute("id", id);
        return "index";
    }
}
