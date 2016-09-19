/* 주제:  GET과 POST, HEAD 등의 요청을 구분하여 메서드 호출한다.
 * => HttpGenericServlet 클래스에서 한 발 더 나아가
 *    클라이언트의 HTTP 요청을 구분해서 메서드를 호출하도록 코드를 추가하였다.
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet21")
public class Servlet21 extends HttpGenericServlet {
  // HttpGenericServlet에서 추가한 service() 메서드를 오버라이딩 한다.
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("service(HttpServletReuest, HttpServletResponse)");
    //service() 파라미터 갓을 원래의 타입으로 형변환할 필요가 없다.
    //HttpServletRequest httpRequest = (HttpServletRequest)request;
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("HTTP 요청방법: %s\n", request.getMethod());
    
  }
}
