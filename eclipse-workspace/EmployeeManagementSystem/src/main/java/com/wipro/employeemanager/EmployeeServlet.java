package com.wipro.employeemanager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id  = Integer.parseInt(request.getParameter("id"));
        String name  = request.getParameter("name");   
        String department  = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee(id, name, department, salary);

        EmployeeDAO dao = new EmployeeDAO();
        try {
            dao.addEmployee(emp);
            response.getWriter().println("Employee Added Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
