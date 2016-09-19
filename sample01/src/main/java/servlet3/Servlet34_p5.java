/* 주제: HttpSession 보관소를 이용하여 클라이언트 별 데이터 관리
 */
package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet34/p5")
public class Servlet34_p5 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>p1</title></head>");
    out.println("<body>");
    out.printf("이름 = %s<br>\n", session.getAttribute("name"));
    out.printf("나이 = %s<br>\n", session.getAttribute("age"));
    out.printf("이메일 = %s<br>\n", session.getAttribute("email"));
    out.println("</body></html>");
  }
}


