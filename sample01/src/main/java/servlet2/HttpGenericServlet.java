/* 주제: service()의 파라미터를 원래의 타입으로 형변환 시킨 
 * 
 */
package servlet2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpGenericServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    System.out.println("service(ServletReuest, ServletResponse)");
    // 파라미터로 넘어온 값을 원래의 타입으로 형변환한다.
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    HttpServletResponse httpResponse = (HttpServletResponse)response; 
    
    service(httpRequest, httpResponse);
  }
  
  public abstract void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException;
}
