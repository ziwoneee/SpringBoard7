package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

/**
 *	BoardDAO : 서비스의 요청을 받아서 SQL 구문을 실행 
 *
 */

public interface BoardDAO {
	
	// 게시판 글쓰기
	//public void boardRegist(BoardVO vo) throws Exception;
	public void boardInsert(BoardVO vo) throws Exception;
	
	// 게시판 리스트(all)
	public List<BoardVO> boardListSelect() throws Exception; 
	
	// 게시판 본문보기
	public BoardVO boardSelect(int bno) throws Exception;
	
	// 게시판 글 조회수 1증가
	public void viewcntUpdate(int bno) throws Exception;
	
	// 게시판 글정보 수정하기
	public void boardUpdate(BoardVO vo) throws Exception;
	
	
	
	
	
	
	
	
	
	
	

}
