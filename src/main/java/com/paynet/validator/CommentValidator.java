package com.paynet.validator;

import com.paynet.model.CommentApplicationRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Dev1 on 23.12.2019.
 */
public class CommentValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return CommentApplicationRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "application", "required");
        ValidationUtils.rejectIfEmpty(errors, "application.id", "required");
        ValidationUtils.rejectIfEmpty(errors, "comment", "required");
        ValidationUtils.rejectIfEmpty(errors, "comment.text", "required");
    }
}
