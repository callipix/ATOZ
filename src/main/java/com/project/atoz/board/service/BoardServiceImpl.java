package com.project.atoz.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.atoz.board.mapper.BoardMapper;
import com.project.atoz.dto.BoardDTO;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.security.auth.CustomDetails;
import com.project.atoz.utiles.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;

	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> getBoardList = boardMapper.getBoardList();
		return getBoardList;
	}

	@Override
	public List<BoardDTO> getSelectPage(Map map) {
		List<BoardDTO> getSelectPage = boardMapper.getSelectPage(map);
		return getSelectPage;
	}

	@Override
	public int getBoardCount() {

		int getBoardCount = boardMapper.getBoardCount();
		return getBoardCount;
	}

	@Override
	public BoardDTO getBoardByBno(int bno) {
		BoardDTO boardDTO = boardMapper.getBoardByBno(bno);
		boardMapper.increaseViewCount(bno);
		return boardDTO;
	}

	@Override
	public int insertBoard(BoardDTO board) throws Exception {

		board.setContent(StringUtils.escapeDollorSign(board.getContent()));
		int result = boardMapper.insertBoard(board);
		return result;
	}

	@Override
	public int updateBoardByIdNBno(BoardDTO board) throws Exception {
		board.setContent(StringUtils.escapeDollorSign(board.getContent()));
		int result = boardMapper.updateBoardByIdNBno(board);
		return result;
	}

	@Override
	public int deleteForAdmin(int id) throws Exception {
		int result = boardMapper.deleteForAdmin(id);
		return result;
	}

	@Override
	public int deleteAll() throws Exception {
		int result = boardMapper.deleteAll();
		return result;
	}

	@Override
	public int deleteByIdNBno(Integer bno, String writer) throws Exception {

		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		log.info("userDetails = {}", userDetails);
		log.info("userDetails.getUser().getProviderId() = {}", userDetails.getUser().getProviderId());

		if (userDetails.getUser().getProviderId() != null) {
			writer = userDetails.getUser().getProvider() + "_" + userDetails.getUser().getProviderId();
			log.info("writer = {}", writer);
		}

		int result = boardMapper.deleteByIdNBno(bno, writer);
		return result;
	}

	@Override
	public List<BoardDTO> getSearchSelectPage(SearchCondition sc) {
		return this.boardMapper.getSearchSelectPage(sc);
	}

	@Override
	public int getSearchResultCount(SearchCondition sc) {
		return this.boardMapper.getSearchResultCount(sc);
	}

}
