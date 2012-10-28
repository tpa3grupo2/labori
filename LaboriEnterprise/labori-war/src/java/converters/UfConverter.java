package converters;

import ejb.stateless.UfBeanLocal;
import entity.Uf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

@FacesConverter(value="UfConverter", forClass=entity.Uf.class)
public class UfConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        UfBeanLocal ufEJB = null;

        if (value.equals(""))
            return null;

        try {
            ufEJB = new util.GetEJB().getUf();
        } catch (NamingException ex) {
            Logger.getLogger(UfConverter.class.getName()).log(Level.SEVERE, null, ex);

            FacesMessage msg = new FacesMessage("Erro de comunicação com o EJB");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }

        Uf uf = ufEJB.getById(Long.parseLong(value));

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
