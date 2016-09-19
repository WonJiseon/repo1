<%@page import="vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


   
<%-- <jsp:useBean>의 type과 class 속성 동시 사용
=> type은 레퍼런스 변수 만들 때 사용.
   - 인터페이스나 추상 클래스를 지정할 수 있다.
=> class는 객체 생성할 때 사용.
   - 따라서 인터페이스 및 추상 클래스를 지정할 수 없다.
   - 이 속성에서는 제네릭을 사용할 수 없다.
--%>

<jsp:useBean id="list" 
             type="java.util.List<String>"
             class="java.util.ArrayList" scope="request"></jsp:useBean>
<%-- 자바 코드:
java.util.List list = (java.util.List)request.getAttribute("list");
if (list == null) {
  list = new java.
}
--%>

ServletRequest: <%=request.getAttribute("list")%>

