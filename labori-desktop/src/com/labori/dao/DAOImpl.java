package com.labori.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;

public class DAOImpl<T, PK extends Serializable> implements IDAO<T, PK> {

	protected Class<T> persistentClass;
	
	  public List<T> findAll() {
        return findByCriteria();
    }
	  
	@SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(persistentClass);
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		
		Criteria crit = session.createCriteria(persistentClass);
        for (Criterion c : criterion) {
            crit.add(c);
        }
		session.getTransaction().commit();

		session.close();
			  
		
        return crit.list();
   }
 
	
	@Override
	public PK create(T newInstance) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(newInstance.getClass());
		cfg.configure();

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		PK id = (PK)session.merge(newInstance);
		session.getTransaction().commit();

		session.close();

		return id;
	}

	@Override
	public T read(PK id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void update(T transientObject) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(T persistentObject) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(persistentObject.getClass());
		cfg.configure();

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		session.delete(persistentObject);
		session.getTransaction().commit();

		session.close();

	}
}
