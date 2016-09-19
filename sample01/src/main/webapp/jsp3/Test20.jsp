
<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


   
<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>

<%-- 테스트용 객체 준비 --%>
<%
HashMap<String, String> nameMap = new HashMap<String,String>();
nameMap.put("s01", "홍길동");
nameMap.put("s02", "임꺽정");
nameMap.put("s03", "유관순");
nameMap.put("s04", "안중근");
nameMap.put("s-5", "윤봉길");
pageContext.setAttribute("nameMap", nameMap);
%>

[Map 객체에서 값 꺼내기]
(* 달러 기호 앞에 역슬래시가 붙으면 EL 명령으로 해석하지 않는다.)
\${nameMap["s01"]} : ${nameMap["s01"]}
\${nameMap['s02']} : ${nameMap['s02']}
\${nameMap.s03} : ${nameMap.s03}
\${nameMap["s-5"]} : ${nameMap["s-5"]}
