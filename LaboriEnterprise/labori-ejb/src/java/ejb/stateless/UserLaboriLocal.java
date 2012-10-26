package ejb.stateless;

import entity.UserLabori;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cauethenorio
 */
@Local
public interface UserLaboriLocal {
    
    public List<UserLabori> getAll();
    public UserLabori getById();
    public void update(UserLabori user);
    public boolean remove(UserLabori user);
    public boolean checkPassword(UserLabori user, String password);

}
