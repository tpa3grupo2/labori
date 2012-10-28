package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.Company;

public class CompanyDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public CompanyDAOImpl() {
        super(Company.class);
    }
}
