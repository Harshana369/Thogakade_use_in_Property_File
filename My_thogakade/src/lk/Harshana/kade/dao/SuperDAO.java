package lk.Harshana.kade.dao;

import lk.Harshana.kade.Entity.Customer;
import lk.Harshana.kade.Entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable> {

    public boolean add(Entity entity)throws Exception;

    public  boolean delete(Customer id)throws Exception;

    public boolean update(Entity entity) throws Exception;

    public Customer find(ID id)throws Exception;

    public List<Entity> getAll () throws Exception;

    public Entity search (ID id)throws Exception;

}
