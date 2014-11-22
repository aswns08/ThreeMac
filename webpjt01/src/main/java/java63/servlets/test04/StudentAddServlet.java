package java63.servlets.test04;

import java.io.IOException;

import java63.servlets.test04.dao.ProductDao;
import java63.servlets.test04.domain.Student;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class StudentAddServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setSex(request.getParameter("phno"));
		student.setAge(Integer.parseInt(request.getParameter("phno")));
		student.setPhNo(request.getParameter("phno"));
		student.setEmail(request.getParameter("phno"));
		student.setSubj(request.getParameter("phno"));

		StudentDao productDao = (StudentDao)this.getServletContext()
				.getAttribute("productDao");
		try {
			productDao.insert(student);
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
