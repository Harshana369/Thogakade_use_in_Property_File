package lk.Harshana.kade.util;

import lk.Harshana.kade.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguretion {
    private static FactoryConfiguretion factoryConfiguretion;
    private SessionFactory sessionFactory;


    private FactoryConfiguretion(){
        Configuration configure = new Configuration().configure()
                .addAnnotatedClass(Customer.class);
        sessionFactory = configure.buildSessionFactory();
    }

    public static FactoryConfiguretion getInstance(){
        return (factoryConfiguretion == null ? factoryConfiguretion = new FactoryConfiguretion() : factoryConfiguretion);
    }

    public Session getsession(){
        return sessionFactory.openSession();
    }


}
