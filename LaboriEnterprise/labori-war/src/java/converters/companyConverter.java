package converters;

import ejb.stateless.CompanyBeanLocal;
import entity.Company;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

@FacesConverter(value="companyConverter", forClass=entity.Company.class)
public class companyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        CompanyBeanLocal companyEJB = null;

        if (value.equals(""))
            return null;

        try {
            companyEJB = new util.GetEJB().getCompany();
        } catch (NamingException ex) {
            Logger.getLogger(companyConverter.class.getName()).log(Level.SEVERE, null, ex);

            FacesMessage msg = new FacesMessage("Erro de comunicação com o EJB");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }

        Company company = companyEJB.getById(Long.parseLong(value));

        if (company == null) {
            FacesMessage msg = new FacesMessage("Por favor entre com uma empresa válida.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return company;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String)
            return "";

        Company obj = (Company) value;
        return obj.getId().toString();
    }

}
