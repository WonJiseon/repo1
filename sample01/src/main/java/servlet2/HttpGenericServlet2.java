/* 주제: GET과 POST, HEAD 등의 요청을 구분하여 메서드 호출한다.
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpGenericServlet2 extends GenericServlet {
  // 이 메서드는 톰캣 서버(Servlet Container)가 호출하기 때문에 public으로 공개해야 한다.
  // Servlet 인터페이스에 선언된 메서드는 무조건 public이다. 접근 권한을 낮출 수 없다.
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    System.out.println("service(ServletReuest, ServletResponse)");
    // 파라미터로 넘어온 값을 원래의 타입으로 형변환한다.
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    HttpServletResponse httpResponse = (HttpServletResponse)response; 

    service(httpRequest, httpResponse);
  }
  
  // 위의 service()에서 내부적으로 호출하거나, 
  // 자식 클래스가 재정의 할지도 모르기 때문에
  // protected로 선언한다. 단 외부에서 호출할 일이 없기 때문에 public으로 공개할 필요는 없다.
  protected void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    switch (request.getMethod()) {
    case "GET": doGet(request, response); break;
    case "POSE": doPost(request, response); break;
    case "HEAD": doHead(request, response); break;
    case "TRACE": doTrace(request, response); break;
    case "DELETE": doDelete(request, response); break;
    case "PUT": doPut(request, response); break;
    default: 
      doDefault(request, response); 
    }
  }

  // 이 메서드는 자식 클래스에서도 사용하지 않기 때문에 private으로 접근 권한을 최소로 낮춘다.
  private void doDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>오류</title></head>");
    out.println("<body>");
    out.println("<h1>오류</h1>");
    out.println("<p>요구하신 HTTP 요청 메서드를 지원하지 않습니다.</p>");
    out.println("</body></html>");

  }
  
  // 나머지 메서드는 자식 클래스에서 오버라이딩 할 수도 있기 때문에 protected로 한다.
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);

  }

  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);

  }

  protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);
  }

  protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doDefault(request, response);

  }
}
