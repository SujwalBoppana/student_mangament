package de.zeroco.controllers;

import java.io.IOException;
import java.util.Arrays;
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
 * Servlet implementation class StudentController
 */
@WebServlet("/")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/register":
			create(request, response);
			break;
		case "/delete":
			delete(request, response);
			break;
		case "/getall":
			list(request, response);
			break;
		case "/getdata":
			get(request, response);
			break;
		case "/update":
			update(request, response);
			break;
		case "/data":
			showData(request, response);
			break;
		default:
			break;
		}

	}

	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student(request.getParameter("name"), request.getParameter("email"),
				request.getParameter("phno"), request.getParameter("fathername"), request.getParameter("dob"),
				Arrays.asList(request.getParameter("hobbies").split(",")));
		int id = StudentDao.getInsertedId(student);
		if (id != 0)
			request.setAttribute("message", id + " user created successfully ");
		else
			request.setAttribute("message", "falied");
		request.getRequestDispatcher("Registration.jsp").forward(request, response);
		System.out.println(student.toString());
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setEmail(request.getParameter("email"));
		int id = StudentDao.delete(student);
		if (id != 0)
			request.setAttribute("message", student.getEmail() + " deleted successfully");
		else
			request.setAttribute("message", "falied");
		request.getRequestDispatcher("Delete.jsp").forward(request, response);
	}

	public static void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, Object>> listOfStudents = StudentDao.getAll();
		request.setAttribute("message", "Records");
		request.setAttribute("details", listOfStudents);
		request.getRequestDispatcher("List.jsp").forward(request, response);
	}

	public static void get(HttpServletRequest request, HttpServletResponse response)
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
	public static void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student(request.getParameter("name"),request.getParameter("email"),request.getParameter("phno"),request.getParameter("fathername"),request.getParameter("dob"),Arrays.asList(request.getParameter("hobbies").split(",")));
		System.out.println(student.toString());
		int id = StudentDao.update(student);
		if(id!=0) request.setAttribute("message", "data updated successfully");
		else request.setAttribute("message", "updating failed!");
		request.getRequestDispatcher("Update.jsp").forward(request, response);
	}
	public static void showData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = StudentDao.get(request.getParameter("email"));
		if(student!=null) request.setAttribute("data", student);
		else request.setAttribute("message", "no data found");
		request.getRequestDispatcher("Data.jsp").forward(request, response);
		
		
	}
}
