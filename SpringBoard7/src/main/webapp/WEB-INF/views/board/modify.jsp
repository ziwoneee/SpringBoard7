<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 템플릿 헤더 추가 -->
<!-- ./ 상대주소	./WEB-INF/views <=>	/webapp/WEB-INF/views
     ../ 절대주소	상위폴더로 이동
      
      -->
      
	<%@ include file = "../include/header.jsp" %>
	
	<%-- ${boardVO } --%>

	<div class="content">
	<h1> /board/read.jsp </h1>
	
	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title"> 게시판 수정하기 </h3>
            </div>
            <!-- /.box-header -->
            
            <!-- form start -->
            <!-- submit 버튼 클릭시 정보 전달하기위한 폼태그 -->
     		 <form role="form" action="" method="post"> <!-- action, method 속성 생략 -->
      
            
            
            <!-- 제목, 작성자, 내용을 입력받는 폼태그 생성 -->
            <!-- form start -->
            <!-- action="/board/regist" 생략가능
            	 생략시 자기자신의 주소를 호출
             -->
              <div class="box-body">
              
              	 <div class="form-group">
                  <label for="exampleInputEmail1">번  호</label>
                  <input type="text" name="bno" class="form-control" 
                  		 id="exampleInputEmail1" value="${boardVO.bno }"
                  		 readonly="readonly">
                 </div>
              
                 <div class="form-group">
                  <label for="exampleInputEmail1">제  목</label>
                  <input type="text" name="title" class="form-control" 
                  		 id="exampleInputEmail1" value="${boardVO.title }">
                 </div>
                
                 <div class="form-group">
                  <label for="exampleInputEmail1">작성자</label>
                  <input type="text" name="writer" class="form-control" 
                  		 id="exampleInputEmail1" value="${boardVO.writer }">
                 </div>
                
                <div class="form-group">
                  <label>내  용</label>
                  <textarea class="form-control" name="content" rows="3" >${boardVO.content }</textarea>
                </div>
                
    
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary btn-lg">수정하기</button>
                <button type="reset" class="btn btn-danger btn-lg">초기화</button>
              </div>
            
          </div>
          
       </form>

	</div> <!-- .conthent -->
	<%@ include file = "../include/footer.jsp" %>
<!-- 템플릿 푸터 추가 -->
