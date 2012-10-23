
package mb;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@RequestScoped
public class utilsBean {

    private Integer tableCounter = 1;

    public Integer getInitTableCounter() {
        tableCounter = 1;
        return tableCounter;
    }

    public Integer getTableCounter() {
        return tableCounter++;
    }
}
