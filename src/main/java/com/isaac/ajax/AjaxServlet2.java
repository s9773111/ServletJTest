package com.isaac.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet2")
public class AjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//中文亂碼處理
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("AjaxServlet2呼叫成功！");
		
		//接收數據
		String name  = request.getParameter("name");
		
		if(name.equals("abc")) {
			response.getWriter().append("帳號已存在");
		}else {
			response.getWriter().append("帳號可以使用");
		}
	}
}
