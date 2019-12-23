package com.paynet.aspect;

import com.paynet.entity.Application;
import com.paynet.entity.ApplicationUser;
import com.paynet.repository.ApplicationRepository;
import com.paynet.service.impl.ApplicationUserDetailsServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizeActionAspect {
    @Autowired
    private ApplicationRepository userRepository;

    @Before(value = "execution(* com.paynet.service.impl.ApplicationServiceImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Application) {
                ApplicationUser user = userRepository.findUserByApplication((Application) arg);
                ApplicationUserDetailsServiceImpl.ApplicationUserDetails authentication = (ApplicationUserDetailsServiceImpl.ApplicationUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            }
        }
    }

}
