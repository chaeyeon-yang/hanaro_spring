package com.hana.controller;

import com.github.pagehelper.PageInfo;
import com.hana.app.data.dto.BoardDto;
import com.hana.app.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
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
    public String detail(Model model, @RequestParam("id") int id, HttpSession httpSession) throws Exception {
        BoardDto boardDto = null;
        try {
            boardDto = boardService.get(id);
            log.info("%%%%");
//            boardDto.getCommentList().stream().forEach(c->{log.info(c.toString());});

            if (boardDto.getCustId() == null) {
                boardService.cntUpdate(id);
            } else if(httpSession != null &&
                    !boardDto.getCustId().equals(httpSession.getAttribute("id"))){
                boardService.cntUpdate(id);
            }

            model.addAttribute("board", boardDto);
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            throw e;
        }
        return "index";
    }

    @RequestMapping("/update")
    public String update(Model model,BoardDto boardDto) throws Exception {
        boardService.modify(boardDto);
        model.addAttribute("center",dir+"detail");

        return "redirect:/board/get";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) throws Exception {
        boardService.del(id);
        return "redirect:/board/get";
    }

    @RequestMapping("/allpage")
    public String allPage(Model model, @RequestParam("pageNo") int pageNo) {
        PageInfo<BoardDto> p ;
        try {
            p = new PageInfo<>(boardService.getPage(pageNo),5);
            model.addAttribute("cpage", p);
            model.addAttribute("left", "left");
            model.addAttribute("target","/board");
            model.addAttribute("center", dir+"allpage");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
}
