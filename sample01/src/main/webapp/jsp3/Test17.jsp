
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


   
<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>

<%-- 테스트용 객체 준비 --%>
<jsp:useBean id="board" class="vo.Board" scope="page"/>
<jsp:setProperty name="board" property="no" value="10"/>
<jsp:setProperty name="board" property="title" value="제목입니다."/>
<jsp:setProperty name="board" property="contents" value="내용입니다."/>
<jsp:setProperty name="board" property="viewCount" value="15"/>

(* 달러 기호 앞에 역슬래시가 붙으면 EL 명령으로 해석하지 않는다.)
\${board}: ${board}
\${board.getNo()} : ${board.getNo()}
\${board.no}: ${board.no}
\${board["no"]}: ${board["no"]}
\${board['no']}: ${board['no']}
