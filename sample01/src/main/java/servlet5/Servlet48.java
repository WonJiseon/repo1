/* 주제: 세션 무효화시키기
 * => 세션을 무효화시키면 해당 아이디의 세션 객체가 삭제된다.
 */
package servlet5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet48")
public class Servlet48 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session= request.getSession();
    session.invalidate(); // 세션 무효화!
    session = request.getSession(); // 새 세션 객체를 리턴한다.
    
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("세선아이디 = %s\n", session.getId());
    out.printf("name=%s\n", session.getAttribute("name"));
    out.printf("gender=%s\n", session.getAttribute("gender"));
    out.printf("age=%s\n", session.getAttribute("age"));
    out.printf("date=%s\n", session.getAttribute("date"));
}
  
 
}

