package java63.servlets.test04;

import java.io.IOException;
import java63.servlets.test04.dao.StudentDao;
import java63.servlets.test04.domain.Student;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test04/student/update")
public class StudentUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
	// 다음 아래코드는 필터로 대체함.
    //request.setCharacterEncoding("UTF-8");
    
    Student student = new Student();
    student.setNo(Integer.parseInt(request.getParameter("no")));
    student.setName(request.getParameter("name"));
    student.setEmail(request.getParameter("email"));
    student.setSex(request.getParameter("sex"));
    student.setSubj(request.getParameter("subj"));
    student.setPhNo(request.getParameter("phNo"));
    student.setAge(Integer.parseInt(request.getParameter("age")));
    
    //AppInitServlet.studentDao.update(student);
    //ContextLoaderListener.studentDao.update(student);
    
    // StudentDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점: 위의 방식보다 코드가 늘었다.
    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
    StudentDao studentDao = (StudentDao)this.getServletContext()
                                         .getAttribute("studentDao");
    studentDao.update(student);
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}












