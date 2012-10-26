package util;

import entity.UserLabori;
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

    public List<T> getAllfromUser(UserLabori user) {
        session.beginTransaction();

        Query query = session.createQuery("from " + className + " where user_id = :user_id")
                        .setParameter("user_id", user.getId());

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

        session.clear();
        session.beginTransaction();
	Long id = (Long) session.save(newObject);
        session.getTransaction().commit();

        return id;
    }

    public void update(Object changedObject) {
        session.clear();
        session.beginTransaction();
	session.update(changedObject);
        session.getTransaction().commit();
    }

    public T getById(Integer id) {
        session.beginTransaction();
        Query query = session.createQuery("from " + className + " where id = :id")
                       .setParameter("id", id);

        return (T) query.uniqueResult();
    }

    public void remove(T obj) {
        session.clear();
        session.beginTransaction();
	session.delete(obj);
        session.getTransaction().commit();
    }

    public void removeFromId(Integer id) {
        remove(getById(id));
    }
}
