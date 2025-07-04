<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ include file="../include/header.jsp" %>

	<div class="content"> 
		<h1>/board/listCri.jsp</h1>
	
		${pageVO }
		<%-- ${boardList } --%>
		<%--  ${result } --%>
<%-- 		${updateCheck } --%>
		<div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">아이티윌 게시판</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
                <tbody><tr>
                  <th style="width: 10px">bno</th>
                  <th>title</th>
                  <th>writer</th>
                  <th style="width: 40px">viewcnt</th>
                </tr>
                
                <c:forEach var="vo" items="${boardList }">
	                <tr>
	                  <td>${vo.bno }</td>
	                  <td>
	                  	<a href="/board/read?bno=${vo.bno }&page=${pageVO.cri.page}&pageSize=${pageVO.cri.pageSize}">${vo.title }</a>
	                  </td>
	                  <td>${vo.writer }</td>
	                  <td>
	                 	<span class="badge bg-red">
	                 		${vo.viewcnt }
	                 	</span>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody></table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-right">
              
                <c:if test="${pageVO.prev }">
                	<!-- 이전 블럭 -->
	                <li><a href="/board/listCri?page=${pageVO.startPage - 1 }">«</a></li>
                </c:if>
                
                <c:forEach var="idx" begin="${pageVO.startPage }" end="${pageVO.endPage }"  step="1">
                	<li class="${pageVO.cri.page == idx?  'active':'' }">
                		<a href="/board/listCri?page=${idx }">${idx }</a>
                	</li>
                </c:forEach>
                
                <c:if test="${pageVO.next && pageVO.endPage > 0 }">
                	<!-- 다음블럭 -->
	                <li><a href="/board/listCri?page=${pageVO.endPage+1 }">»</a></li>
                </c:if>
                
              </ul>
            </div>
          </div>
		
	</div>
	
	
	<script>
		// jsp(java) -> JSTL/EL -> HTML -> JavaScript 순서 실행
		
		// el표현식의 값을 사용가능한가? yes
		// 사용자가 글쓰기를 한경우 ' 글쓰기 완료!' 메세지(alert)출력		
	
		// alert("${result }");
		var result = "${result}";
		
		if(result == "createOK"){
			alert(" 글쓰기 완료! ");
		}
		if(result == "modifyOK"){
			alert(" 글 수정 완료! ");
		}
		if(result == "deleteOK"){
			alert(" 글 삭제 완료! ");
		}
		
	</script>
	
	
	
<%@ include file="../include/footer.jsp" %>