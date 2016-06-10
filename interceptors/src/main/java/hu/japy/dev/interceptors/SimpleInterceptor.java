package hu.japy.dev.interceptors;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
//@Simple
public class SimpleInterceptor implements Serializable {
    
    private static final long serialVersionUID = 1692680522818682847L;
    
    @AroundInvoke
    public Object doSomething(InvocationContext context) throws Exception {
        System.out.println("beginning: " + this.getClass().getCanonicalName());
        final Object result = context.proceed();
        System.out.println("ending: " + this.getClass().getCanonicalName());
        return result;
    }

}
