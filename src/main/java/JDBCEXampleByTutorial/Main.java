package JDBCEXampleByTutorial;

import java.io.IOException;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            System.out.println("Database connected!");
//            statement.execute("INSERT INTO animal(anim_name, anim_desc) VALUE('name', 'desc');");
//            ResultSet res = statement.executeQuery("SELECT * FROM animal");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch1', 'desc');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch2', 'desc');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch3', 'desc');");

            statement.executeBatch();

            statement.clearBatch();

            boolean status = statement.isClosed();
            System.out.println(status);

            statement.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            System.out.println("Database connected!");
//        } catch (SQLException e) {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
    }
}
