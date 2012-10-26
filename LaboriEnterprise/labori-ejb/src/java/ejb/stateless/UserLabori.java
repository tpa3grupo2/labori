/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.stateless;

import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author cauethenorio
 */
@Stateless
public class UserLabori implements UserLaboriLocal {

    @Override
    public List<entity.UserLabori> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public entity.UserLabori getById() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(entity.UserLabori user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(entity.UserLabori user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean checkPassword(entity.UserLabori user, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
