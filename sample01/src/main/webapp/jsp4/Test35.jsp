<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

[c:forEach]
- 반복문 표현

[콤마로 구분된 문자열과 반복문]
<% // 테스트 용 데이터 준비

pageContext.setAttribute("names", "홍길동,임꺽정,유관순,안중근,윤보길,안창호,신채호");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${names}" var="name">
${name}:
</c:forEach>
