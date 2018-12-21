package DB.DAO;

import DB.VO.City;

import java.util.List;

public interface CityDAO {
    void insertobj(City city);
    void insertAll(List<City> city);

    void deleteObj(City city);
    void deleteObjs(List<City> City);

    void updateObj(City city);
    void updateAll(List<City> city);

    City queryOne(City city);
    City queryOne(Object key);
    List<City> queryAll();
}
