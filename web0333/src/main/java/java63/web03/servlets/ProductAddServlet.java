package java63.web03.servlets;

import java.io.IOException;
import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@WebServlet("/product/add.do")
public class ProductAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
	  
	  RequestDispatcher rd = 
			  request.getRequestDispatcher("/product/Productform.jsp");
	  rd.forward(request, response);
	  
	}
  
  @Override
  public void doPost(HttpServletRequest request, 
		  HttpServletResponse response)
      throws ServletException, IOException {
	  // 다음 아래코드는 필터로 대체함.
	  //request.setCharacterEncoding("UTF-8");
    
    Product product = new Product();
    product.setName(request.getParameter("name"));
    product.setQuantity(Integer.parseInt(request.getParameter("qty")));
    product.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
    
    ApplicationContext appCtx = 
    		WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    
    ProductDao productDao = (ProductDao)appCtx.getBean("productDao");
    
    try {
    productDao.insert(product);
    } catch (Exception e) {
    	// 다른 서블릿을 실행 => 실행 후 제어권이 되돌아 온다.
    	
    	// Forward로 다른 서블릿에게 제어권 위임하기
    	//	=> 제어권이 넘어가면 돌아오지 않는다.
        RequestDispatcher rd =
        		request.getRequestDispatcher("/common/Error.jsp");
        request.setAttribute("error", e);
        rd.forward(request, response);
    }
    response.sendRedirect("list.do");
  }
  
}












