<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

[c:import]
- HTTP 요청을 수행하는 방법


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
https://search.naver.com/search.naver?where=nexearch&query=java&sm=top_hty&fbm=1&ie=utf8 
--%>
<c:url var="testUrl" value="https://search.naver.com/search.naver">
  <c:param name="where" value="nexearch"/>
  <c:param name="query" value="java"/>
  <c:param name="sm" value="top_hty"/>
  <c:param name="fbm" value="1"/>
  <c:param name="ie" value="utf8"/>
</c:url>

<%-- url로 지정된 서버에 요청한 후 서버로부터 받은 결과를 "contents"라는 이름으로 저장한다. --%>
<c:import url="${testUrl}"/>
