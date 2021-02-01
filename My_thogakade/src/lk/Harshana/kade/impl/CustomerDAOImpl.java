package lk.Harshana.kade.impl;

import lk.Harshana.kade.Entity.Customer;
import lk.Harshana.kade.util.FactoryConfiguretion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer entity) throws Exception {
        Session session = FactoryConfiguretion.getInstance().getsession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Customer s) throws Exception {
        Session session = FactoryConfiguretion.getInstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.delete(s);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        Session session = FactoryConfiguretion.getInstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Customer find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        Session session = FactoryConfiguretion.getInstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Customer");
        List<Customer> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public Customer search(String s) throws Exception {
        Session session = FactoryConfiguretion.getInstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Customer WHERE id = ?1");
        query.setParameter(1 ,s);
        Customer customer = (Customer) query.uniqueResult();
        transaction.commit();
        session.close();
        return customer;


    }


    @Override
    public String getclassCustomerID() throws Exception {
        Session session = FactoryConfiguretion.getInstance().getsession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select  id from Customer order by id desc limit 1");
        String id = (String) sqlQuery.uniqueResult();

        transaction.commit();
        session.close();
        return id;
    }
}
