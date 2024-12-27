import java.sql.Connection;
import java.sql.SQLException;

    public class Main {
        public static void main(String[] args) {
            Connection connection = null;

            try {
                DataBase app = new DataBase(connection);

                app.getAllEmployees();
                app.getAllTasks();
                app.getAllEmployeesInDepartment(1);
                app.addTask( 6,2,"Write code for java");
                app.getAllTasks();
                app.getTasksByEmployee(1);

                app.deleteEmployee(4);
                app.getAllEmployees();
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    System.err.println("Error closing the connection: " + e.getMessage());
                }
            }
        }
    }

