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

import tw.com.phctw.bean.RandomStudent;
import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;
import tw.com.phctw.service.StudentServiceImpl;


@SuppressWarnings("serial")
public class InsertStuController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("insertStudent.jsp").forward(request, response);
		System.out.println("執行insertController");
		//網頁元件name
		String innumber = request.getParameter("number");
		int sumstunum = Integer.parseInt(innumber);
		System.out.println("插入值："+innumber);
		
		//抓出最後一筆資料
		StudentService ss1 = new StudentServiceImpl();
		List<Student> ls = new ArrayList<Student>();
		Student laststu = new Student();
		try{
			ls =  ss1.selectStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//找出最後一筆的sno數值 的數字
		int lastIdx = ls.size()-1;
		laststu = ls.get(lastIdx);
		String sno =  laststu.getSno();
		String s = sno.substring(1, sno.length());
		//去掉0
		int i = Integer.valueOf(s.replace("^(0+)", ""));
		
		//產生一筆學生資料 還缺少產生幾筆資料資訊
		List<Student> ls2 = new ArrayList<Student>();
		//計算加入幾筆資料
		int insertsum = 0;
		for(int a=1;a<=sumstunum;a++) {
			Student stu = RandomStudent.getStudent(i);
			System.out.println("插入學生："+stu);
			ls2.add(stu);	
			insertsum++;
			i++;
		}
		try {
			ss1.insertStudent(ls2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("insertnum", insertsum);
		request.getRequestDispatcher("insertStudent.jsp").forward(request, response);
	}

}
