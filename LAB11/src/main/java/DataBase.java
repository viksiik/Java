import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBase {
    public Connection connection;

    public DataBase(Connection connection) {
        this.connection = connect();
    }

    public Connection connect() {
        Properties properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")){
            if (input == null) {
                System.err.println("Sorry, unable to find db.properties");
                return null;
            }

            properties.load(input);
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connection established successfully.");

        } catch ( SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public void getAllEmployees() {
        String query = "SELECT * FROM Employees";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Employees:");
            while (rs.next()) {
                System.out.printf("ID: %d, LastName: %s, FirstName: %s, Position: %s, Department ID: %d%n",
                        rs.getInt("Employee_ID"), rs.getString("Last_Name"), rs.getString("First_Name"),
                        rs.getString("Position"), rs.getInt("Department_ID"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
        }
    }

    public void getAllTasks() {
        String query = "SELECT * FROM Tasks";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Tasks:");
            while (rs.next()) {
                System.out.printf("ID: %d, Description: %s, Employee ID: %d%n",
                        rs.getInt("Task_ID"), rs.getString("Task_Description"), rs.getInt("Employee_ID"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving tasks: " + e.getMessage());
        }
    }

    public void getAllEmployeesInDepartment(int departmentID) {
        String query = "SELECT * FROM Employees WHERE Department_ID = " + departmentID;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Employees in Department " + departmentID + " : ");
            while (rs.next()) {
                System.out.printf("ID: %d, LastName: %s, FirstName: %s, Position: %s, Department ID: %d%n",
                        rs.getInt("Employee_ID"), rs.getString("Last_Name"), rs.getString("First_Name"),
                        rs.getString("Position"), rs.getInt("Department_ID"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
        }
    }

    public void addTask(int Task_ID, int employeeId, String description) {
        String query = "INSERT INTO Tasks (Task_ID, Task_Description, Employee_ID) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, Task_ID);
            pstmt.setString(2, description);
            pstmt.setInt(3, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Task added successfully. Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error adding task: " + e.getMessage());
        }
    }

    public void getTasksByEmployee(int employeeId) {
        String query = "SELECT * FROM Tasks WHERE Employee_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Tasks for Employee " + employeeId + ":");
                while (rs.next()) {
                    System.out.printf("ID: %d, Description: %s%n", rs.getInt("Task_ID"), rs.getString("Task_Description"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving tasks for employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int employeeId) {
        String deleteTasksQuery = "DELETE FROM Tasks WHERE Employee_ID = ?";
        String deleteEmployeeQuery = "DELETE FROM Employees WHERE Employee_ID = ?";

        try (PreparedStatement deleteTasksStmt = connection.prepareStatement(deleteTasksQuery);
             PreparedStatement deleteEmployeeStmt = connection.prepareStatement(deleteEmployeeQuery)) {

            deleteTasksStmt.setInt(1, employeeId);
            deleteTasksStmt.executeUpdate();

            deleteEmployeeStmt.setInt(1, employeeId);
            int rowsAffected = deleteEmployeeStmt.executeUpdate();

            System.out.println("Employee deleted successfully. Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }

}
