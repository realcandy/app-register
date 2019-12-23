package com.paynet.aspect;

import com.paynet.entity.Application;
import com.paynet.entity.ApplicationUser;
import com.paynet.repository.UserRepository;
import com.paynet.util.SecurityContextUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizeActionAspect {
    @Autowired
    private UserRepository userRepository;

    @Before(value = "execution(* com.paynet.service.impl.ApplicationServiceImpl.*(..)) and @annotation(com.paynet.aspect.AuthorizeAction)")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Application) {
                ApplicationUser user = userRepository.findUserByApplication((Application) arg);
                String currentUsername = SecurityContextUtils.getUsername();
                if (user == null || user.getUsername() == null)
                    throw new AuthorizeActionException("An error occurred during " + joinPoint.getSignature().getName());
                if (!user.getUsername().equalsIgnoreCase(currentUsername))
                    throw new AuthorizeActionException("An error occurred, application user and current authorized user do not match");
            }
        }
    }

}
