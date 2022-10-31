package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import user.UserDto;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 파라미터로 넘겨받은 id/password가 기존 보유하고 있는(테이블 조회) 멤버와 일치하는 경우,
		// session에 log값을 부여
//		HttpSession session = request.getSession();
//		session.setAttribute("log", "apple"); // setAttribute() -> 활용
//		
////		request.setAttribute("list", ArrayList)
//		//
//		String log = (String)session.getAttribute("log"); // 리턴타입: Object -> 형변환 후 사용
//		if(log != null) {
//			// 로그인 회원에게만 처리될 로직
//			session.removeAttribute("log");
//		}
//		else {
//			// 로그인 페이지로 흐름제어 또는 홈으로 돌려보냄
//		}
		
		// 1. 파라미터로 넘어온 id, pw 활용
		// 2. UserDto.getUserById(id) -> UserDto 객체를 언어옴(데이터베이스 테이블)
		// 3. 얻어온 객체 user가 == null / != null
		// 3-1) null -> null 메세지 반환
		// 3-2) Object -> JSON 데이터 반환 & session에 log 값 저장
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		if(id != null & pw != null) {
//			UserDao dao = UserDao.getInstance();
//			UserDto user dao.getUserById(id);
//			UserDto user = new UserDto(id, pw, "정택승");
			
//			if(user == null) {
//				// 로그인 실패
//				response.getWriter().append("null");
//			} else {
//				// 로그인 성공
//				// UserDto 객체를 -> JSON 타입으로 데이터 반환
//				HttpSession session = request.getSession();
//				session.setAttribute("log", user.getId());
//				JSONObject data = new JSONObject(user);
//				response.setCharacterEncoding("utf-8");
//				response.getWriter().append(data.toString());
//			}
//		} else {
//			// index.jsp OR joinForm.jsp
//			// response.sendRedirect();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
