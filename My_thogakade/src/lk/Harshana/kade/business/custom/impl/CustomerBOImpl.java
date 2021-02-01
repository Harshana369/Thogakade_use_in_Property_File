package lk.Harshana.kade.business.custom.impl;

import lk.Harshana.kade.Entity.Customer;
import lk.Harshana.kade.business.custom.CustomerBO;
import lk.Harshana.kade.dao.DAOFactory;
import lk.Harshana.kade.dao.SuperDAO;
import lk.Harshana.kade.dto.CustomerDTO;
import lk.Harshana.kade.impl.CustomerDAO;
import lk.Harshana.kade.impl.CustomerDAOImpl;
import lk.Harshana.kade.impl.DAOType;
import sun.plugin2.message.CustomSecurityManagerRequestMessage;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);


    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return  customerDAO.add(new Customer(customer.getId(),customer.getName(),customer.getAddress()));

    }

    @Override
    public String newCustomerID() throws Exception {
        String lastID = customerDAO.getclassCustomerID();

        int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;

        if (newID < 10){
            return "C00"+newID;
        }else if (newID < 100){
            return "C0"+newID;
        }else {
            return "C"+newID;
        }
    }

    @Override
    public List<CustomerDTO> findall() throws Exception {
        List<Customer> all = customerDAO.getAll();
        List<CustomerDTO> list = new ArrayList<>();
        for (Customer c : all){
            list.add(new CustomerDTO(c.getId(),
                    c.getName(),c.getAddress()));

        }
    return list;
    }

    @Override
    public boolean deleteCustomwer(CustomerDTO customer)throws Exception{
        return customerDAO.delete(new Customer(customer.getId(),
                customer.getName(),customer.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getId(),
                customer.getName(),customer.getAddress()));
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer search = customerDAO.search(id);
        return  new CustomerDTO(search.getId(),search.getName(),search.getAddress());
    }
}
