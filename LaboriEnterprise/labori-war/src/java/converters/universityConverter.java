package converters;

import entity.University;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import util.GeneralFactory;

@FacesConverter(value="universityConverter", forClass=entity.University.class)
public class universityConverter implements Converter {

    private GeneralFactory<entity.University> universityFactory = new GeneralFactory<entity.University>("University");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals(""))
            return null;

        University field = universityFactory.getById(Integer.parseInt(value));

        if (field == null) {
            FacesMessage msg = new FacesMessage("Por favor entre com uma universidaide válida.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return field;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String)
            return "";

        University field = (University) value;
        return field.getId().toString();
    }

}
