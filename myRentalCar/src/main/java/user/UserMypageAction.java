package user;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserMypageAction
 */
//@WebServlet("/UserMypageAction")
public class UserMypageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMypageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UserDao dao = UserDao.getInstance();
		request.setCharacterEncoding("utf-8");
		
		if(request.getParameter("mypage").equals("¼öÁ¤")) {
			
			int code = Integer.parseInt(request.getParameter("code"));
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			
			UserDto user = new UserDto(code, password, name, address, phone);
			
			dao.updateUser(user);
			
			request.getRequestDispatcher("index").forward(request, response);
		} else if(request.getParameter("mypage").equals("Å»Åð")) {
			int code = Integer.parseInt(request.getParameter("code"));
			
			UserDto user = new UserDto(code);
			
			dao.deleteUser(user);
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("index").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
