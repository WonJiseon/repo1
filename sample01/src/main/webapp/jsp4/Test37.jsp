<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

[c:url]
- url을 쉽게 만들기


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
https://search.naver.com/search.naver?where=nexearch&query=java&sm=top_hty&fbm=1&ie=utf8 
--%>
<c:url var="testUrl" value="http://search.naver.com/search.naver">
  <c:param name="where" value="nexearch"/>
  <c:param name="query" value="java"/>
  <c:param name="sm" value="top_hty"/>
  <c:param name="fbm" value="1"/>
  <c:param name="ie" value="utf8"/>
</c:url>

${testUrl}