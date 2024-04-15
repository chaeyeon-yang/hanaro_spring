package com.hana.app.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hana.app.data.dto.BoardDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService implements HanaService<Integer, BoardDto> {
    final BoardRepository boardRepository;

    @Override
    public int add(BoardDto boardDto) throws Exception {
        return boardRepository.insert(boardDto);
    }

    @Override
    public int del(Integer id) throws Exception {
        return boardRepository.delete(id);
    }

    @Override
    public int modify(BoardDto boardDto) throws Exception {
        return boardRepository.update(boardDto);
    }

    @Override
    public BoardDto get(Integer id) throws Exception {
        return boardRepository.selectOne(id);
    }

    @Override
    public List<BoardDto> get() throws Exception {
        return boardRepository.select();
    }


    public int cntUpdate(Integer id) throws Exception {
        return boardRepository.cntUpdate(id);
    }

    public List<BoardDto> getRank() throws Exception {
        return boardRepository.getRank();
    }

    public Page<BoardDto> getPage(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 3);; //3: 한 화면에 출력되는 개수
        return boardRepository.getPage();
    }
}
