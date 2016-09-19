<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


[관계 연산자 사용하기]
(* 달러 기호 앞에 역슬래시가 붙으면 EL 명령으로 해석하지 않는다.)
\${10 == 11} : ${10 == 11}
\${10 eq 11} : ${10 eq 11}
\${10 != 11} : ${10 != 11}
\${10 ne 11} : ${10 ne 11}
\${10 < 11} : ${10 < 11}
\${10 lt 11} : ${10 lt 11}
\${10 <= 11} : ${10 <= 11}
\${10 le 11} : ${10 le 11}
\${10 > 11} : ${10 > 11}
\${10 gt 11} : ${10 gt 11}
\${10 >= 11} : ${10 >= 11}
\${10 ge 11} : ${10 ge 11}