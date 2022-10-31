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
		
		// �Ķ���ͷ� �Ѱܹ��� id/password�� ���� �����ϰ� �ִ�(���̺� ��ȸ) ����� ��ġ�ϴ� ���,
		// session�� log���� �ο�
//		HttpSession session = request.getSession();
//		session.setAttribute("log", "apple"); // setAttribute() -> Ȱ��
//		
////		request.setAttribute("list", ArrayList)
//		//
//		String log = (String)session.getAttribute("log"); // ����Ÿ��: Object -> ����ȯ �� ���
//		if(log != null) {
//			// �α��� ȸ�����Ը� ó���� ����
//			session.removeAttribute("log");
//		}
//		else {
//			// �α��� �������� �帧���� �Ǵ� Ȩ���� ��������
//		}
		
		// 1. �Ķ���ͷ� �Ѿ�� id, pw Ȱ��
		// 2. UserDto.getUserById(id) -> UserDto ��ü�� ����(�����ͺ��̽� ���̺�)
		// 3. ���� ��ü user�� == null / != null
		// 3-1) null -> null �޼��� ��ȯ
		// 3-2) Object -> JSON ������ ��ȯ & session�� log �� ����
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//		if(id != null & pw != null) {
//			UserDao dao = UserDao.getInstance();
//			UserDto user dao.getUserById(id);
//			UserDto user = new UserDto(id, pw, "���ý�");
			
//			if(user == null) {
//				// �α��� ����
//				response.getWriter().append("null");
//			} else {
//				// �α��� ����
//				// UserDto ��ü�� -> JSON Ÿ������ ������ ��ȯ
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
