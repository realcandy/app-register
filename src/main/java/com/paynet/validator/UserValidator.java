package com.paynet.validator;

import com.paynet.model.UserRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created by Dev1 on 23.12.2019.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "required");
        ValidationUtils.rejectIfEmpty(errors, "address", "required");
        ValidationUtils.rejectIfEmpty(errors, "dateBirth", "required");
        ValidationUtils.rejectIfEmpty(errors, "username", "required");
    }
}
