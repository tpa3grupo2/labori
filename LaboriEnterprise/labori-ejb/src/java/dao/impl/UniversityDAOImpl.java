package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.University;

public class UniversityDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public UniversityDAOImpl() {
        super(University.class);
    }
}
