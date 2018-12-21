import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Connectmysql {
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/world@localhost";
    String username="root";
    String pwd="123456";
    List<City> citys = new ArrayList<City>();


    public List<City> search() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, pwd);
        Statement stmt = conn.createStatement();

        String sql = "select * from city";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            City city = new City();
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            citys.add(city);
        }
        rs.close();
        conn.close();

        for(City c : citys)
            System.out.println(c.toString());

        Iterator it = citys.iterator();
        while(it.hasNext())
            System.out.println(it.next().toString());
        return citys;


    }
    public void insert(City city) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, pwd);
        Statement stmt = conn.createStatement();

        String sql = "insert into book (name) values('" + city.getName() + "')";

        System.out.println(sql);

        stmt.executeUpdate(sql);
        conn.close();
    }
}
