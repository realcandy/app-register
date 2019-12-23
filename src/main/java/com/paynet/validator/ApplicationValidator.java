package com.paynet.validator;

import com.paynet.model.ApplicationRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Dev1 on 23.12.2019.
 */
public class ApplicationValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return ApplicationRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "title", "required");
        ValidationUtils.rejectIfEmpty(errors, "text", "text");
    }
}
