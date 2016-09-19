<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
템플릿데이터1
템플릿데이터2
<%
String name = "홍길동";
%>
템플릿데이터3
<%= name %>
템플릿데이터4
템플리데이터5

<%-- 표현식(expression element)
=> <%= expression %>
=> expression? 값을 리턴하는 자바 코드
=> 예)
    <%= plus(20, 10) %>
    <%= name %>
    <%= 20 + 2 %>

=> JSP 엔진이 하는 일
<%= expression %>  ------> out.print(expression);
태그 안에 작성한 자바 코드는 그대로 출력문의 파라미터 영역에 복사된다.

[예1]
<%= name %>
===============================================================================
out.print(name);

[예2]
<%= plus(20, 10) %>
===============================================================================
out.print( plus(20, 10) );

[잘못 사용한 예1]
<%= if (...) {} %>
===============================================================================
out.print( if (...) {} );

[잘못 사용한 예2]
<%= 20 + 30; %>
===============================================================================
out.print( 20 + 30; );

--%>