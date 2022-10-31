package car;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class carCreateAction
 */
//@WebServlet("/carCreateAction")
public class CarCreateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarCreateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		CarDao dao = CarDao.getInstance();
		request.setCharacterEncoding("UTF-8");
		
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		int year = Integer.parseInt(request.getParameter("year"));
		int km = Integer.parseInt(request.getParameter("km"));
		int price = Integer.parseInt(request.getParameter("price"));
		String kind = request.getParameter("kind");
		String fuel = request.getParameter("fuel");
		
		dao.createCar(new CarDto(code, name, carNo, year, km, price, kind, fuel));
		
		request.getRequestDispatcher("carList").forward(request, response);
//		response.sendRedirect("list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
