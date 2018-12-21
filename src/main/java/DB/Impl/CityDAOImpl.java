package DB.Impl;

import DB.DBConnection;
import DB.VO.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl {


    public void insertObj(City city) {

        try {
            String sql = "insert into city (name) values(?)";

            PreparedStatement stmt = DBConnection.getConn().prepareStatement(sql);
            stmt.setString(1,city.getName()==null?"":city.getName());

            System.out.println(sql);
            stmt.executeUpdate();
            DBConnection.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        @Override
        public void insertAll(List<City > citys) {

        }

        @Override
        public void deleteObj(City city) {

        }

        @Override
        public void deleteObjs(List<City> city) {

        }

        @Override
        public void updateObj(City city) {

        }

        @Override
        public void updateAll(List<City> city) {

        }

        @Override
        public City queryOne(City city) {
            return null;
        }

        @Override
        public City queryOne(Object key) {
            return null;
        }

        @Override
        public List<City> queryAll() {
            List<City> books = new ArrayList<>();
            try {
                Statement stmt = DBConnection.getConn().createStatement();
                String sql = "select * from book";

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    City book = new City();
                    City.setId(rs.getInt("id");
                    City.setName(rs.getString("name"));
                    books.add(City);
                }
                rs.close();
                DBConnection.closeConn();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return books;
        }
    }
}
