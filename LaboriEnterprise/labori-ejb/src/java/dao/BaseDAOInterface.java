package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAOInterface<T, PK extends Serializable> {

    public Class getObjectClass();

    public T save(T object);
    public T load(PK primaryKey);
    public T get(PK primaryKey);

    public List<T> listAll();
    
    public List<T> findByExample(final T example);
    public T findOneByExample(final T example);

    public List<T> listAll(final int first,final int max);
    public int listAllPageCount();

    public List<T> findByExample(final T example,final int first,final int max);
    public int findByExamplePageCount(final T example);

    public void update(T object);
    public void delete(T object);
    public void rebind(T object);
}