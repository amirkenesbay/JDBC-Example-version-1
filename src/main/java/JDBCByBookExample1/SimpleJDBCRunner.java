package JDBCByBookExample1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleJDBCRunner {
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery("SELECT * FROM phonebook");
                    List<Abonent> abonentList = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        long phone = resultSet.getLong(3);
                        String name = resultSet.getString(2);
                        abonentList.add(new Abonent(id, phone, name));
                    }
                    if (abonentList.size() > 0) {
                        System.out.println(abonentList);
                    } else {
                        System.out.println("Abonent not found!");
                    }
                } catch (SQLException e) {
                    System.err.println("DB connection error: " + e);
                } finally {
                    if (statement != null) {
                        statement.close();
                    } else {
                        System.err.println("Statement не создан");
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.err.println("Connection close error: " + e);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
