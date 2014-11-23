package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;
import java63.servlets.test04.dao.StudentDao;
import java63.servlets.test04.domain.Student;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test04/student/list")
public class StudentListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
	  System.out.println("service() 실행시작");
	  
    int pageNo = 0;
    int pageSize = 0;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      pageSize = PAGE_DEFAULT_SIZE;
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    // 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    RequestDispatcher rd =
    		request.getRequestDispatcher("/common/header");
    rd.include(request, response);
    
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>제품 목록</h1>");
    out.println("<p><a href='student-form.html' class='btn btn-primary'>새제품</a></p>");
    out.println("<table class='table table-hover'>");
    out.println("<tr>");
    out.println("  <th>#</th><th>제품</th><th>수량</th><th>제조사</th>");
    out.println("</tr>");
    
    //for (Student student : AppInitServlet.studentDao.selectList(pageNo, pageSize)) {
    //for (Student student : ContextLoaderListener.studentDao.selectList(pageNo, pageSize)) {
    
    // StudentDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점: 위의 방식보다 코드가 늘었다.
    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
    StudentDao studentDao = (StudentDao)this.getServletContext()
                                         .getAttribute("studentDao");
    for (Student student : studentDao.studentselectList(pageNo, pageSize)) {
      out.println("<tr>");
      out.println("  <td>" + student.getName() + "</td>");
      out.println("  <td><a href='view?no=" + student.getAge() + "'>" 
            + student.getName() + "</a></td>");
      out.println("  <td>" + student.getPhNo() + "</td>");
      out.println("  <td>" + student.getEmail() + "</td>");
      out.println("  <td>" + student.getSex() + "</td>");
      out.println("  <td>" + student.getSubj() + "</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    // 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    rd = request.getRequestDispatcher("/common/footer");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
    System.out.println("service() 실행완료");
  }
  
}












