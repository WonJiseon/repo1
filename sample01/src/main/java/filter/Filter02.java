/* 주제: 여러 개의 필터 꼽기
 * => 요청한 URL에 대해 실행할 필터가 여러 개 있을 경우,
 *    각 필터는 모두 실행된다.
 * => 필터의 적용 순서에 영향을 받는 프로그램을 개발하지 말라!
 *    유지보수에 좋지 않다.
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

@WebFilter("/servlet16")
public class Filter02 implements Filter {
  FilterConfig config;
  
  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
    System.out.println("Filter02.init()...");
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
      throws IOException, ServletException {
    System.out.println("Filter02.doFilter(): service() 호출하기 전에 수행할 작업...");
    
    // 다음에 실행할 필터가 있다면 그 필터를 실행한다.
    // 만약 다음 필터가 없다면, 서블릿의 service() 호출한다.
    nextFilter.doFilter(request, response);
    
    System.out.println("service() 호출한 후에 수행할 작업...");
  }
  
  @Override
  public void destroy() {
    System.out.println("Filter02.destory()...");
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
 *    
 * 필터 호출 그래프
 * 요청
 *  ---> Filter01.doFilter() 
 *    ---> Filter02.doFilter() 
 *      ---> Filter03.doFilter() 
 *        ---> Servlet의 service() 호출 : 요청 처리
 *      <--- Filter03.doFilter() 리턴 
 *    <--- Filter02.doFilter() 리턴
 *   <--- Filter01.doFilter() 리턴
 * 응답
*/
