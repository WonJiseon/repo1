/* 주제: HTTP 요청과 응답
 * => 웹 브라우저는 웹 서버에 요청할 때 HTTP 규칙에 따라 데이터를 보낸다.
 * => 웹 서버 또한 웹 브라우저에게 응답할 때 HTTP 규칙에 따라 데이터를 보낸다.
 * => 확인하는 방법?
 *    웹 브라우저와 웹 서버 사이에 주고 받는 데이터를 모니터링 프로그램을 통해 확인해보자!
 *    모니터링 프로그램?
 *    Fiddler(무료)
 *    CharlesProxy(유료, 30일 시험판)
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet13")
public class Servlet13 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    String op = request.getParameter("op");
    
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    
    switch (op) {
    case "+": out.printf("%d %s %d = %d\n", a, op, b, a + b); break;
    case "-": out.printf("%d %s %d = %d\n", a, op, b, a - b); break;
    case "*": out.printf("%d %s %d = %d\n", a, op, b, a * b); break;
    case "/": out.printf("%d %s %d = %d\n", a, op, b, a / b); break;
    default:
      out.println("지원하지 않는 연산자입니다.");
    }
    out.println("</body>");
    out.println("</html>");
    
  }
}

/* HTTP 프로토콜
[HTTP 요청 프로토콜(웹브라우저 ---> 웹서버)]
=> 규칙
Request-line(요청 방법 URI 프로토콜/버전) CRLF
0개 이상의 헤더(일반/요청/엔티티) CRLF
빈 줄
(POST 요청인 경우 데이터가 이 순서에 놓인다.)

=> 요청 예)
GET /web01/servlet13?a=10&b=5&op=* HTTP/1.1
Host: localhost:8080
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4


1. Request-line
요청방법 URI 프로토콜명/버전 CRLF
예) GET /web01/servlet13?a=10&b=5&op=* HTTP/1.1



[HTTP 응답 프로토콜(웹서버 ---> 웹브라우저)]
=> 규칙
Status-line CRLF(버전 상태코드 간단한문장) CRLF
0개 이상의 헤더(일반/응답/엔티티) CRLF
빈 줄
Message-body(콘텐츠)

=> 응답 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Content-Length: 63
Date: Tue, 23 Aug 2016 08:16:02 GMT
Proxy-Connection: Keep-alive

<html>
<head>
</head>
<body>
10 * 5 = 50
</body>
</html>

 */
