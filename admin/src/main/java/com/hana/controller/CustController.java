package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {
    String dir = "cust/";

    @RequestMapping("/get")
    public String get(Model model) {
        // Database에서 데이터를 가지고 온다.
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));
        list.add(new CustDto("id01","pwd01","wonpil"));


        model.addAttribute("custs", list);
        model.addAttribute("center",dir+"get");
        return "index";
    }
}
