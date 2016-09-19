<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<%-- request/session/application 저장소 확인--%>

<jsp:useBean id="board" class="vo.Board" scope="pageContext"></jsp:useBean>

board: <%=board%>
JspContext: <%=pageContext.getAttribute("board", PageContext.PAGE_SCOPE)%>
ServletRequest: <%=request.getAttribute("board")%>
HttpSession: <%=session.getAttribute("board")%>
ServletContext: <%=application.getAttribute("board")%>
