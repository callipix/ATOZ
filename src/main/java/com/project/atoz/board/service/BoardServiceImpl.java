package com.project.atoz.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.atoz.board.mapper.BoardMapper;
import com.project.atoz.dto.BoardDTO;
import com.project.atoz.dto.FilesDTO;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.fileupload.mapper.FileMapper;
import com.project.atoz.utiles.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;
	private final FileMapper fileMapper;

	@Override
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> getBoardList = boardMapper.getBoardList();
		return getBoardList;
	}

	@Override
	public BoardDTO getBoardByBno(int bno) {
		BoardDTO boardDTO = boardMapper.getBoardByBno(bno);
		boardMapper.increaseViewCount(bno);
		return boardDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int insertBoard(BoardDTO board, List<String> afterList) throws Exception {
		log.info("여기까지는 오나?");
		board.setContent(StringUtils.escapeDollorSign(board.getContent()));
		int result = 0;

		if (afterList == null || afterList.isEmpty()) {
			return boardMapper.insertBoard(board);
		}

		List<Integer> fileNoList = new ArrayList<>();
		for (String fileKeyList : afterList) {
			fileNoList.add(this.fileMapper.getFileNoKey(fileKeyList));
		}
		result += boardMapper.insertBoard(board);
		// 최근에 작업했던(auto_increment값 가져오기)
		int selectKey = this.fileMapper.getSelectKey();
		log.info("selectKey = {}", selectKey);

		for (Integer fileNo : fileNoList) {
			FilesDTO filesDTO = new FilesDTO();
			filesDTO.setFile_no(fileNo);
			filesDTO.setPost_no(selectKey);
			filesDTO.setCategory_no(board.getCategoryNo());
			result += this.fileMapper.updateFileInfo(filesDTO);
		}
		return result;
		// result += boardMapper.insertBoard(board);
		// return result;
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

		log.info("bno = {}", bno);
		log.info("writer = {}", writer);
		Map<String, Object> deleteInfo = new HashMap<>();
		deleteInfo.put("bno", bno);
		deleteInfo.put("writer", writer);
		int result = boardMapper.deleteByIdNBno(deleteInfo);
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
