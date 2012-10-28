package validator;

import entity.UserLabori;
import ejb.stateless.UserLaboriBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;

@FacesValidator("validator.CheckExistingUser")
public class CheckExistingUserValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        UserLaboriBeanLocal userLaboriEJB = null;

        try {
            userLaboriEJB = new util.GetEJB().getUserLabori();
        } catch (NamingException ex) {
            Logger.getLogger(CheckExistingUserValidator.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessage msg = new FacesMessage("Erro de comunicação com o EJB");
            throw new ValidatorException(msg);
        }

        if (userLaboriEJB.getByEmail(value.toString()) != null) {
            FacesMessage msg = new FacesMessage("Esse email já está cadastrado. Efetue o login.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}