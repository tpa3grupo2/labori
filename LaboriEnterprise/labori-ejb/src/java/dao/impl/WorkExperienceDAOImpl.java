package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.WorkExperience;

public class WorkExperienceDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public WorkExperienceDAOImpl() {
        super(WorkExperience.class);
    }
}
