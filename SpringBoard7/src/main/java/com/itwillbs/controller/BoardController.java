package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void boardListAllGET(Model model,
								HttpSession session) throws Exception {
		logger.info(" boardListAllGET() 실행 ");
		
		// 서비스 -> DAO 호출 -> DB 조회
		List<BoardVO> boardList = bService.boardListAll();
		
		// 세션사용해서 정보를 저장
		session.setAttribute("updateCheck", true);
		
		// 컨트롤러 -> 뷰페이지로 전달 (Model)
		model.addAttribute("boardList", boardList);
		
		logger.info(" /views/board/listALL.jsp 페이지 연결");
	}
	
	// http://localhost:8088/board/read?bno=8
	// 게시판 본문보기 /board/read		GET
	// @RequestMapping(value = "/read", method = RequestMethod.GET)
	@GetMapping(value = "/read")
	public void boardReadGET(@RequestParam("bno") int bno,
							 Model model,
							 HttpSession session) throws Exception {
		logger.info(" boardReadGET() 실행");
		
		logger.info(" bno : {}", bno);
		
		boolean updateCheck = (boolean) session.getAttribute("updateCheck");
		
		if(updateCheck) {
			// 서비스 -> DAO 특정 글의 조회수를 1 증가 
			bService.increaseViewcnt(bno);
			session.setAttribute("updateCheck", false);
			
		}
		
		
		
		// 특정 글정보를 DB에서 가져와서 view 페이지에 출력
		// 서비스 -> DAO 특정 글정보 가져오기
		BoardVO resultVO = bService.getBoard(bno);
		logger.info(" resultVO : {} ", resultVO);
		
		// Model 객체 사용
		model.addAttribute(resultVO); 
		// 전달하는 타입의 클래스명을 첫글자 소문자로 바꿔서 이름으로 사용
		// model.addAttribute("resultVO", resultVO);
		
		// 연결된 뷰페이지에 /board/read.jsp 출력
		logger.info(" /board/read.jsp 페이지 연결 ");
		
		
	}
	
	// http://localhost:8088/board/modify?bno=13
	// 게시판 수정하기 GET
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void boardModifyGET(@ModelAttribute("bno") int bno,
								Model model) throws Exception {
		logger.info(" boardModifyGET() 실행 ");
		// 전달된 정보(파라메터)를 저장
		logger.info(" bno : {}", bno);
		
		// 기존에 작성된 글의 내용을 확인하는 동작
		
		// 서비스 -> DAO 호출 글 정보를 가져오기
		//BoardVO resultVO = bService.getBoard(bno);
		//model.addAttribute(resultVO);
		
		model.addAttribute(bService.getBoard(bno));
		
		// 연결된 뷰페이지에 출력(/board/modify.jsp
	}
	
	// 게시판 수정하기 POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String boardModifyPOST(BoardVO vo,
								RedirectAttributes rttr) throws Exception {
		logger.info(" boardModifyPOST() 실행 ");
		
		// 수정할 정보(전달된 데이터, 파라메터) 저장
		logger.info(" vo : {}", vo);
		
		// 서비스 -> DB에 정보 호출
		bService.modifyBoard(vo);
		logger.info(" 게시판 글 수정 완료! ");
		
		// 리스트에 수정 완료했다는 정보를 전달해서
		// 화면에 alert 출력
		
		rttr.addFlashAttribute("result", "modifyOK");

		// 페이지 이동
		
		return "redirect:/board/listALL";
	}
	
	// http://localhost:8088/board/remove (POST)
	// 게시판 삭제하기 POST
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String boardRemovePOST(@ModelAttribute("bno") int bno,
								 RedirectAttributes rttr) throws Exception {
		logger.info(" boardRemovePOST() 실행 ");
		
		// 수정할 정보(전달된 데이터, 파라메터) 저장
		logger.info(" bno : {}" + bno);
		
		// 서비스 -> DB에 정보 호출
		bService.removeBoard(bno);
		logger.info(" 게시판 글 삭제 완료! ");
		
		// 리스트에 수정 완료했다는 정보를 전달해서
		// 화면에 alert 출력
		
		rttr.addFlashAttribute("result", "deleteOK");

		// 페이지 이동
		
		return "redirect:/board/listALL";
	}
	
	
	
	
	
} // BoardController













