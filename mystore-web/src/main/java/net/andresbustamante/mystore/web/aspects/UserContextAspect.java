package net.andresbustamante.mystore.web.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import net.andresbustamante.mystore.api.util.UserContext;
import net.andresbustamante.mystore.api.util.UserContextHolder;

@Aspect
public class UserContextAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void filterControllerMethods() {
        // no-op
    }

    @Around("filterControllerMethods()")
    public Object injectUserContext(final ProceedingJoinPoint joinPoint) throws Throwable {
        if (UserContextHolder.getUserContext() == null || UserContext.UNKNOWN_USER.equals(UserContextHolder.getUserContext())) {
            // Use Spring Security to get the current user
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserContext context = authentication != null && authentication.isAuthenticated()
                    ? new UserContext(authentication.getName()) : UserContext.UNKNOWN_USER;
            UserContextHolder.setUserContext(context);
        }
        return joinPoint.proceed();
    }
}
