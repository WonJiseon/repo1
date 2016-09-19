/* 주제: 세션에 데이터 저장하기
 * => 웹 브라우저 별로 구분하여 저장할 데이터가 있다면,
 *    그 데이터는 세션에 보관하라!
 * => 참고!
 *    - 웹 브라우저에 상관없이 모든 사용자가 즉 모든 서블릿이 공유할 데이터는
 *      ServletContext에 보관하라!
 * => 데이터 저장하는 방법
 *    ServletContext 및 ServletRequest와 같다
 *    - setAttibute(key, value)
 *    - getAttribute(key)  
 * => 쿠키와 달리 어떤 객체라도 저장할 수 있다.
 */
package servlet5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet46")
public class Servlet46 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session= request.getSession();
    session.setAttribute("name", "홍길순");
    session.setAttribute("gender", false);
    session.setAttribute("age", 20);
    session.setAttribute("date", new Date());
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("세선아이디 = %s\n", session.getId());
}
  
 
}

