/* 주제: forward와 include
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet29/s1")
public class Servlet29_s1 extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    response.setContentType("text/plain;charset=UTF-8");
    RequestDispatcher rd = request.getRequestDispatcher("/servlet29/header");
    rd.include(request, response);

    try { 
      int a = Integer.parseInt(request.getParameter("a"));
      int b = Integer.parseInt(request.getParameter("b"));
      int result = 0;
      String op = request.getParameter("op");

      switch (op) {
      case "+": result = a + b; break;
      case "-": result = a - b; break;
      case "*": result = a * b; break;
      case "/": result = a / b; break;
      default:
        throw new Exception("지원하지 않는 연산자입니다.");
      }
      
      PrintWriter out = response.getWriter();
      out.printf("%d %s %d = %d\n", a, op, b, result);
    } catch (Exception e) {
      rd = request.getRequestDispatcher("/servlet29/error");
      rd.forward(request, response);
    }
    
    rd = request.getRequestDispatcher("/servlet29/footer");
    rd.include(request, response);
  }
}


