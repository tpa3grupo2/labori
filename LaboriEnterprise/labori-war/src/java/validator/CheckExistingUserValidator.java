package validator;

import entity.UserLabori;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

@FacesValidator("validator.CheckExistingUser")
public class CheckExistingUserValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query = session.createQuery("select count(u) from UserLabori u where email = :email")
                .setParameter("email", value.toString());

        
        Long numNameDuplicates = (Long) query.uniqueResult();
        if (numNameDuplicates > 0) {
            FacesMessage msg = new FacesMessage("Esse email já está cadastrado. Efetue o login.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}