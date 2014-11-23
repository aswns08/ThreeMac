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

@WebServlet("/test04/student/view")
public class StudentViewServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    //Student student = AppInitServlet.studentDao.selectOne(no);
    //Student student = ContextLoaderListener.studentDao.selectOne(no);
    
    StudentDao studentDao = (StudentDao)this.getServletContext()
                                         .getAttribute("studentDao");
    Student student = studentDao.selectOne(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("<html>");
    out.println("<head>");
    
    RequestDispatcher rd =
    		request.getRequestDispatcher("/common/header");
    rd.include(request, response);
    
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>학생 정보</h1>");
    
    out.println("<form class='form-horizontal' role='form' "
        + "action='update' method='post'>");
    out.println("<div class='form-group'>");
    out.println("  <label for='no' class='col-sm-2 control-label'>번호</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' readonly ");
    out.println("        id='no' name='no' value='" + no + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='name' class='col-sm-2 control-label'>이름</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='name' name='name' value='" + student.getName() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='age' class='col-sm-2 control-label'>나이</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='age' name='age' value='" + student.getAge() + "'>");
    out.println("  </div>");
    out.println("</div>");

    out.println("<div class='form-group'>");
    out.println("  <label for='phNo' class='col-sm-2 control-label'>전화번호</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='text' class='form-control' ");
    out.println("        id='phNo' name='phNo' value='" + student.getPhNo() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='email' class='col-sm-2 control-label'>이메일</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='text' class='form-control' ");
    out.println("        id='email' name='email' value='" + student.getEmail() + "'>");
    out.println("  </div>");
    out.println("</div>");
   
    String checkedM;
    String checkedF;
   
    if(student.getSex().equals("남자")){
    	checkedM = "checked='checked'";
    	checkedF = null;
    } else {
    	checkedF = "checked='checked'";
    	checkedM = null;
    }
    
    out.println("<div class='form-group'>");
    out.println("  <label for='sex' class='col-sm-2 control-label'>성별</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("  남자 : <input type='radio' id='sex' name='sex' value='남자'" + checkedM +">");
    out.println("  여자 : <input type='radio' id='sex' name='sex' value='여자'" + checkedF +">");
    out.println("  </div>");
    out.println("</div>");
    
    
    out.println("<div class='form-group'>");
    out.println("  <label for='subj' class='col-sm-2 control-label'>과목</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='text' class='form-control' ");
    out.println("        id='subj' name='subj' value='" + student.getSubj() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    
    out.println("<div class='form-group'>");
    out.println("  <div class='col-sm-offset-2 col-sm-10'>");
    out.println("    <button id='btnUpdate' type='submit' class='btn btn-primary'>변경</button>");
    out.println("    <button id='btnDelete' type='button' class='btn btn-primary'>삭제</button>");
    out.println("    <button id='btnCancel' type='button' class='btn btn-primary'>취소</button>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("</form>");
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    out.println("<script>");
    
    out.println("  $('#btnCancel').click(function(){");
    out.println("    history.back();");
    out.println("  });");
    
    out.println("  $('#btnDelete').click(function(){");
    out.println("    if (window.confirm('삭제하시겠습니까?')) {");
    out.println("      location.href = 'delete?no=" +  student.getNo() + "'");
    out.println("    }");
    out.println("  });");
    
    out.println("  $('#btnUpdate').click(function(){");
    out.println("    if ( $('#name').val().length == 0) {");
    out.println("      alert('이름은 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#phNo').val().length == 0) {");
    out.println("      alert('전화번호는 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
    
    out.println("    if ( $('#age').val().length == 0) {");
    out.println("      alert('나이는 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
    
    out.println("    if ( $('#sex').val().length == 0) {");
    out.println("      alert('성별은 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#subj').val().length == 0) {");
    out.println("      alert('과목 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
    out.println("  });");
    
    out.println("</script>");
    
    // 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    rd = request.getRequestDispatcher("/common/footer");
    rd.include(request, response);
    
    out.println("</body>");
    out.println("</html>");
  }
  
}












