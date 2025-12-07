package CRUD;
import java.sql.*;

public class EmployeeManagementSystem {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/employee_database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    // Method to establish a database connection
    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to insert a new employee record
    public static void createEmployee(String name, int age, String department, double salary) throws SQLException {
        String sql = "INSERT INTO employees (name, age, department, salary) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, department);
        preparedStatement.setDouble(4, salary);
        preparedStatement.executeUpdate();
    }

    // Method to retrieve employee records
    public static void getEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            // Process and display each employee record
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String department = resultSet.getString("department");
            double salary = resultSet.getDouble("salary");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Salary: " + salary);
        }
    }

    // Method to update an employee record
    public static void updateEmployee(int id, String name, int age, String department, double salary) throws SQLException {
        String sql = "UPDATE employees SET name=?, age=?, department=?, salary=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, department);
        preparedStatement.setDouble(4, salary);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }

    // Method to delete an employee record
    public static void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    // Method to close database connection
    public static void disconnect() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            connect();

            // Example usage:
            createEmployee("John Doe", 30, "IT", 50000);
            getEmployees(); // Display all employees
            updateEmployee(1, "John Smith", 32, "HR", 55000);
            deleteEmployee(2);

            getEmployees(); // Display updated list of employees

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
