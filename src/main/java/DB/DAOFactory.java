package DB;

import DB.DAO.CityDAO;
import DB.Impl.CityDAOImpl;

public class DAOFactory {
    public static CityDAO getCityDAOImpl{
        return new CityDAOImpl();
    }
}
