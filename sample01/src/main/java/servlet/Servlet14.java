/* 주제: 요청 방식과 응답 - GET, POST, HEAD
 * => GET
 * => POST
 * => HEAD
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet14")
public class Servlet14 extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    out.println("</head>");
    out.println("<body>");
    
    out.printf("이름=%s, 나이=%s", request.getParameter("name"), request.getParameter("age"));
    
    out.println("</body>");
    out.println("</html>");
    
  }
}

/* GET 요청
 =>프로토콜 예)
GET /web01/servlet14?name=aaa&age=1111 HTTP/1.1
Host: localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Referer: http://localhost:8080/web01/servlet14.html
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

=> 설명
- 서버에 보내는 데이터는 URL에 포함된다.
     /web01/servlet14?name=aaa&age=1111
- 한 번에 보낼 수 있는 데이터가 제한된다.
  왜? 웹서버는 보통 request-line 또는 header의 크기를 제한하기 때문이다.
  예) Tomcat/Apache(8KB), IIS6/7(16KB)
- 바이너리 데이터를 전송할 수 없다.
- URL에 데이터가 포함되기 대문에 URL과 데이터를 함께 저장할 수 있다.

  => 특징 정리
- 소량의 데이터를 보낼 때(게시글 상세보기, 삭제) 사용하는 요청 방식
- 바이너리 데이터 전송 불가
- 즐겨 찾기로 등록하거나 이메일 또는 게시판을 통해 링크 정보를 공유하기 쉽다.
- 데이터의 보안을 요구하는 곳에 사용하면 안된다.
 */

/* POST 요청
 => 프로토콜 예)
POST /web01/servlet14 HTTP/1.1
Host: localhost:8080
Content-Length: 40
Cache-Control: max-age=0
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,...
Referer: http://localhost:8080/web01/servlet14.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=222

=> 설명
- 서버에 보내는 데이터는 message-body에 포함된다.
    name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=222
- message-body에 대한 데이터 정보가 요청 헤더에 포함된다.
    Content-Length: 40
    Content-Type: application/x-www-form-urlencoded
- 서버에 보내는 데이터의 크기 제한이 없다.
  서버에 승인하는 만큼 보낼 수 있다.
  - 대용량 데이터를 보낼 때(게시글 등록/수정) 사용
  - multi-part 포맷으로 바이너리 데이터를 전송할 수 있다.
  - URL과 데이터 정보가 분리되어 있어 링크 정보를 공유할 수 없다.

=> 특징 정리
- 대용량 데이터를 보낼 때(게시글 등록/수정) 사용
- 바이너리 데이터 전송 가능
- 특정 결과를 출력하는 페이지 링크 정보를 공유해봐야 소용없다.
- URL에 데이터가 포함되어 있지 않기 때문에 보안을 요구하는 데이터인 경우 노출을 막을 수 있다.
  
  
 */ 

/* HEAD 요청
 => 요청 프로토콜 예)
 HEAD /web01/servlet14 HTTP/1.1
 Host: localhost:8080
 
 => 응답 프로토콜 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 24 Aug 2016 02:51:08 GMT

(내용은 서버에서 보내지 않는다.)
 => 설명
 - 서버에 그 자원에 대한 정보만 알고 싶을 때 사용한다.
 - 서버는 요청한 자원의 데이터를 보내지 않고 그 자원에 대한 프록시 정보만 보낸다. 
 - 보통 프록시 서버에서 웹서버에 요청할 때 사용한다.
 */
 

