package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

/**
 * 	BoardDAOImpl: BoardDAO 인터페이스를 구현한 객체
 * 				  SQL 호출 동작을 실행S
 * @Repository : 외부에서 해당 객체를 DAO로 등록
 */

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	// mylog
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비연결 & mybatis 관련 정보를 처리하는 객체
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="com.itwillbs.mapper.BoardMapper.";
	
	@Override
	public void boardInsert(BoardVO vo) throws Exception {
		// 게시판 글 입력하는 SQL 구문을 실행
		// 디비연결
		// SQL 구문 & pstmt 객체
		// SQL 실행
		sqlSession.insert(NAMESPACE + "insertBoard", vo);
		logger.info(" SQL 실행 완료! ");
		logger.info(" 게시판 글쓰기 완료! ");
	}

	// 게시판 리스트(all)
	@Override
	public List<BoardVO> boardListSelect() throws Exception {
		logger.info(" boardListSelect() 실행 ");
		// SQL 구문 실행 & 결과리턴
		List<BoardVO> boardList = 
			sqlSession.selectList(NAMESPACE + "listALL");
		
		// logger.info(" size : " + boardList);
		logger.info(" size : " + boardList.size());
		
		return boardList;
	}
	
	
	
	

}










