package com.paynet.aspect;

import org.springframework.security.access.AuthorizationServiceException;

/**
 * Created by Dev1 on 23.12.2019.
 */
public class AuthorizeActionException extends AuthorizationServiceException{
    public AuthorizeActionException(String msg) {
        super(msg);
    }
}
