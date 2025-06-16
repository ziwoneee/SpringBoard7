<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ include file = "../include/header.jsp" %>
	
	<div class="content">
		<h1>/board/listALL.jsp</h1>
		
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
                  <td>${vo.title }</td>
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









	<%@ include file = "../include/footer.jsp" %>
<!-- 템플릿 푸터 추가 -->
