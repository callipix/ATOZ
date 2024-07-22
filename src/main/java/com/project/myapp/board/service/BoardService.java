package com.project.myapp.board.service;

import com.project.myapp.dto.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public List<BoardDTO> getBoardList();

    public List<BoardDTO> getSelectPage(Map map);

    public int getBoardCount();

}
