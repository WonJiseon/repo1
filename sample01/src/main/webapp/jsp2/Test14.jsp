<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


   
<%-- <jsp:include>
=> RequestDispatcher의 include()코드를 생성한다.
=> 자바 코드:
RequestDispatcher rd = request.getRequestDispatcher("a.jsp");
rd.forward(request, response);
--%>

하하
<jsp:forward page="header.jsp"/>
내용
<jsp:forward page="footer.jsp"/>
호호
