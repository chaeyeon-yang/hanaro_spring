package com.hana.controller;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.BoardService;
import com.hana.app.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    String dir = "board/";

    final BoardService boardService;


    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<BoardDto> boardList = null;
        boardList = boardService.get();
        model.addAttribute("boardList", boardList);
        model.addAttribute("center",dir+"get");

        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) throws Exception {;
        model.addAttribute("center",dir+"add");

        return "index";
    }
}
