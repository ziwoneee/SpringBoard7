package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

/*root-context.xml에서 설정한 DB연결정보 테스트 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {
	
	//mylog
	private static final Logger logger 
		  = LoggerFactory.getLogger(BoardDAOTest.class);

	@Inject
	private DataSource ds;
	
	@Inject
	private BoardDAO bDAo;
	
	//@Test
	public void 디비연결_테스트() throws Exception {
		logger.info(" @@@@@@ ds : " + ds);
		logger.info(" @@@@@@ conn : " + ds.getConnection());
	}
	
	//@Test
	public void 글쓰기_테스트() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트글 1");
		vo.setWriter("관리자");
		vo.setContent("테스트 글입니다!");
		
		bDAo.boardInsert(vo);
	}
	
	// 게시판 리스트 (all) 동작테스트
	//@Test
	public void 게시판리스트_테스트() throws Exception {
		
		logger.info(" 게시판리스트_테스트() 실행 ");
		List<BoardVO> boardList 
			= bDAo.boardListSelect();
		
		logger.info("{}", boardList);
	}
	
	@Test
	public void 게시판리스트_페이징처리_테스트() throws Exception {
		
		// List boardList = bDAo.boardListPageSelect(0);
		
		// int page = 1;
		// List boardList = bDAo.boardListPageSelect(page);
		
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPageSize(10);
		
		List boardList = bDAo.boardListCriSelect(cri);
		
		logger.info(" boardList : " + boardList.size());
		logger.info("" + boardList);
	}
	
	//@Test
	public void 게시판본문보기_테스트() throws Exception{
		logger.info(" 게시판본문보기_테스트() 실행 ");
		
		int bno = 10;
		bDAo.boardSelect(bno);
		
	}
	
	//@Test
	public void 조회수1증가_테스트() throws Exception {
		int bno = 2;
		bDAo.viewcntUpdate(bno);
	}
	
	
	// @Test
	public void 수정테스트() throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setBno(1);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("수정된 이름");
		
		bDAo.boardUpdate(vo);
	}
	
	@Test
	public void 삭제테스트() throws Exception {
		
		bDAo.boardDelete(12);
	}
	
	
	
	
}








