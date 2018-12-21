package d;

import DB.DAOFactory;
import DB.VO.City;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CityBusiness {
    static List<City> business(HttpServletRequest request) {
        String name = request.getParameter("name");
        City book = new City();
        book.setName(name);
        List<City> city = new ArrayList<City>();
        DAOFactory.getCityDAOImpl().insertobj(city);
        city = DAOFactory.getCityDAOImpl().queryAll();

        return city;
    }
}
