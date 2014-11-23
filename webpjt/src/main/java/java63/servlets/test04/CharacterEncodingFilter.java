package java63.servlets.test04;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {

		request.setCharacterEncoding(filterConfig.getInitParameter("charset"));
		System.out.println("요청 데이터의 UTF-8 설정 완료.");

		nextFilter.doFilter(request, response);

		System.out.println("CharacterEncodingFilter 필터 나가기");


	}

	@Override
	public void destroy() {
	}

}
