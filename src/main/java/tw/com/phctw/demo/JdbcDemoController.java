//Controller層-顯示學生資料

package tw.com.phctw.demo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;
import tw.com.phctw.service.StudentServiceImpl;

/**
 * Servlet implementation class JdbcDemo
 */
@WebServlet("/JdbcDemoController")
public class JdbcDemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcDemoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//測試顯示學生
		System.out.println("執行jdbcDemoController doGet()");
		StudentService ss1 = new StudentServiceImpl();
		List<Student> ls = new ArrayList<Student>();
		try{
			ls =  ss1.selectStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		request.setAttribute("list", ls);
		request.getRequestDispatcher("showStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
