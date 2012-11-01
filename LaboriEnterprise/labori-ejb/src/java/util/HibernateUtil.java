package util;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final AnnotationConfiguration config;

    static {
        try {
            config = new AnnotationConfiguration()
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Education.class)
                .addAnnotatedClass(Field.class)
                .addAnnotatedClass(Uf.class)
                .addAnnotatedClass(University.class)
                .addAnnotatedClass(UserLabori.class)
                .addAnnotatedClass(WorkExperience.class)
                .addAnnotatedClass(JobVacancy.class)
                .configure();

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static AnnotationConfiguration getConfiguration() {
        return config;
    }
}
