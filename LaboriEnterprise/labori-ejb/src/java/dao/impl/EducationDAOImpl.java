package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.Education;

public class EducationDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public EducationDAOImpl() {
        super(Education.class);
    }
}
