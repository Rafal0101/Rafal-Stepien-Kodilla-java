package com.kodilla.patterns2.facade.aop;

/*
Exercise 20.3
Zadanie: Dodajemy logowanie żądań do fasady
W submodule 20.1 projektowaliśmy fasadę. Dopisz do niej aspekty wykonujące zapisy do logów każdego wywołania
metody processOrder(). Aby dodać aspekt do klasy OrderFacade musisz usunąć słowo final z jej deklaracji - nie można
tworzyć aspektów dla klas, z których zablokowano dziedziczenie.
 */

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId) && target(object)")
    public void logEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Items in Order: " + orderDto + ", UserId: " + userId);
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time for processOrder: " + (end - begin) + " [ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @AfterThrowing("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("Method threw an exception!");
    }
}
