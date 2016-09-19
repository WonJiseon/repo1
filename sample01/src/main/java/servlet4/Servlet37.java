/* 주제: 쿠키를 사용할 수 있는 범위(URL)을 지정하기
 * => 쿠키의 사용 범위를 지정하게 되면,
 *    웹 브라우저가 서버에 요청할 때 그 요청 범위에 해당되는 쿠키만 보낸다.
 * => 범위는 URL의 경로이다.
 */
package servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/servlet37")
public class Servlet37 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1) 쿠키를 만든다.
    Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
    // 쿠키의 사용 범위를 지정하지 않으면 쿠키를 보내는 서블릿의 경로가된다.
    
    Cookie c2 = new Cookie("email", "test@test.com");
    c2.setPath("/web01/test"); // 쿠키의 사용 범위를 지정한다.
    // 사용 범위를 지정할 때는 웹 애플리케이션 루트(컨텍스트 루트)가 아닌
    // 웹 서버 루트를 기준으로 경로를 지정해야 한다.
    
    Cookie c3 = new Cookie("age", "20");
    c3.setPath("/web01/test2"); // 쿠키의 사용 범위를 지정한다.
    
    //2) 쿠키를 응답 헤더에 싣는다.
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
/* 예)
Set-Cookie:name=%ED%99%8D%EA%B8%B8%EB%8F%99
Set-Cookie:email="test@test.com"; Version=1; Path=/web01/test
Set-Cookie:age=20; Path=/web01/test2
 */
    
    
    //3) 간단한 응답
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("웹 브라우저로 쿠키를 보냈습니다 HTTP 응답을 확인하세요.");
    
  }
}

/* URL 인코딩의 의미
 * URLEncoder.encode("홍길동", "UTF-8");
 * => "홍길동" (2바이트 유니코드) ---> UTF-8 코드(2~4바이트) ---> ASCII 코드 
*/