package laboriempresa.util;

import ejb.stateless.CompanyBeanLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GetEJB {

    private InitialContext ctx;

    private void getContext() throws NamingException {
        ctx = new InitialContext();
    }

    public CompanyBeanLocal getCompany() throws NamingException {
        getContext();
        return (CompanyBeanLocal) ctx.lookup("ejb/company");
    }
}
