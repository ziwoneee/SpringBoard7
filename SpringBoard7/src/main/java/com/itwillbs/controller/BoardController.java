package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

// @RequestMapping(value = "/board/*")
// => 실행하는 주소가 /board/~ 시작하는 모든 주소를
//    해당컨트롤러가 처리하겠다 

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	//mylog
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 서비스 객체를 주입
	@Inject
	private BoardService bService;
	
	// 기능을 정의
	
	// http://localhost:8088/controller/board/regist (x)
	// http://localhost:8088/board/regist (o)
	
	// 글쓰기 (정보 입력) / GET
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void boardRegistGET() throws Exception {
		logger.info(" boardRegistGET() 실행 ");
		logger.info(" /views/board/regist.jsp 페이지 이동 ");
	}
	
	// 글쓰기 (정보 처리) / POST
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String boardRegistPOST(/* @ModelAttribute */ BoardVO vo,
									RedirectAttributes rttr) throws Exception {
		logger.info(" boardRegistPOST() 실행 ");
		
		// 글쓰기 동작을 처리
		
		// 한글처리 인코딩 => web.xml 필터설정
		// 1) 전달정보(파라메터)를 저장 / 제목, 내용, 이름
		logger.info(" vo : {}", vo);

		// 2) 서비스기능 -> DAO기능 -> DB에 저장
		bService.boardRegist(vo);
		
		// 3) 페이지 이동(게시판 리스트)
		
		rttr.addFlashAttribute("result", "createOK");
		
		// return "redirect:/board/listALL?data=1234";
		// model.addAttribute("data", "1234");
		// => 두 개의 동작이 동일함 (주소줄로 전달, 계속해서 정보가 남아있음)
		
		return "redirect:/board/listALL";
	}
	
	// http://localhost:8088/board/listALL
	// 게시판 리스트 (ALL)
	@RequestMapping(value = "/listALL", method = RequestMethod.GET)
	public void boardListAllGET(Model model) throws Exception {
		logger.info(" boardListAllGET() 실행 ");
		
		// 서비스 -> DAO 호출 -> DB 조회
		List<BoardVO> boardList = bService.boardListAll();
		
		// 컨트롤러 -> 뷰페이지로 전달 (Model)
		model.addAttribute("boardList", boardList);
		
		logger.info(" /views/board/listALL.jsp 페이지 연결");
	}
	
	
	
	
	
} // BoardController













