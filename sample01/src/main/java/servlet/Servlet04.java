/* 주제: 애노테이션으로 서블릿 등록하기
 * - @WebServlet("URL") 애노테이션을 사용하면,
 *   web.xml에서 <servlet> 태그와 <servlet-mapping> 태그를 지정할 필요가 없다.
 * - 서블릿 컨테이너가 이 애노테이션을 처리하도록 
 *   web.xml의 <web-app> 태그에 속성 값을 false로 지정하라!
 *        metadata-complete="false"
 *   => metadata-complete 속성 값이 false이면, 서블릿 클래스에 @WebServlet 애노테이션이
 *      붙은 것을 찾아 자동으로 등록한다.
 * - Servlet 3.0 API에서 부터 사용 가능하다.
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
import javax.servlet.annotation.WebServlet;


@WebServlet("/servlet04")
public class Servlet04 implements Servlet {
  ServletConfig config;
  
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    this.config = config;
    
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
