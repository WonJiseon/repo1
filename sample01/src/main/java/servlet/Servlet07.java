/* 주제: GenericServlet 클래스를 상속 받아 서블릿 구현하기
 * - 이전 예제에서 만든 AbstractServlet 추상 클래스와 같은 기능을 하는 것이
 *   GenericServlet 추상 클래스이다.
 * - 그럼 왜 AbstractServlet 클래스를 만들었나요?
 *   => GenericServlet 클래스가 내부적으로 뭐하는 클래스인지 보여주기 위해서
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/servlet07")
public class Servlet07 extends GenericServlet {
  
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    // 클라이언트로 출력하고 싶다면, ServletResponse 객체에서 출력 도구를 꺼내
    // 다음과 같이 사용하라!
    PrintWriter out = response.getWriter();
    out.println("Hello*^^*");
  }
 
}
