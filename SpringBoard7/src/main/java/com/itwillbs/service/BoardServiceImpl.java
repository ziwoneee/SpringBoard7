package com.itwillbs.service;

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
	
	// alt + shift s + v 오버라이딩
	@Override
	public void boardRegist(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}









