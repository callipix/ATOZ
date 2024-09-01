package com.project.myapp.board.service;

import java.util.List;
import java.util.Map;

import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.SearchCondition;

public interface BoardService {

	// 게시물 검색

	// 게시물 전체리스트
	public List<BoardDTO> getBoardList();

	// 게시물 페이징
	public List<BoardDTO> getSelectPage(Map map);

	// 전체 게시물 수 가져오기
	public int getBoardCount();

	// 특정게시물 조회
	public BoardDTO getBoardByBno(int bno);

	// 게시물 등록
	public int insertBoard(BoardDTO board) throws Exception;

	// 게시물 업데이트(수정)
	public int updateBoardByIdNBno(BoardDTO board) throws Exception;

	// 게시물 삭제(관리자용)
	public int deleteForAdmin(int id) throws Exception;

	// 게시물 전체삭제(테스트용)
	public int deleteAll() throws Exception;

	// 게시물 삭제(본인)
	public int deleteByIdNBno(Integer bno, String writer) throws Exception;

	// 댓글 수 업데이트

	public List<BoardDTO> getSearchSelectPage(SearchCondition sc);

	public int getSearchResultCount(SearchCondition sc);
}
