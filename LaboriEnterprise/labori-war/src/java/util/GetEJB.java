
package util;

import ejb.stateless.UserLaboriBeanLocal;
import ejb.stateless.UniversityBeanLocal;
import ejb.stateless.CompanyBeanLocal;
import ejb.stateless.UfBeanLocal;
import ejb.stateless.FieldBeanLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GetEJB {

    private InitialContext ctx;

    private void getContext() throws NamingException {
        ctx = new InitialContext();
    }

    public UserLaboriBeanLocal getUserLabori() throws NamingException {
        getContext();
        return (UserLaboriBeanLocal) ctx.lookup("ejb/userLabori");
    }

    public UfBeanLocal getUf() throws NamingException {
        getContext();
        return (UfBeanLocal) ctx.lookup("ejb/uf");
    }

    public FieldBeanLocal getField() throws NamingException {
        getContext();
        return (FieldBeanLocal) ctx.lookup("ejb/field");
    }

    public UniversityBeanLocal getUniversity() throws NamingException {
        getContext();
        return (UniversityBeanLocal) ctx.lookup("ejb/university");
    }

    public CompanyBeanLocal getCompany() throws NamingException {
        getContext();
        return (CompanyBeanLocal) ctx.lookup("ejb/company");
    }
}
