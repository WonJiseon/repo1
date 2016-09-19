/* 주제: 세션 생성하기
 * => request.getSession() 메서드를 호출하여 세션을 준비한다.
 * => 세션 준비 절차: 웹브라우저에서 쿠키를 이용하여 세션 아이디를 보냈는가?
       1. 웹 브라우저가 보낸 요청 헤더에 세션 아이디에 해당하는 쿠기가 있다면, 해당 아이디 세션 객체를 찾는다.
 *        1.1 세션이 유요하다면(타임아웃 되지 않았다면), 해당 세션 객체를 리턴한다.
          1.2 세션이 유효하지 않다면(타임아웃 되거나, 무효화되었다면), [2번]으로 간다.

       2. 웹 브라우저가 보낸 요청 헤더에 세션 아이디에 해당하는 쿠키가 없다면, 새로운 세션 객체를 만든다.
          2.1 응답할 때 새로 만든 서버가 보낸 세션 아이디를 임시로 저장한다.
          2.2 웹 브라우저는 서버가 보낸 세션 아이디를 임시로 저장한다.
              2.2.1 즉 실행되는 동안만 보관한다.
              2.2.2 웹 브라우저를 종료(모든 웹 브라우저 종료)하면 임시 쿠키가 삭제되기 때문에
                    세션 아이디로 삭제된다.
 *      
 */
package servlet5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet44")
public class Servlet44 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session= request.getSession();
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("세선아이디 = %s\n", session.getId());
}
  
 
}

/* 새로 세션을 만들 때?
 * => 쿠키를 이용하여 세션 아이디를 클라이언트로 보낸다.
 * => 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Set-Cookie: JSESSIONID=C236826CED98E3B6729BE2D6A7DC76AB; Path=/web01/; HttpOnly
Content-Type: text/plain;charset=UTF-8
Content-Length: 50
Date: Wed, 31 Aug 2016 06:13:07 GMT
 */ 
