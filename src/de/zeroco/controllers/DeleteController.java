package de.zeroco.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zeroco.dao.StudentDao;
import de.zeroco.pojo.Student;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		student.setEmail(request.getParameter("email"));
		int id = StudentDao.delete(student);
		if (id != 0)
			request.setAttribute("message", student.getEmail() + " deleted successfully");
		else
			request.setAttribute("message", "falied");
		request.getRequestDispatcher("Delete.jsp").forward(request, response);
	}
}
