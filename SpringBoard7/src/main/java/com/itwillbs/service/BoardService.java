package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

/**
 *   BoardService - 게시판에서 수행하는 동작을 정의 
 *
 */
public interface BoardService {
	
	// 게시판 글쓰기 
	public void boardRegist(BoardVO vo) throws Exception;
	
	// 게시판 리스트(all)
	public List<BoardVO> boardListAll() throws Exception;
	// 게시판 리스트(cri)
	public List<BoardVO> boardListCri(Criteria cri) throws Exception;
	
	
	
	// 게시판 본문보기
	public BoardVO getBoard(int bno) throws Exception;
	
	// 게시판 글 조회수 1증가
	public void increaseViewcnt(int bno) throws Exception;
	
	// 게시판 글 수정하기
	public void modifyBoard(BoardVO vo) throws Exception;
	
	// 게시판 글 삭제하기
	public int removeBoard(int bno) throws Exception;
	
	// 게시판 글 개수 조회
	public int getTotalCount() throws Exception;
	
	

}