package web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.AuthDao;
import repository.user.User;
import web.service.AuthService;
import web.service.AuthServiceImpl;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter({ "/profile/*", "/board/*" })
public class AuthFilter implements Filter {
	
	private AuthService authService;

	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext servletContext = fConfig.getServletContext();
		authService = new AuthServiceImpl((AuthDao)servletContext.getAttribute("authDao"));
	}
   

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		HttpSession session= hRequest.getSession();
		User principalUser = (User)session.getAttribute("principal");
		if(principalUser == null) {
			hResponse.sendRedirect("/JspStudy_4452/auth/signin");
			return; //메소드종료
		}else {
			session.setAttribute("principal", authService.getUser(principalUser.getUsername()));	
			
		}
		chain.doFilter(request, response);
	}

	
	

}
