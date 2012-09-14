package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator.CheckExistingUser")
public class CheckExistingUserValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        FacesMessage msg = new FacesMessage("E-mail validation failed.",
                "NOSSA Invalid E-mail format." + value.toString());
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(msg);
    }
}