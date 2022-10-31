package user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userJoinAction
 */
//@WebServlet("/userJoinAction")
public class UserJoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserJoinAction() {
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
		request.setCharacterEncoding("UTF-8");
		
		int code = Integer.parseInt(request.getParameter("code"));
		String id = request.getParameter("id");
		
		ArrayList<UserDto> list = dao.getUserAll();
		for(UserDto user : list) {
			if(user.getId().equals(id)) {
				request.getRequestDispatcher("userJoinForm").forward(request, response);
			}
		}
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		int license = Integer.parseInt(request.getParameter("license"));
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp regDate = now;
		
		UserDto user = new UserDto(code, id, password, name, address, phone, license, regDate);
		dao.createUser(user);
			
		request.getRequestDispatcher("userLoginForm").forward(request, response);
//		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
