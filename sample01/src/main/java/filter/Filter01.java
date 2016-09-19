/* 주제: 필터를 만드는 방법과 구동원리
 * => javax.servlet.Filter 인터페이스를 구현한다.
 *    1) init()
 *    - 필터 객체를 생성한 후 자동으로 호출되는 메서드
 *    - 필터가 작업할 때 사용할 자원을 준비시키는 코드를 둔다.
 *    2) doFilter()
 *    - 필터가 적용될 때마다 호출되는 메서드
 *    - 서블릿의 service()
 *    3) destroy()
 *    - 웹 애플리케이션이 멈출 때 호출되는 메서드
 *    - 필터가 사용하기 위해 준비한 자원을 해제시키는 코드를 둔다.
 * => 필터를 웹 애플리케이션 설저엥 추가해야 한다.
 *    - DD 파일(Development Descriptor 파일; web.xml)에 추가하거나,
 *      @WebFilter 애노테이션을 추가할 수 있다.
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/servlet16")
public class Filter01 implements Filter {
  FilterConfig config;
  
  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
    System.out.println("Filter01.init()...");
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
      throws IOException, ServletException {
    System.out.println("Filter01.doFilter(): service() 호출하기 전에 수행할 작업...");
    
    // 다음에 실행할 필터가 있다면 그 필터를 실행한다.
    // 만약 다음 필터가 없다면, 서블릿의 service() 호출한다.
    nextFilter.doFilter(request, response);
    
    System.out.println("service() 호출한 후에 수행할 작업...");
  }
  
  @Override
  public void destroy() {
    System.out.println("Filter01.destory()...");
  }
}

/* 필터의 구동원리
 * 1) 웹 애플리케이션 시작
 * 2) 웹 애플리케이션에 등록된 피터 객체 생성 및 생성자 호출, init() 호출
 * 3) 웹 애플리케이션에 등록된 서블릿 중에서 <load-on-startup>이 선언된
 *    서블릿 객체 생성 및 생성자 호출, init() 호출
 * 4) 서블릿 요청
 *    ---> 그 경로에 설정된 필터 싱행; doFilter() 호출됨
 *    ---> 다음 필터 실행...
 *    ---> 더이상 실행할 필터가 없다면, 서블릿의 service() 호출
 *    ---> 거꾸로 필터로 리턴함.
 *    ---> 이전 필터가 없을 때까지 계속 리턴 ...
*/
