package util;

import java.util.ArrayList;
import java.util.Set;
import javax.el.ELContext;
import javax.el.ListELResolver;

public class SetToListELResolver extends ListELResolver {

    public static final String KEY_PROPERTY = "setToList";

    @Override
    public Object getValue(ELContext context, Object base, Object property) {
        if (base instanceof Set<?> && KEY_PROPERTY.equals(property)) {
            context.setPropertyResolved(true);
            return new ArrayList<Object>((Set<?>) base);
        }

        return super.getValue(context, base, property);
    }

}