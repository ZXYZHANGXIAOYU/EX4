package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/javaee";
    static String username="root";
    static String pwd="123456ASDfgh";
    static Connection conn = null;

    public static Connection getConn() throws ClassNotFoundException {
        Class.forName(driver);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

    public static void closeConn() throws SQLException {
        if(conn != null)
            conn.close();
    }

}
