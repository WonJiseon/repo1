<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

[c:forEach]
- 반복문 표현

[Map 객체와 반복문]
<% // 테스트 용 데이터 준비
HashMap<String,String> nameMap = new HashMap<String,String>();
nameMap.put("n1", "홍길동");
nameMap.put("n2", "윤봉길");
nameMap.put("n3", "임꺽정");
nameMap.put("n4", "신채호");

pageContext.setAttribute("nameMap",  nameMap);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${nameMap}" var="keyValue">
${keyValue},
</c:forEach>
