package biz.hahamo.dev.javaee.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Interceptor to handle big list database calling.
 * 
 * @author GHajba
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BigListInterceptor {

    private static final int MAX_LIST_SIZE = 1000;

    @AroundInvoke
    public Object interceptBigList(final InvocationContext ctx) throws Exception {

        Object[] parameters = ctx.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            if (!(parameters[i] instanceof Collection)) {
                continue;
            }

            List source = new ArrayList((Collection) parameters[i]);

            if (isNoBigList(source)) {
                continue;
            }

            List<List<?>> listOfLists = CollectionUtils.splitLongList(source, MAX_LIST_SIZE);

            return callMethodForSmallLists(ctx, parameters, i, listOfLists, source.size());
        }

        return ctx.proceed();
    }

    private Object callMethodForSmallLists(final InvocationContext ctx, final Object[] parameters, final int i,
            final List<List<?>> listOfLists, final int resultSize) throws Exception {

        boolean voidMethod = isVoidMethod(ctx);
        boolean booleanMethod = isBooleanMethod(ctx);
        Object result = new ArrayList(resultSize);
        boolean boolResult = false;
        for (List<?> l : listOfLists) {
            parameters[i] = l;
            ctx.setParameters(parameters);
            Object resultObj = ctx.proceed();

            if (voidMethod) {
                continue;
            } else if (isBooleanMethod(ctx) && resultObj != null) {
                boolResult = boolResult && (Boolean) resultObj;
            } else {
                List tList = (List) resultObj;
                if (tList != null) {
                    ((List) result).addAll(tList);
                }
            }
        }
        return booleanMethod ? boolResult : result;
    }

    private boolean isNoBigList(final List<?> source) {

        return source != null && source.size() <= MAX_LIST_SIZE;
    }

    private boolean isVoidMethod(final InvocationContext ctx) {

        return ctx.getMethod().getReturnType() == void.class;
    }

    private boolean isBooleanMethod(final InvocationContext ctx) {

        return ctx.getMethod().getReturnType() == boolean.class || ctx.getMethod().getReturnType() == Boolean.class;
    }

}
