
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


   
<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>

<%-- 테스트용 객체 준비 --%>
<%
ArrayList<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("임꺽정");
names.add("유관순");
names.add("안중근");
pageContext.setAttribute("names", names);
%>

[List 객체에서 값 꺼내기]
(* 달러 기호 앞에 역슬래시가 붙으면 EL 명령으로 해석하지 않는다.)
\${names} : ${names}
\${names[1]} : ${names[1]}
