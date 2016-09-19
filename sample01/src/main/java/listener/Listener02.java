/* 주제: 리스너 - 요청이 들어올 때 작업 수행, @WebListener를 사용하여 등록하기
 * => 용도
 *  - 요청이 들어오는 기록을 남기고 싶을 때 (로그 남기기)
 *  - 요청을 처리하기 전 추가 작업을 하고 싶을 때
 */
package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener02 implements ServletRequestListener {
  
  public Listener02() {
    System.out.println("Listener02()");
  }
  
  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    // service()를 실행한 후 호출된다.
    System.out.println(sre.getServletRequest().getRemoteAddr());
    System.out.println("Listener02.requestDestroyed()");
    
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    // 요청이 들어오면 호출된다.
    System.out.println("Listener02.requestInitialized()");
    
  }  
}
