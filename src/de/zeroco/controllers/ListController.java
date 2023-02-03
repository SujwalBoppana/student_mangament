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

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> listOfStudents = StudentDao.getAll();
		request.setAttribute("message", "Records");
		request.setAttribute("details", listOfStudents);
		request.getRequestDispatcher("List.jsp").forward(request, response);
	}
	

}
