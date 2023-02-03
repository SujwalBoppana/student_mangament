package de.zeroco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.zeroco.pojo.Student;

public class StudentDao {
	final static String URL = "jdbc:mysql://localhost:3306/";
	final static String SCHEMA = "zerocode";
	final static String USERID = "admin";
	final static String PASSWORD = "Sujwal@123";
	final static String TABLENAME = "student_details";
	final static List<String> TABLECOL = Arrays.asList("name", "fathers_name", "phno", "email", "date_of_birth",
			"hobbies");

	public static int getInsertedId(Student student) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			String hobbies = "";
			for (String hobbi : student.getHobbies()) {
				hobbies += "," + hobbi;
			}
			List<Object> details = Arrays.asList(student.getName(), student.getFatherName(), student.getPhno(),
					student.getEmail(), student.getDob(), hobbies.substring(1));
			int id = DbUtils.getGenertedId(connection, SCHEMA, TABLENAME, TABLECOL, details);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				DbUtils.getCloseConnection(connection);
			}
		}
		return 0;
	}

	public static List<Map<String, Object>> getdata(Student student) {
		Connection connection = null;
		try {
			String email = student.getEmail();
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.list(connection, SCHEMA, TABLENAME, TABLECOL, "email", "=", email);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return null;
	}

	public static List<Map<String, Object>> getAll() {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.get(connection, SCHEMA, TABLENAME, TABLECOL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return null;
	}
	public static Student get(String email) {
		Connection connection = null;
		Student student = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			ResultSet resultSet = DbUtils.get(connection, SCHEMA, TABLENAME, TABLECOL, "email", "=", email);
			while (resultSet.next()) {
				student = new Student();
				student.setName(resultSet.getString("name"));
				student.setEmail(resultSet.getString("email"));
				student.setFatherName(resultSet.getString("fathers_name"));
				student.setDob(resultSet.getString("date_of_birth"));
				student.setPhno(resultSet.getString("phno"));
				student.setHobbies(Arrays.asList(resultSet.getString("hobbies").split(",")));
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return null;
		
	}

	public static int delete(Student student) {
		Connection connection = null;
		try {
			String email = student.getEmail();
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			return DbUtils.deleteData(connection, SCHEMA, TABLENAME, "email", "=", Arrays.asList(email));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return 0;
	}
	public static int update(Student student) {
		Connection connection = null;
		try {
			connection = DbUtils.getConnection(URL, SCHEMA, USERID, PASSWORD);
			String hobbies = "";
			for (String hobbi : student.getHobbies()) {
				hobbies += "," + hobbi;
			}
			List<Object> details = Arrays.asList(student.getName(), student.getFatherName(), student.getPhno(), student.getDob(), hobbies.substring(1),student.getEmail());
			return DbUtils.updateData(connection, SCHEMA, TABLENAME,  Arrays.asList("name", "fathers_name", "phno",  "date_of_birth",
					"hobbies"), details, "email");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				DbUtils.getCloseConnection(connection);
		}
		return 0;
		
	}

}
