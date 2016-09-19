/* 주제: forward와 include
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

@WebServlet("/servlet33/p5")
public class Servlet33_p5 extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 보관소에 저장된 데이터를 꺼내 출력한다.
    ServletContext sc = request.getServletContext();
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>p1</title></head>");
    out.println("<body>");
    out.printf("이름 = %s<br>\n", sc.getAttribute("name"));
    out.printf("나이 = %s<br>\n", sc.getAttribute("age"));
    out.printf("이메일 = %s<br>\n", sc.getAttribute("email"));
    out.println("</body></html>");
  }
}


