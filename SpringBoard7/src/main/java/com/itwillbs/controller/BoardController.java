package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @RequestMapping(value = "/board/*")
// => 실행하는 주소가 /board/~ 시작하는 모든 주소를
//    해당컨트롤러가 처리하겠다 

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	//mylog
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	// 기능을 정의
	
	// http://localhost:8088/controller/board/regist (x)
	// http://localhost:8088/board/regist (o)
	
	// 글쓰기 (정보 입력) / GET
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void boardRegistGET() {
		logger.info(" boardRegistGET() 실행 ");
		logger.info(" /views/board/regist.jsp 페이지 이동 ");
	}
	
	// 글쓰기 (정보 처리) / POST

	
	
	
	
	
	
	
} // BoardController













