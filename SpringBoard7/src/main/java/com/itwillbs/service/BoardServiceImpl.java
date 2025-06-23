package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

/**
 * BoardServiceImpl : BoardService 인터페이스를 구현(상속)해서 만든 객체 
 * 
 * 객체를 직접 구현 X => 주입해서 사용 ( 약한결합의 객채 관계일 때 )
 *  @Service 객체를 root-context.xml에서 불러올 때 서비스 객체로 인식
 *  
 * 컨트롤러의 요청을 받아서 DAO메서드를 호출
 * 
 */

@Service
public class BoardServiceImpl implements BoardService {

	// mylog
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	// BoardDAO 객체 필요 => 객체를 주입받아서 사용
	@Inject
	private BoardDAO bDao;
	
	// alt + shift s + v 오버라이딩 메서드 구현
	@Override
	public void boardRegist(BoardVO vo) throws Exception {
		// DAO에 글쓰기 기능을 호출
		bDao.boardInsert(vo);;
		logger.info(" 글쓰기 서비스 기능 완료 ");
		
	}

	
	@Override
	public List<BoardVO> boardListAll() throws Exception {
		logger.info(" boardListtALL() 실행 ");
		
		List<BoardVO> boardList = bDao.boardListSelect();
		
		logger.info(" 게시판 리스트 조회(all) 기능 호출 완료 ");
		
		return boardList;
		
	}

	// 게시판 본문보기
	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.info(" getBoard(int bno) 실행 ");

		return bDao.boardSelect(bno);
	}


	
	// 게시판 조회수 1증가
	@Override
	public void increaseViewcnt(int bno) throws Exception {
		logger.info(" increaseViewcnt(int bno) 실행 ");
		
		bDao.viewcntUpdate(bno);
		
	}


	// 게시판 수정하기
	@Override
	public void modifyBoard(BoardVO vo) throws Exception {
		logger.info(" modifyBoard(BoardVO vo) 실행 ");
		
		bDao.boardUpdate(vo);
		
		logger.info(" 게시판 수정 완료 ");
	}
	
	
	
	
	
	
	
	
	
	

	
}









