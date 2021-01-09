package com.company.FunctionManager;

import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;
import com.company.validationStrategy.ValidationStrategy;

import java.util.List;

public class ValidationManager { // context

	private ValidationStrategy strategy = null;
	//private List<String> messages = new ArrayList<>();

	public ValidationManager() {
		this.strategy = NormalValidationStrategy.getInstance();
	}

	public void setStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

	public static ValidationManager createFailFastValidator() {
		ValidationManager validationManager = new ValidationManager();
		validationManager.setStrategy(FailFastValidationStrategy.getInstance());
		return validationManager;
	}

	public static ValidationManager createNormalValidator() {
		ValidationManager validationManager = new ValidationManager();
		validationManager.setStrategy(NormalValidationStrategy.getInstance());
		return validationManager;
	}

	public List<String> validate(Object object) {
		return strategy.validate(object);
//        com.company.Annotation.ValidationStrategy annotation = object.getClass().getAnnotation(com.company.Annotation.ValidationStrategy.class);
//        if (Objects.isNull(annotation)) {
//            // TODO: have a default strategy
//            return FailFastValidationStrategy.getInstance().validate(object);
//        } else {
//            if (annotation.value() == FailFastValidationStrategy.class) {
//                return FailFastValidationStrategy.getInstance().validate(object);
//            } else {
//                return NormalValidationStrategy.getInstance().validate(object);
//            }
//        }
	}

}

