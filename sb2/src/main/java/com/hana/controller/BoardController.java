package com.hana.controller;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.BoardService;
import com.hana.app.service.ItemService;
import jakarta.servlet.http.HttpSession;
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
    @RequestMapping("/addimpl")
    public String addimpl(Model model, @RequestParam("title") String title, @RequestParam("content") String content, HttpSession httpSession) throws Exception {
        String userId = httpSession.getAttribute("id").toString();
        BoardDto newBoard = BoardDto.builder().custId(userId).boardTitle(title).boardContent(content).build();
        boardService.add(newBoard);
        model.addAttribute("center",dir+"get");

        return "redirect:/board/get";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") Integer id) throws Exception {
        BoardDto board = null;
        board = boardService.get(id);
        model.addAttribute("board", board);
        model.addAttribute("center",dir+"detail");

        return "index";
    }
}
