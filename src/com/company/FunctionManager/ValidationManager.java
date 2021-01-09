package com.company.FunctionManager;

import com.company.Constant.ValidatorStrategy;
import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;
import com.company.validationStrategy.ValidationStrategy;

import java.util.HashMap;
import java.util.List;

public class ValidationManager {

	private ValidationStrategy strategy = null;
	private static HashMap<ValidatorStrategy, ValidationStrategy> list = new HashMap<>();

	static {
		list.put(ValidatorStrategy.NORMAL_VALIDATOR, NormalValidationStrategy.getInstance());
		list.put(ValidatorStrategy.FAST_VALIDATOR, FailFastValidationStrategy.getInstance());
	}

	public static ValidationManager createValidatorStrategyByName(String nameStrategy){
		ValidationManager validationManager = new ValidationManager();
		validationManager.setStrategy(getValidationStrategy(nameStrategy));
		return validationManager;
	}

	public String getValidationStrategyName(){
		return strategy.getNameStrategy();
	}

	public String getValidationStrategyDescription(){
		return strategy.getDescriptionStrategy();
	}

	public void updateStrategy(String name){
		setStrategy(getValidationStrategy(name));
	}

	public List<String> validate(Object object) {
		return strategy.validate(object);
	}


	private static ValidationStrategy getValidationStrategy(String name){
		ValidatorStrategy validatorStrategy = ValidatorStrategy.isValid(name);
		if(list.containsKey(validatorStrategy)){
			return list.get(validatorStrategy);
		}
		return list.get(ValidatorStrategy.NORMAL_VALIDATOR);
	}

	private void setStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

}

