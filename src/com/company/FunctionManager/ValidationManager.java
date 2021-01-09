package com.company.FunctionManager;

import com.company.Constant.ValidatorStrategy;
import com.company.Function.ValidateFunction;
import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;
import com.company.validationStrategy.ValidationStrategy;

import java.util.List;

public class ValidationManager { // context

	private ValidationStrategy strategy = null;
	//private List<String> messages = new ArrayList<>();

	public static ValidationManager createValidatorStrategyByName(String nameStrategy){
		ValidationManager validationManager = new ValidationManager();
		validationManager.setStrategy(getValidationStrategy(nameStrategy));
		return validationManager;
	}

	public String getValidationStrategyName(){
		return strategy.nameStrategy();
	}

	public String getValidationStrategyDescription(){
		return strategy.description();
	}

	public void updateStrategy(String name){
		setStrategy(getValidationStrategy(name));
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


	private static ValidationStrategy getValidationStrategy(String name){
		if(ValidatorStrategy.FAST_VALIDATOR.equals(ValidatorStrategy.isValid(name))){
			return FailFastValidationStrategy.getInstance();
		}
		return NormalValidationStrategy.getInstance();
	}


	private void setStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

}

