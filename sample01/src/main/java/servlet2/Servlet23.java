/* 주제: 오리지널 도우미 클래스(HttpServlet) 사용하기
 * => Java EE에서 제공해주는 HttpServlet 클래스를 상속받아 사용해보자
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet23")
public class Servlet23 extends HttpServlet {
  // HttpServlet에서 추가한 메서드 중에서 POST 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("POST 요청...");

  }
}
