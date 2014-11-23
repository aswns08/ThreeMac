package java63.servlets.test04;

import java.io.IOException;
import java63.servlets.test04.dao.StudentDao;
import java63.servlets.test04.domain.Student;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test04/student/list")
public class StudentAddServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setSex(request.getParameter("sex"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		student.setPhNo(request.getParameter("phNo"));
		student.setEmail(request.getParameter("email"));
		student.setSubj(request.getParameter("subj"));

		StudentDao studentDao = (StudentDao)this.getServletContext()
				.getAttribute("studentDao");
		try {
			studentDao.insert(student);
		} catch (Exception e) {
			// 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.

			// Forward로 다른 서블릿에게 제어권 위임하기
			//	=> 제어권이 넘어가면 돌아오지 않는다.
			RequestDispatcher rd =
					request.getRequestDispatcher("/common/error");
			request.setAttribute("error", e);
			rd.forward(request, response);
		}
		HttpServletResponse orginResponse = (HttpServletResponse)response;
		orginResponse.sendRedirect("list");

	}

}
