package converters;

import entity.Uf;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import util.GeneralFactory;

@FacesConverter(value="UfConverter", forClass=entity.Uf.class)
public class UfConverter implements Converter {

    private GeneralFactory<entity.Uf> ufFactory = new GeneralFactory<entity.Uf>("Uf");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals(""))
            return null;

        Uf uf = ufFactory.getById(Integer.parseInt(value));

        if (uf == null) {
            FacesMessage msg = new FacesMessage("Por favor entre com uma UF válida.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return uf;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String)
            return "";

        Uf uf = (Uf) value;
        return uf.getId().toString();
    }

}
