package by.htp.applience.service.impl;

import java.util.List;

import by.htp.applience.dao.ApplienceDao;
import by.htp.applience.dao.DaoException;
import by.htp.applience.dao.DaoProvider;
import by.htp.applience.dao.impl.FileApplienceDao;
import by.htp.applience.entity.Applience;
import by.htp.applience.entity.device.Laptop;
import by.htp.applience.entity.device.Oven;
import by.htp.applience.entity.device.Refrigerator;
import by.htp.applience.entity.device.Speakers;
import by.htp.applience.entity.device.TabletPC;
import by.htp.applience.entity.device.VacuumCleaner;
import by.htp.applience.service.ApplienceService;
import by.htp.applience.service.ServiceException;

public class ApplienceServiceImpl implements ApplienceService {
    private FileApplienceDao fileApplienceDao;

    @Override
    public Applience find(String request) throws ServiceException {
        return null;
    }
    @Override
    public Applience findProduct(String request) throws ServiceException {


        String[] params = request.split("\\s+");
        String productName = params[1];
        String searchStr = params[2].split("=")[0];

        DaoProvider provider = DaoProvider.getInstance();
        ApplienceDao applienceDao = provider.getApplienceDao();

        List<String> data;
        try {
            data = applienceDao.findProduct(productName, searchStr);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }





        Applience toReturn = null;
        switch (productName) {
            case "Oven":


                toReturn = new Oven("Oven", 200, Integer.parseInt(data.get(0)), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)));
                break;
            case "Laptop":
                toReturn = new Laptop("Laptop", Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), data.get(3), Integer.parseInt(data.get(4)), Integer.parseInt(data.get(5)),
                        Integer.parseInt(data.get(6)), Integer.parseInt(data.get(7)));

                break;
            case "Refregirator":
                toReturn = new Refrigerator("Refrigerator", 200, Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), Integer.parseInt(data.get(4))
                        , Integer.parseInt(data.get(6)), Integer.parseInt(data.get(7)));
                break;
            case "VacuumCleaner":
                toReturn = new VacuumCleaner("VacuumCleaner", 900, Integer.parseInt(data.get(1)), data.get(2), data.get(3), data.get(4), Integer.parseInt(data.get(5)),
                        Integer.parseInt(data.get(7)));
                break;
            case "TabletPC":
                toReturn = new TabletPC("TablePC", 400,Integer.parseInt(data.get(0)) , Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)), data.get(4));
                break;
            case "Speakers":
                toReturn = new Speakers("Speakers", 600, Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)), Integer.parseInt(data.get(3)),
                        Integer.parseInt(data.get(5)));
                break;
            default:
                throw new IllegalArgumentException("Wrong type of applience");
        }
        return toReturn;
    }



}
