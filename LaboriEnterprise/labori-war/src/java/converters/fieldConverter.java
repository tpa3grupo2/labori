package converters;

import entity.Field;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import util.GeneralFactory;

@FacesConverter(value="fieldConverter", forClass=entity.Field.class)
public class fieldConverter implements Converter {

    private GeneralFactory<entity.Field> fieldFactory = new GeneralFactory<entity.Field>("Field");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals(""))
            return null;

        Field field = fieldFactory.getById(Integer.parseInt(value));

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
