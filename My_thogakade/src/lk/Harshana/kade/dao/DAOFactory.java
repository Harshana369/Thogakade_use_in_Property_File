package lk.Harshana.kade.dao;

import lk.Harshana.kade.impl.CustomerDAOImpl;
import lk.Harshana.kade.impl.DAOType;


public class DAOFactory {
    private static DAOFactory daoFactory;


    private DAOFactory(){

        }

        public static DAOFactory getInstance(){
            return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
        }
        public <T extends SuperDAO> T getDAO(DAOType daoType){
            switch (daoType){
                case CUSTOMER:
                    return (T) new CustomerDAOImpl();

                default:
                    return null;
            }

        }
}
