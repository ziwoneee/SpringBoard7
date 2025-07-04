package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

/**
 *		BoardDAOImpl: BoardDAO 인터페이스를 구현한 객체
 *					 SQL 호출 동작을 실행 
 * @Repository : 외부에서 해당객체를 DAO로 등록
 */

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	//mylog
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비연결 & mybatis 관련정보를 처리하는 객체를 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE 
	         ="com.itwillbs.mapper.BoardMapper.";
	
	
	@Override
	public void boardInsert(BoardVO vo) throws Exception {
		// 게시판 글 입력하는 SQL구문을 실행
		// 디비연결
		// SQL 구문 & pstmt 객체
		// SQL 실행
		sqlSession.insert(NAMESPACE + "insertBoard" , vo);
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
		
		//logger.info(" size : "+ boardList);
		logger.info(" size : "+ boardList.size());
		
		return boardList;
	}


	@Override
	public BoardVO boardSelect(int bno) throws Exception {
		logger.info(" boardSelect(int bno)실행 ");
				
		BoardVO resultVO 
		  = sqlSession.selectOne(NAMESPACE + "getBoard",bno);
		logger.info(" 결과 : {}",resultVO);
		
		return resultVO;
	}


	@Override
	public void viewcntUpdate(int bno) throws Exception {
		logger.info(" viewcntUpdate(int bno) 실행 ");
		sqlSession.update(NAMESPACE + "increaseViewcnt",bno);
	}

	// 게시판 수정하기
	@Override
	public void boardUpdate(BoardVO vo) throws Exception {
		logger.info(" 게시판 글 수정하기 ");
		
		// sql 구문 호출
		sqlSession.update(NAMESPACE +"updateBoard",vo);
		
		logger.info(" 게시판 글 수정 완료! ");
	}


	@Override
	public int boardDelete(int bno) throws Exception {
		logger.info(" boardDelete(int bno) 실행 ");
		
		// 정상처리 1, 비정상 처리 0		
//		int result = sqlSession.delete(NAMESPACE + "deleteBoard",bno);
//		return result;
		
		return sqlSession.delete(NAMESPACE + "deleteBoard",bno);
	}


	@Override
	public List<BoardVO> boardListPageSelect(int page) throws Exception {
		logger.info(" boardListPageSelect() 호출 ");
		
		// 전달받은 페이지 정보를 조회할때 사용할 인덱스로 전환
		// 1페이지 -> index : 0
		// 2페이지 -> index : 10
		// 3페이지 -> index : 20
		if(page <= 0) { 
			page = 1;
		}
		page = (page - 1) * 10;
		
		return sqlSession.selectList(NAMESPACE + "listPage",page);
	}


	@Override
	public List<BoardVO> boardListCriSelect(Criteria cri) throws Exception {
		logger.info(" boardListCriSelect(Criteria cri) 호출 ");
		
		// 전달받은 페이지 정보를 조회할때 사용할 인덱스로 전환
		// 1페이지 -> index : 0
		// 2페이지 -> index : 10
		// 3페이지 -> index : 20
		
		// #{pageStart},#{pageSize} 매개변수 필요
		return sqlSession.selectList(NAMESPACE + "listCri", cri);
	}


	@Override
	public int totalCountSelect() throws Exception {
		logger.info(" totalCountSelect() 호출 ");
		
		int cnt = sqlSession.selectOne(NAMESPACE + "selectTotalCount");		
		return cnt;
		
		//return sqlSession.selectOne(NAMESPACE + "selectTotalCount");
		
	}
	
	
	
	

}