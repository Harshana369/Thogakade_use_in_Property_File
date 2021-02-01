package lk.Harshana.kade.business;

import lk.Harshana.kade.business.custom.CustomerBO;
import lk.Harshana.kade.business.custom.impl.CustomerBOImpl;

public class BOFactory {
    private static BOFactory boFactory;


    private  BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null ? boFactory = new BOFactory() : boFactory);
    }

    public <T extends SuperBO>T getbo(BOType boType){
            switch (boType){
                case CUSTOMER:
                    return (T) new CustomerBOImpl();
                default:
                    return null;
        }


    }
}
