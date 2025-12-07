package CRUD;

import java.sql.*;
import java.util.Scanner;

public class CRUD_Test {

	public static void main(String[] args) {
		CRUD_Test objTest = new CRUD_Test();
		// insert data
		Scanner sc = new Scanner(System.in);
		int emp_id = sc.nextInt();
		String emp_name = sc.next();
		int age = sc.nextInt();
		String department = sc.next();
		int salary = sc.nextInt();
		objTest.create_data(emp_id, emp_name, age, department, salary);
		// read data
		objTest.read_data();
		//update data
		objTest.update_data(41614, "sam", 21, "cse", 80000, 22);
//		// delete data
//		objTest.delete_data("1");
	}

	public void create_data(int emp_id, String emp_name,int age, String department, int salary) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into emp_details (emp_id,emp_name,age,department,salary) values (?,?,?,?,?)");
			ps.setInt(1, emp_id);
			ps.setString(2, emp_name);
			ps.setInt(3, age);
			ps.setString(4, department);
			ps.setInt(5, salary);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void read_data() {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select * from emp_details");
			//ps.setString(1, emp_id);
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("EmpID -" + rs.getInt("emp_id"));
				System.out.println("EmpName -" + rs.getString("emp_name"));
				System.out.println("Age -" + rs.getInt("age"));
				System.out.println("Department -" + rs.getString("department"));
				System.out.println("Salary -" + rs.getInt("salary"));
				System.out.println("---------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update_data(int new_emp_id, String name, int age, String department, int salary, int emp_id) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("update emp_details set emp_id=?,emp_name=?,age=?,department=?,salary=? where emp_id=?");
			ps.setInt(1, new_emp_id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, department);
			ps.setInt(5, salary);
			ps.setInt(6, emp_id);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete_data(String sl_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="delete from user where sl_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, sl_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}