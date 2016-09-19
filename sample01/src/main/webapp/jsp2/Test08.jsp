<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<%-- <jsp:useBean>는 실제 
		 PageContext/ServletRequest/HttpSession/ServletContext 저장소에서 객체를 찾는다.
--%>

<jsp:useBean id="board" class="vo.Board"></jsp:useBean>
<%-- 위 태그를 자바코드로 표현:
vo.Board board = null;
if (pageContext.getAttribute("board") != null { // 기본으로 JspContext에서 찾는다.
	board = (vo.Board)pageContext.getAttribute("board");
} else {
	board = new vo.Board();
	pageContext.setAttribute("board", board); // JspContext 저장소에 보관된다.
}
--%>

board: <%=board%>
JspContext: <%=pageContext.getAttribute("board", PageContext.PAGE_SCOPE)%>
board == JspContext: <%=pageContext.getAttribute("board", PageContext.PAGE_SCOPE) == board %> 
ServletRequest: <%=request.getAttribute("board")%>
HttpSession: <%=session.getAttribute("board")%>
ServletContext: <%=application.getAttribute("board")%>
