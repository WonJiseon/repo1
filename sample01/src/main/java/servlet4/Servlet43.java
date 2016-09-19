/* 주제: 쿠키 값 꺼내기
 * => 유효기간이 지난 쿠키는 웹 브라우저가 보내지 않는다.
 *    물론 웹 브라우저는 유효기간이 지난 쿠키를 임시 저장 폴더에서 제거할 것이다.
 */
package servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/servlet43")
public class Servlet43 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie[] cookies = request.getCookies();
    
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("클라이언트가 보낸 쿠키들:");
    
    if (cookies == null) 
      return;
    for (Cookie cookie : cookies) {
      out.printf("%s = %s\n", cookie.getName(), URLDecoder.decode(cookie.getValue(), "UTF-8"));
    }
  }
}

/* URL 디코딩
 * => URLDecoder.decode(cookie.getValue(), "UTF-8");
 * => cookie.getValue()의 리턴 값을 "URL 디코딩"한다.
 *    디코딩한 값이 UTF-8이라는 뜻이다.
 * => 디코딩된 UTF-8 코드 값을 자바에서 사용할 수 있도록 2바이트 유니코드로 변환하여 리턴한다.
 */ 
