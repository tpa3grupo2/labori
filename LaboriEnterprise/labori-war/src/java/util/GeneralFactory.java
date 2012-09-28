package util;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class GeneralFactory<T> {

    private String className;
    private Session session;

    public GeneralFactory(String className) {
        this.className = className;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<T> getAll() {
        session.beginTransaction();

        Query query = session.createQuery("from " + className);
        return (List<T>) query.list();
    }

    public T getById(String id) {
        try {
            return getById(Integer.parseInt(id));
        } catch(NumberFormatException e) {
            return null;
        }
    }

    public Long create(Object newObject) {

        session.beginTransaction();
	Long id = (Long) session.save(newObject);
        session.getTransaction().commit();

        return id;
    }

    public T getById(Integer id) {
        session.beginTransaction();
        Query query = session.createQuery("from " + className + " where id = :id")
                       .setParameter("id", id);

        return (T) query.uniqueResult();
    }
}
