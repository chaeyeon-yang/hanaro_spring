package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.entity.LoginCust;
import com.hana.app.repository.LoginCustRepository;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {

    final CustService custService;
    final LoginCustRepository loginCustRepository;

    String dir = "cust/";
    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        // Database에서 데이터를 가지고 온다.
        List<CustDto> list = new ArrayList<>();
        try {
            list = custService.get();
            model.addAttribute("custs",list);
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new Exception("ER0001");
        }
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id){
        // Database에서 데이터를 가지고 온다.
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/detailUpdate")
    public String detailUpdate(Model model, CustDto custDto){
        try {
            custService.modify(custDto);
            return "redirect:/cust/get";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") String id){
        try {
            custService.del(id);
            return "redirect:/cust/get";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto) throws Exception{
        custService.add(custDto);
        return "redirect:/cust/detail?id="+custDto.getId();
    }

    @RequestMapping("/logininfo")
    public String logininfo(Model model){
        long cnt = loginCustRepository.count();
        Iterable<LoginCust> it = loginCustRepository.findAll();
        List<LoginCust> list = new ArrayList<>();
        it.forEach(lc->{
            list.add(lc);
        });
        model.addAttribute("logincusts",list);
        model.addAttribute("cnt",cnt);
        model.addAttribute("center",dir+"logininfo");
        return "index";
    }
}
