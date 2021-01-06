package com.company.FunctionManager;

import com.company.Object.Person;
import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;
import com.company.validationStrategy.ValidationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidateManager {

    private ValidationStrategy strategy;


//    private List<String> messages = new ArrayList<>();

    public void setStrategy(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    private ValidateManager() {

    }

    public static ValidateManager createFailFastValidator() {
        ValidateManager validateManager = new ValidateManager();
        validateManager.setStrategy(FailFastValidationStrategy.getInstance());
        return validateManager;
    }

    public static ValidateManager createNormalValidator() {
        ValidateManager validateManager = new ValidateManager();
        validateManager.setStrategy(NormalValidationStrategy.getInstance());
        return validateManager;
    }

    public List<String> validate(Object object) {
        //
        com.company.Annotation.ValidationStrategy annotation = object.getClass().getAnnotation(com.company.Annotation.ValidationStrategy.class);
        if (Objects.isNull(annotation)) {
            // TODO: have a default strategy
            return FailFastValidationStrategy.getInstance().validate(object);
        } else {
            if (annotation.value() == FailFastValidationStrategy.class) {
                return FailFastValidationStrategy.getInstance().validate(object);
            } else {
                return NormalValidationStrategy.getInstance().validate(object);
            }

        }
    }

}

