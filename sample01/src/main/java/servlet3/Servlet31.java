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

@WebServlet("/servlet31")
public class Servlet31 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1) ServletContext 보관소에 저장된 값을 꺼낸다.
    ServletContext servletContext = this.getServletContext();
    String a1 = (String)servletContext.getAttribute("a1");
    
    //2) ServletRequest 보관소에 저장된 값을 꺼낸다.
    String r1 = (String)request.getAttribute("r1");
    
    //보관소에 저장되었던 값을 출력해보자!
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("a1=%s\n", a1);
    out.printf("r1=%s\n", r1);
  }
}


