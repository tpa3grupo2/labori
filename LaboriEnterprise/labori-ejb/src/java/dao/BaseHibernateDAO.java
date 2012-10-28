package dao;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import util.HibernateUtil;

public abstract class BaseHibernateDAO<T, PK extends Serializable> implements BaseDAOInterface<T, PK>, PropertySelector {
    private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    private static final Log logger = LogFactory.getLog(BaseHibernateDAO.class);
    private final Class objectClass;

    public BaseHibernateDAO(final Class objectClass) {
        this.objectClass = objectClass;
    }

    public Session getSession() {
        return getSession(true);
    }

    public void resetSession() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession(Boolean create) {
        if (!session.isOpen())
            session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }

    public void startTransaction() {
        getSession().beginTransaction();
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class getObjectClass() {
        return objectClass;
    }

    @Override
    public int findByExamplePageCount(final T example) {
        final List l = findByExample(example);
        final Integer i = new Integer(l.size());
        return i.intValue();
    }

    @Override
    public int listAllPageCount() {
        final List l = listAll();
        final Integer i = new Integer(l.size());
        return i.intValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see br.ufrgs.hcpa.template.dao.GetNetBaseDao#findOneByExample(T)
     */
    @Override
    public T findOneByExample(final T example) {
        final List<T> res = findByExample(example, 0, 1);
        if ((res != null) && (res.size() == 1)) {
            return res.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T save(final T object) {
        try {
            final Session s = getSession(false);
            s.save(object);
            s.flush();
            return object;
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void update(final T object) {
        try {
            final Session s = getSession(false);
            s.update(object);
            s.flush();
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void rebind(final T object) {
        try {
            getSession(false).refresh(object);
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    public void delete(final T object) {
        try {
            getSession(false).delete(object);
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T load(final PK primaryKey) {
        try {
            final Session s = getSession(false);
            final Object o = s.load(objectClass, primaryKey);
            return (T) o;
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(final PK primaryKey) {
        try {
            final Session s = getSession(false);
            final Object o = s.load(objectClass, primaryKey);
            return (T) o;
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List listAll() {
        try {
            final Session s = getSession(false);
            final Criteria c = s.createCriteria(objectClass);
            return c.list();
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findByExample(final T example) {
        try {
            final Session s = getSession(false);
            final Criteria c = s.createCriteria(objectClass);
            c.add(Example.create(example).enableLike(MatchMode.ANYWHERE).ignoreCase().setPropertySelector(this));
            addPropertiedToCriteria(c, example);
            return c.list();
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    protected void addPropertiedToCriteria(final Criteria c, final T example) {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List findByExample(final T example, final int first, final int max) {
        try {
            final Session s = getSession(false);
            final Criteria c = s.createCriteria(objectClass);
            c.add(Example.create(example).enableLike(MatchMode.ANYWHERE).ignoreCase().setPropertySelector(this));
            addPropertiedToCriteria(c, example);
            if (first != 0) {
                c.setFirstResult(first);
            }
            if (max != 0) {
                c.setMaxResults(max);
            }
            return c.list();
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List listAll(final int first, final int max) {
        try {
            final Session s = getSession(false);
            final Criteria c = s.createCriteria(objectClass);
            if (first != 0) {
                c.setFirstResult(first);
            }
            if (max != 0) {
                c.setMaxResults(max);
            }
            return c.list();
        } catch (final HibernateException ex) {
            BaseHibernateDAO.logger.error(ex);
            throw ex;
        }
    }

    @Override
    public boolean include(Object propertyValue, String propertyName, Type type) {
        if((propertyValue!=null) && (propertyValue instanceof String)){
            return !"".equals(((String)propertyValue).trim());
        }
        return propertyValue!=null;
    }
}
