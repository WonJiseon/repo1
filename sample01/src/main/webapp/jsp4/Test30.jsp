<%@page import="java.util.HashMap"%>
<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

[c:if]
- 조건문
<%-- 
<c:if test="조건식" var="변수명" scope="저장소">
  콘텐츠
</c:if>

테스트 결과(true/false)는 "변수명"으로 저장소에 저장된다.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${10 > 8}" var="result" scope="page">
하하하
</c:if>
테스트 결과: ${result},

<c:if test="${10 < 8}" var="result2" scope="page">
호호호
</c:if>
테스트 결과: ${result2},
