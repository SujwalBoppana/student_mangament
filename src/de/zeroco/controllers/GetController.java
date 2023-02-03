package de.zeroco.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zeroco.dao.StudentDao;
import de.zeroco.pojo.Student;

/**
 * Servlet implementation class GetController
 */
@WebServlet("/GetController")
public class GetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		student.setEmail(request.getParameter("email"));
		List<Map<String, Object>> studentDetails = StudentDao.getdata(student);
		if (studentDetails.size() != 0) {
			request.setAttribute("message", "Records found");
			request.setAttribute("details", studentDetails);
			request.getRequestDispatcher("Get.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "No records found");
			request.getRequestDispatcher("Get.jsp").forward(request, response);

		}
	}

}
