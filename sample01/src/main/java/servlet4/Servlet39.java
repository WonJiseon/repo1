/* 주제: 쿠키 값 꺼내기 - path = /web01/servlet39
 * => 이 서블릿과 같은 사용 범위를 갖는 쿠키만 꺼낼 수 있다.
 * => servlet37이 만든 쿠키는 다음과 같다.
 *    name=xxx  ---> /web01/test (사용 범위를 지정하지 않았기 때문에 servlet37의 경로와 같다.
 *    email=xxx ---> /web01/test
 *    age=xxx   ---> /web01/test2
 * => 이 서블릿의 경로는 /web01/test 이기 때문에
 *    servlet37이 보관한 쿠키들 중에서 name과 email을 받을 수 있다.
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

@WebServlet("/test/servlet39")
public class Servlet39 extends HttpServlet {
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
