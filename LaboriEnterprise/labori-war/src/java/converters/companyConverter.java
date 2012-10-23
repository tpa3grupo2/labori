package converters;

import entity.Company;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import util.GeneralFactory;

@FacesConverter(value="companyConverter", forClass=entity.Company.class)
public class companyConverter implements Converter {

    private GeneralFactory<entity.Company> universityFactory = new GeneralFactory<entity.Company>("Company");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals(""))
            return null;

        Company field = universityFactory.getById(Integer.parseInt(value));

        if (field == null) {
            FacesMessage msg = new FacesMessage("Por favor entre com uma empresa válida.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return field;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String)
            return "";

        Company obj = (Company) value;
        return obj.getId().toString();
    }

}
