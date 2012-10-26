package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.UserLabori;

public class UserDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public UserDAOImpl() {
        super(UserLabori.class);
    }
}
