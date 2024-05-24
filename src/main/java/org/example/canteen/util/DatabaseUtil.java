package org.example.canteen.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_database_user";
    private static final String PASSWORD = "your_database_password";

    static {
        try {
            Connection connection = getConnection();
            executeSqlFile(connection, "src/main/resources/schema.sql");
            executeSqlFile(connection, "src/main/resources/data.sql");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeSqlFile(Connection connection, String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Statement statement = connection.createStatement()) {
            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sql.append(line);
                if (line.endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

