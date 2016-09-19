
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


   
<%-- EL 리터럴(literal) 표현식
=> EL에서 값 표기법
--%>

문자열: ${"홍길동"}
문자열: ${'홍길동'}
숫자:   ${20}
숫자:   ${3.14}
참거짓: ${true}, ${false}
null:   ${null} (null은 빈 문자열을 리턴한다.)