<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file = "../include/header.jsp" %>
	
	<div class="content">
		<h1>/board/listALL.jsp</h1>
	
	<%-- ${boardList } --%>
	<%-- ${result } --%>
	<%-- ${updateCheck } --%>
		
	<div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">아이티윌 게시판</h3>
            </div>
            
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
                <tbody><tr>
                  <th style="width: 30px">bno</th>
                  <th>title</th>
                  <th>writer</th>
                  <th style="width: 40px">viewcnt</th>
                </tr>
			
			<c:forEach var="vo" items="${boardList }">
                <tr>
                  <td>${vo.bno }</td>
                  <td>
                  	<a href="http://localhost:8088/board/read?bno=${vo.bno}">
                  		${vo.title }
                  	</a>		
           		  </td>
                  <td>${vo.writer }</td>
                  <td><span class="badge bg-yellow">${vo.viewcnt }</span></td>
                </tr>
           	</c:forEach>
           	
              </tbody></table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-right">
                <li><a href="#">«</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">»</a></li>
              </ul>
            </div>
          </div>


	</div>


	<script>
	 	// jsp(java) -> JSTL/EL -> HTML -> JavaScript 순서 실행
	 	
		// el표현식의 값을 사용가능한가? yes
				
		// 사용자가 글쓰기를 한 경우	' 글쓰기 완료! ' 메세지(alert)출력
		
		// alert("${result}");		
		var result = "${result}"
		
		if(result == "createOK") {
			alert(" 글쓰기 완료! ");
		} else {
			
		}
	 	
	 	
	 	
	 	
	 	
	 	
	</script>







<%@ include file = "../include/footer.jsp" %>
