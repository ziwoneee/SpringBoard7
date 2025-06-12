package com.itwillbs.service;

import com.itwillbs.domain.BoardVO;

/**
 *	 BoardService - 게시판에서 수행하는 동작을 정의
 *
 */

public interface BoardService {

	// 게시판 글쓰기
	public void boardRegist(BoardVO vo) throws Exception;
	
}
