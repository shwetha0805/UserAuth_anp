
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/auth_db1",
                "root",
                "Root@12345678"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}