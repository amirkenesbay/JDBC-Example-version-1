package JDBCByBookExample2;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorDBMain {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectorDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
