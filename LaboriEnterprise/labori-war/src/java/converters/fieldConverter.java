package converters;

import ejb.stateless.FieldBeanLocal;
import entity.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

@FacesConverter(value="fieldConverter", forClass=entity.Field.class)
public class fieldConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FieldBeanLocal fieldEJB = null;

        if (value.equals(""))
            return null;

        try {
            fieldEJB = new util.GetEJB().getField();
        } catch (NamingException ex) {
            Logger.getLogger(fieldConverter.class.getName()).log(Level.SEVERE, null, ex);

            FacesMessage msg = new FacesMessage("Erro de comunicação com o EJB");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }

        Field field = fieldEJB.getById(Long.parseLong(value));

        if (field == null) {
            FacesMessage msg = new FacesMessage("Por favor entre com um campo válido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return field;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String)
            return "";

        Field field = (Field) value;
        return field.getId().toString();
    }

}
