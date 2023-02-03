package de.zeroco.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.zeroco.dao.StudentDao;
import de.zeroco.pojo.Student;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student(request.getParameter("name"),request.getParameter("email"),request.getParameter("phno"),request.getParameter("fathername"),request.getParameter("dob"),Arrays.asList(request.getParameter("hobbies").split(",")));
		int id = StudentDao.update(student);
		if(id!=0) request.setAttribute("message", "data updated successfully");
		else request.setAttribute("message", "updating failed!");
		request.getRequestDispatcher("Update.jsp").forward(request, response);
	}

}
