import ejb.stateless.UfBeanLocal;
import ejb.stateless.CompanyBeanLocal;
import entity.Company;
import entity.Uf;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EjbTestClient {

    public static void main(String[] args) throws NamingException {

        InitialContext ctx = new InitialContext();

        UfBeanLocal ufb = (UfBeanLocal) ctx.lookup("ejb/uf");
        CompanyBeanLocal companyb = (CompanyBeanLocal) ctx.lookup("ejb/company");

        System.out.println(ufb.getById(35L));
        for (Uf uf : ufb.getAll()) {
            System.out.println(uf);
        }

        System.out.println(companyb.getById(3L));
        for (Company x : companyb.getAll()) {
            System.out.println(x);
        }


    }

}
