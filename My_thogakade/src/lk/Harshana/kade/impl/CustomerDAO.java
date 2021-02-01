package lk.Harshana.kade.impl;

import lk.Harshana.kade.dao.SuperDAO;
import lk.Harshana.kade.Entity.Customer;

public interface CustomerDAO extends SuperDAO<Customer,String > {
    public String getclassCustomerID()throws  Exception;


}
