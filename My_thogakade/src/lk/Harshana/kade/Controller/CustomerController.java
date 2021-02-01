package lk.Harshana.kade.Controller;

import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.util.DnsSrv;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.Harshana.kade.business.BOFactory;
import lk.Harshana.kade.business.BOType;
import lk.Harshana.kade.business.SuperBO;
import lk.Harshana.kade.business.custom.CustomerBO;
import lk.Harshana.kade.business.custom.impl.CustomerBOImpl;
import lk.Harshana.kade.dto.CustomerDTO;

import java.util.List;
import java.util.stream.Stream;

public class CustomerController {
    public JFXTextField txtaddress;
    public JFXTextField txtname;
    public JFXTextField txtid;
    public TableView tblcustomer;
    public TableColumn tblid;
    public TableColumn tblname;
    public TableColumn tbladdress;

    CustomerBO customerBO = BOFactory.getInstance().getbo(BOType.CUSTOMER);

    public void initialize(){
        txtid.setText(genatyetanewID());

        get();
    }


    public void saveOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address);

        try {
            boolean added = customerBO.addCustomer(customer);

            if (added){

                get();
                new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
            }


            txtname.clear();
            txtaddress.clear();
            txtid.setText(genatyetanewID());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // ID eka Create
    public String genatyetanewID(){
      String s =null;

        try {
            s = customerBO.newCustomerID();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }


    public void DeleteOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address);
        boolean added = false;

        try {
            added = customerBO.deleteCustomwer(customer);

            if(added){

                get();
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Remove Succcesfull").showAndWait();
            }else {
                new Alert(Alert.AlertType.WARNING,"not delete").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Table eka lode
    public void get(){

        try {

            List<CustomerDTO> cusList = customerBO.findall();
            ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
            list.addAll(cusList);
            tblcustomer.setItems(list);
            tblid.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("id"));
            tblname.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("name"));
            tbladdress.setCellValueFactory(new PropertyValueFactory<CustomerDTO, String>("address"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }



    public void UpdateOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();

        CustomerDTO customerDTO = new CustomerDTO(id, name, address);

        boolean added = false;

            try {
                added = customerBO.updateCustomer(customerDTO);

                if(added){
                    get();
                    new Alert(Alert.AlertType.CONFIRMATION,"update ok").showAndWait();
                }else {

                    new Alert(Alert.AlertType.WARNING,"Fail",ButtonType.OK).show();

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void SearchOnAction(ActionEvent actionEvent) {
       String id = txtid.getText();

        try {
            CustomerDTO customerDTO = customerBO.searchCustomer(id);

        if(customerDTO != null){
          txtid.setText(customerDTO.getId());
          txtname.setText(customerDTO.getName());
          txtaddress.setText(customerDTO.getAddress());
      }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

