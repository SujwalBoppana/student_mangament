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
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student(request.getParameter("name"), request.getParameter("email"),
				request.getParameter("phno"), request.getParameter("fathername"), request.getParameter("dob"),
				Arrays.asList(request.getParameter("hobbies").split(",")));
		int id = StudentDao.getInsertedId(student);
		if (id!=0) request.setAttribute("message", id +" user created successfully ");
		else request.setAttribute("message", "falied");
		request.getRequestDispatcher("Registration.jsp").forward(request, response);
		System.out.println(student.toString());
	}

}
