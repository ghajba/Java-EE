package hu.japy.dev.extension;

import java.util.Arrays;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.AfterTypeDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.BeforeShutdown;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.ProcessBean;
import javax.enterprise.inject.spi.ProcessBeanAttributes;
import javax.enterprise.inject.spi.ProcessInjectionPoint;
import javax.enterprise.inject.spi.ProcessInjectionTarget;
import javax.enterprise.inject.spi.ProcessObserverMethod;
import javax.enterprise.inject.spi.ProcessProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple extension class to demonstrate life-cycle event logging.
 * 
 * @author GHajba
 *
 */
public class LifeCycleLogger implements Extension {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifeCycleLogger.class);
    
    public void eventObserver(@Observes Object event) {

        Class<?>[] interfaces = event.getClass().getInterfaces();
        if (event.getClass().isAnonymousClass()) {
            interfaces = event.getClass().getSuperclass().getInterfaces();
        }
        if (interfaces != null) {
            Arrays.stream(interfaces).forEach(e -> LOGGER.info(e.getCanonicalName()));
        }
    }

    void logLifecycleEvent(@Observes BeforeBeanDiscovery event) {
        LOGGER.info("BeforeBeanDiscovery");
    }

    void logLifecycleEvent(@Observes AfterTypeDiscovery event) {
        LOGGER.info("AfterTypeDiscovery: alternatives=" + event.getAlternatives() + ", interceptors="
                + event.getInterceptors() + ", decorators=" + event.getDecorators());
    }

    void logLifecycleEvent(@Observes AfterBeanDiscovery event) {
        LOGGER.info("AfterBeanDiscovery");
    }

    void logLifecycleEvent(@Observes AfterDeploymentValidation event) {
        LOGGER.info("AfterDeploymentValidation");
    }

    void logLifecycleEvent(@Observes BeforeShutdown event) {
        LOGGER.info("BeforeShutdown");
    }

    <X> void logLifecycleEvent(@Observes ProcessAnnotatedType<X> event) {
        LOGGER.info("ProcessAnnotatedType: annotatedType=" + event.getAnnotatedType());
    }

    <T, X> void logLifecycleEvent(@Observes ProcessInjectionPoint<T, X> event) {
        LOGGER.info("ProcessInjectionPoint: injectionPoint=" + event.getInjectionPoint());
    }

    <X> void logLifecycleEvent(@Observes ProcessInjectionTarget<X> event) {
        LOGGER.info("ProcessInjectionTarget: annotatedType=" + event.getAnnotatedType());
    }

    <T, X> void logLifecycleEvent(@Observes ProcessProducer<T, X> event) {
        LOGGER.info("ProcessProducer: annotatedMember=" + event.getAnnotatedMember());
    }

    <T> void logLifecycleEvent(@Observes ProcessBeanAttributes<T> event) {
        LOGGER.info("ProcessBeanAttributes: beanAttributes=" + event.getBeanAttributes());
    }

    <X> void logLifecycleEvent(@Observes ProcessBean<X> event) {
        LOGGER.info("ProcessBean: bean=" + event.getBean());
    }

    <T, X> void logLifecycleEvent(@Observes ProcessObserverMethod<T, X> event) {
        LOGGER.info("ProcessObserverMethod: observerMethod" + event.getObserverMethod());
    }
}
