package dao.impl;

import dao.BaseDAOInterface;
import dao.BaseHibernateDAO;
import entity.Field;

public class FieldDAOImpl<T, PK> extends BaseHibernateDAO implements BaseDAOInterface {
    private static final long serialVersionUID = 1L;

    public FieldDAOImpl() {
        super(Field.class);
    }
}
