package by.htp.applience.dao;

import java.util.List;

public interface ApplienceDao {
	
	List<String> findProduct(String productName, String searchStr) throws DaoException;
	List<String> find(String productName, String searchStr) throws  DaoException;
}
