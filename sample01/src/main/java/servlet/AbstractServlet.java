package servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

// 서블릿 클래스를 쉽게 만들 수 있도록 Servlet 인터페이스의 다섯개 메서드 중에서
// init(), destroy(), getServletInfo(), getServletConfig()를 미리 구현한 클래스.
public abstract class AbstractServlet implements Servlet {
  ServletConfig config;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;
    
  }
  @Override
  public void destroy() {
    
  }

  @Override
  public ServletConfig getServletConfig() {
    return this.config;
  }

  @Override
  public String getServletInfo() {
    return this.getClass().getName();
  }
}
