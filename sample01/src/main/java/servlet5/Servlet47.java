/* 주제: 세션에 저장된 데이터 사용하기
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

@WebServlet("/servlet47")
public class Servlet47 extends HttpServlet {
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
    out.printf("name=%s\n", session.getAttribute("name"));
    out.printf("gender=%s\n", session.getAttribute("gender"));
    out.printf("age=%s\n", session.getAttribute("age"));
    out.printf("date=%s\n", session.getAttribute("date"));
}
  
 
}

