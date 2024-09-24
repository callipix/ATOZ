package com.project.atoz.board.dao;

import java.util.List;
import java.util.Map;

import com.project.atoz.dto.BoardDTO;
import com.project.atoz.dto.SearchCondition;

public interface BoardDAO {
	// 게시물 전체리스트
	List<BoardDTO> getBoardList();

	// 게시물 페이징
	List<BoardDTO> getSelectPage(Map map);

	// 전체 게시물 수 가져오기
	int getBoardCount();

	// 특정게시물 조회
	BoardDTO getBoardByBno(int bno);

	// 게시물 등록
	int insertBoard(BoardDTO board);

	// 게시물 업데이트(수정)
	int updateBoardByIdNBno(BoardDTO board);

	// 게시물 삭제(관리자용)
	int deleteForAdmin(int id);

	// 게시물 전체삭제(테스트용)
	int deleteAll();

	// 게시물 삭제(본인)
	int deleteByIdNBno(Integer bno, String writer);

	// 조회수 증가
	int increaseViewCount(int bno);

	// 댓글 수 업데이트
	int updateCommentCount(Integer bno, int cnt);

	List<BoardDTO> getSearchSelectPage(SearchCondition sc);

	int getSearchResultCount(SearchCondition sc);
}
