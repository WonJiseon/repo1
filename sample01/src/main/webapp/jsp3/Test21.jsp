<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


[산술 연산자 사용하기]
(* 달러 기호 앞에 역슬래시가 붙으면 EL 명령으로 해석하지 않는다.)
\${10 + 20} : ${10 + 20}
\${10 - 20} : ${10 - 20}
\${10 * 20} : ${10 * 20}
\${10 / 20} : ${10 / 20}
\${10 % 20} : ${10 % 20}
\${10 div 20} : ${10 div 20}
\${10 mod 20} : ${10 mod 20}
