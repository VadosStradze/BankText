package by.htp.applience.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.applience.dao.ApplienceDao;
import by.htp.applience.dao.DaoException;

public class FileApplienceDao implements ApplienceDao{

	private static final String RESOURCE_APPLIANCES_TXT = "/home/vadim/appliances.txt";
	
	@Override
	public List<String> findProduct(String type, String searchStr) throws DaoException {
		StringBuilder applience = new StringBuilder();
		String string ;
		try(BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_APPLIANCES_TXT))){
			String line;
			while((line = reader.readLine()) != null) {
				if(line.contains(type) && line.contains(searchStr)) {
					string = line;
					return data(string);
				}
			}
		} catch (FileNotFoundException e) {
			throw new DaoException("Check file name or path.", e);
		} catch (IOException e) {
			throw new DaoException("Check file.", e);
		}
		return data(applience.toString());
	}

	@Override
	public List<String> find(String productName, String searchStr) throws DaoException {
		return null;
	}

	private List<String> data(String data) {
        String[] step = data.split(": ")[1].split(",");
        List<String> product = new ArrayList<>();
        for (String str : step) {
            product.add(str.split("=")[1]);
        }
        return product;
    }
}
