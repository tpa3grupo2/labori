package dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DAOImpl<T, PK extends Serializable> implements IDAO<T, PK> {

	@Override
	public PK create(T newInstance) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(newInstance.getClass());
		cfg.configure();

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		PK id = (PK)session.save(newInstance);
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
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
