package web.controller.profile;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.UserDao;
import repository.user.User;
import web.service.AuthService;
import web.service.ProfileService;
import web.service.ProfileServiceImpl;


@WebServlet("/profile/update/password")
public class PasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileService profileService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		profileService = new ProfileServiceImpl((UserDao)servletContext.getAttribute("userDao"));
	}
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/views/profile/password-update.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("new-password"); //바꾸고자 하는 비밀번호만 전달
		
		HttpSession session = request.getSession();
		User principalUser = (User)session.getAttribute("principal");
		boolean result = profileService.updatePassword(principalUser.getUser_code(), password);
		if(result == true) {
			//마이페이지로 이동
			response.sendRedirect("/JspStudy_4452/profile/mypage");
		}
	}

	

}
