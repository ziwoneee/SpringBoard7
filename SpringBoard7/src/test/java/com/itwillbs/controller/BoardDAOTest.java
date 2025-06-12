package com.itwillbs.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
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
		
		bDAo.boardRegist(vo);
	}
	
}








