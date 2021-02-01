package lk.Harshana.kade.business.custom;

import lk.Harshana.kade.business.SuperBO;
import lk.Harshana.kade.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customer)throws Exception;

    public String newCustomerID()throws Exception;

   List<CustomerDTO> findall()throws Exception;

    boolean deleteCustomwer(CustomerDTO customer) throws Exception;

    boolean updateCustomer(CustomerDTO customerDTO)throws Exception;

    CustomerDTO searchCustomer(String id)throws Exception;

}
