
package mb;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
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

    public String realFormat(Float value) {
        DecimalFormat df  = new DecimalFormat("###,###,###.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        return df.format(value);
    }

}
