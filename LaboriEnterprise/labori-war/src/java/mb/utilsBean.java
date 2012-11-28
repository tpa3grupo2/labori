
package mb;

import entity.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.NamingException;
import util.GetEJB;

@ManagedBean
@RequestScoped
public class utilsBean {

    private Integer tableCounter = 1;
    private Map<String, Double> stats;
    private Field field;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
    
    public Map<String, Double> getStats() {
        return stats;
    }

    public void setStats(Map<String, Double> stats) {
        this.stats = stats;
    }

    public Integer getInitTableCounter() {
        tableCounter = 1;
        return tableCounter;
    }

    public Integer getTableCounter() {
        return tableCounter++;
    }


    public String realFormat(Float value) {
        DecimalFormat df  = new DecimalFormat("###,###,##0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        return df.format(value);
    }

    public String simpleFormat(Float value) {
        DecimalFormat df  = new DecimalFormat("###,###,###", new DecimalFormatSymbols(new Locale("pt","BR")));
        return df.format(value);
    }

    
    public void getStatsByField() throws NamingException {
        stats = new GetEJB().getCompany().getStatsByField(field);
    }
    
}
