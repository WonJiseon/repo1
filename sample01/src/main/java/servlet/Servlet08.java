/* 주제: HttpServlet 추상 클래스를 상속 받아 서블릿 구현하기
 * - Servlet (인터페이스)
 *      <-- GenericServlet (추상 클래스)
 *                 <-- HttpServlet (추상 클래스)
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet08")
public class Servlet08 extends HttpServlet {
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("Hello*^^*");
  }
 
}
