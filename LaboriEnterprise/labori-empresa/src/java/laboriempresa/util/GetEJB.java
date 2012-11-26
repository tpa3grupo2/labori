package laboriempresa.util;

import ejb.stateless.CompanyBeanLocal;
import ejb.stateless.UserLaboriBeanLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GetEJB {

    private InitialContext ctx;

    public GetEJB() throws NamingException {
        getContext();
    }

    private void getContext() throws NamingException {
        ctx = new InitialContext();
    }

    public CompanyBeanLocal getCompany() throws NamingException {
        return (CompanyBeanLocal) ctx.lookup("ejb/company");
    }

    public UserLaboriBeanLocal getUserLabori() throws NamingException {
        return (UserLaboriBeanLocal) ctx.lookup("ejb/userLabori");
    }

}
