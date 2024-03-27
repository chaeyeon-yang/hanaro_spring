package com.hana.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MainController {
   @RequestMapping("/")
   public String main() {return "index";}

   @RequestMapping("/login")
   public String login(Model model) {
      model.addAttribute("center", "login");
      return "index";
   }

   @RequestMapping("/logout")
   public String logout(Model model, HttpSession httpSession) {
      if (httpSession != null) {
         httpSession.invalidate();
      }
      return "index";
   }

   @RequestMapping("/loginimpl")
   public String loginimpl(Model model, @RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession httpSession) {
      log.info("-----------------------------");
      log.info(id+" "+pwd);

      if (id.equals("qqq") && pwd.equals("111")) {
//         httpSession.setMaxInactiveInterval(80000);
         httpSession.setAttribute("id", id);
      } else {
         log.info("로그인 실패");
      }
      model.addAttribute("center", "login");
      return "index";
   }

   @RequestMapping("/register")
   public String register(Model model) {
      model.addAttribute("center", "register");
      return "index";
   }
   @RequestMapping("/registerimpl")
   public String registerimpl(Model model, @RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession httpSession) {
      log.info("-----------------------------");
      log.info(id+" "+pwd+" "+name);
      if (id.equals("qqq") && pwd.equals("111")) {
//         httpSession.setMaxInactiveInterval(80000);
         httpSession.setAttribute("id", id);
         model.addAttribute("center", "center");

      } else {
         log.info("로그인 실패");
         model.addAttribute("center", "register");

      }
      return "index";
   }



}
