package converters;

import ejb.stateless.UniversityBeanLocal;
import entity.University;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

@FacesConverter(value="universityConverter", forClass=entity.University.class)
public class universityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        UniversityBeanLocal universityEJB = null;

        if (value.equals(""))
            return null;

        try {
            universityEJB = new util.GetEJB().getUniversity();
        } catch (NamingException ex) {
            Logger.getLogger(universityConverter.class.getName()).log(Level.SEVERE, null, ex);

            FacesMessage msg = new FacesMessage("Erro de comunicação com o EJB");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }

        University university = universityEJB.getById(Long.parseLong(value));

        if (university == null) {
            FacesMessage msg = new FacesMessage("Por favor entre com uma universidade válida.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return university;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String)
            return "";

        University field = (University) value;
        return field.getId().toString();
    }

}
