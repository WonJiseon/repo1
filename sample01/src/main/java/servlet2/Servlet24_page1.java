/* 주제: Refresh 방법
 * => 클라이언트에게 콘텐츠 출력을 완료한 후, 다른 URL로 다시 요청하도록 만드는 방법
 * => 방법1: HTTP 응답 헤더에 Refresh 정보 삽입
 * => 방법2: HTML <meta> 태그에 Refresh 정보 삽입
 * => 용도
 *    - 간단한 메시지 출력과 함께 다른 페이지로 자동 이동할 때 사용된다.
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet24_page1")
public class Servlet24_page1 extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    int age = Integer.parseInt(request.getParameter("age"));

    if (age < 18) {
      response.setHeader("Refresh", "1;url=servlet24_page2");
    } else {
      response.setHeader("Refresh", "1;url=servlet24_page3");
    }
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Refresh 테스트</title>");
    out.println("</head>");
    out.println(" <body>");
    if (age < 19) {
      out.println("미성년입니다.");
    } else {
      out.println("성년입니다.");
    }
    out.println("</body>");
    out.println("</html>");
  }
}


/* 리프래시 HTTP 응답 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Refresh: 1;url=servlet24_page3
Content-Type: text/html;charset=UTF-8
Content-Length: 95
Date: Mon, 29 Aug 2016 08:10:05 GMT
Proxy-Connection: Keep-alive
<html>
<head>
<title>Refresh 테스트</title>
</head>
<body>
성년입니다.
</body>
</html>
 */

