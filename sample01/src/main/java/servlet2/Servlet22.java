/* 주제: HttpGenericServlet2 도우미 클래스 사용하기
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet22")
public class Servlet22 extends HttpGenericServlet2 {
  // HttpGenericServlet2에서 추가한 메서드 중에서 GET 요청에 대해 호출될 메서드를 오버라이딩 하자!
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("GET 요청...");

  }
}
