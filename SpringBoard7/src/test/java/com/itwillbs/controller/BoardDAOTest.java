package com.itwillbs.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	@Test
	public void 디비연결_테스트() throws Exception {
		logger.info(" @@@@@@ ds : " + ds);
		logger.info(" @@@@@@ conn : " + ds.getConnection());
	}
	
}








