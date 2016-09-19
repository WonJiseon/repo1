<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<%-- 객체를 생성해주는 태그 
id : 객체의 레퍼런스 이름
class : 객체를 생성할 때 사용할 전체 클래스명(패키지명 포함; fully-qualified class name); FQName; QName --%>
<jsp:useBean id="board" class="vo.Board"></jsp:useBean>

<jsp:useBean id="board2" class="vo.Board">
  <%-- 객체가 생성할 때 프로퍼티(setter/getter) 값을 설정할 수 있다.
	  name: 객체 레퍼런스 이름
	  property: 셋터 이름(set을 제외하고 첫 알파벳을 소문자로 한 이름. 즉 프로퍼티명)
	  value: 셋터 메서드를 호출할 때 넘겨줄 값. 문자열을 원시타입으로 자동 변환한다.
  --%>
  <jsp:setProperty name="board2" property="no" value="1" />
  <jsp:setProperty name="board2" property="title" value="하하하" />
  <jsp:setProperty name="board2" property="contents" value="내용입니다." />
  <jsp:setProperty name="board2" property="viewCount" value="100" />
</jsp:useBean>

<jsp:useBean id="board3" class="vo.Board"></jsp:useBean>
  <%-- 객체 생성 태그 이후에 프로퍼티 값 설정 태그를 사용해도 괜찮다.--%>
 <jsp:setProperty name="board3" property="no" value="2" />
 <jsp:setProperty name="board3" property="title" value="하하하2" />
 <jsp:setProperty name="board3" property="contents" value="내용입니다.2" />
 <jsp:setProperty name="board3" property="viewCount" value="200" />


board: <%=board%>
board2: <%=board2%>
board3: <%=board3%>