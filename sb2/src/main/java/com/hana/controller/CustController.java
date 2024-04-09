package com.hana.controller;

import com.github.pagehelper.PageInfo;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {
    String dir = "cust/";

    final CustService custService;

    @RequestMapping("/")
    public String getAll(Model model) {
        List<CustDto> list = null;

        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"search");
        return "index";
    }

    @RequestMapping("/searchimpl")
    @ResponseBody
    public CustDto searchImpl(Model model, @RequestParam("id") String id) {
        try {
            CustDto custDto = custService.get(id);
            return custDto;
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
    public String addimpl(Model model, CustDto custDto) {
        try {
            custService.add(custDto);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"addimpl");
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model,
                             @RequestParam("id") String id) {
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"detail");
        } catch (Exception e) {
            model.addAttribute("left", dir+"left");
            model.addAttribute("center", dir+"registerfail");
//            throw new RuntimeException(e);
        }
        return "index";
    }
    @RequestMapping("/allpage")
    public String allPage(Model model, @RequestParam("pageNo") int pageNo) {
        PageInfo<CustDto> p;
        try {
            p = new PageInfo<>(custService.getPage(pageNo),5);
            model.addAttribute("cpage", p);
            model.addAttribute("left", dir+"left");
            model.addAttribute("target", "/cust");
            model.addAttribute("center",dir+"allpage");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
}
