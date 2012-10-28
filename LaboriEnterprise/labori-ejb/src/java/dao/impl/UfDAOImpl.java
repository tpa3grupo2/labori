package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.Uf;

public class UfDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public UfDAOImpl() {
        super(Uf.class);
    }
}
