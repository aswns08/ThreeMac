package java63.servlets.test04;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("LogFilter 설정완료");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println(httpRequest.getRemoteAddr()); //ip주소를 알려주는 기능
		
		nextFilter.doFilter(request, response);
		
		System.out.println("LogFilter나가기");
		
	}
	@Override
	public void destroy() {
		
	}
	
}
