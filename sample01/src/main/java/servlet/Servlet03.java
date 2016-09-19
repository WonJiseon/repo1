/* 주제: <load-on-startup> 태그
 * - 서블릿 객체는 최초 요청 시 생성된다.
 * - 그런데 서블릿이 사용할 자원을 준비시키는데(생성자를 호출하거나 init()를 호출하는 것)
 *   시간이 오래 걸린다면, 최초로 요청하는 사용자는 늦게 응답을 받을 수 있다.
 * - 더 중요한 것은, 자원을 준비하는 코드에 잠재적인 오류가 있다 하더라도
 *   그것은 최초 요청할 때까지 알 수 없다. 이것이 문제다!
 * - 즉 최초 요청할 때 오류가 발견된다면 업무에 대단한 차질을 빚을 수 있다.
 * - 해결책?
 *   => 서블릿을 요청하지 않아도, 서버를 실행할 때 서블릿 객체를 미리 생성할 수 있다면
 *      서벌 실행 중에 오류를 미리 발견하여 조치를 취할 수 있을 것이다.
 *   => web.xml에 서블릿을 등록할 때 설정하라!
 *      서버 실행할 때 서블릿을 생성하라고 설정하라!
 *   => 문법
 *      <load-on-startup>순번</load-on-startup>
 *      생성될 서블릿이 여러 개이고, 그 생성 순서가 중요하다면
 *      순번을 조정하라. 중요하지 않다면 그냥 아무 숫자나 집어 넣어라!
 *      
 */

package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class Servlet03 implements Servlet {
  ServletConfig config;
  
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    this.config = config;
    
    // 서블릿이 사용할 자원을 준비시키는 코드..
    try {
      // ServletConfig 객체를 사용하면 web.xml에 기록된 파라미터 값을 조회할 수 있다.
      // 이것이 생성자가 아닌 init()에서 자원을 준비하는 이유이다.
      String driver = config.getInitParameter("driver"); // 이 값을 어떻게 얻을 것인가?
      String jdbcUrl = config.getInitParameter("jdbcUrl"); // FileReader와 같은 I/O 클래스를 사용하여 값을 읽어 들일 것인가?
      String username = config.getInitParameter("username"); 
      String password = config.getInitParameter("password");
      
      Class.forName(driver);
      Connection con = DriverManager.getConnection(jdbcUrl, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    System.out.println("service()");
  }
  @Override
  public void destroy() {
    System.out.println("destroy()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public String getServletInfo() {
    return "servlet01";
  }


}
