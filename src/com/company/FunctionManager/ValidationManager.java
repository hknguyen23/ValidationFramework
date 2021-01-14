package com.company.FunctionManager;


import com.company.validationStrategy.ValidationStrategy;

import java.util.List;

public class ValidationManager {

	private ValidationStrategy strategy = null;

	public static ValidationManager createValidatorStrategyByName(String nameStrategy){
		ValidationManager validationManager = new ValidationManager();
		validationManager.setStrategy(StrategyManager.getValidationStrategy(nameStrategy));
		return validationManager;
	}

	public String getValidationStrategyName(){
		return strategy.getNameStrategy();
	}

	public String getValidationStrategyDescription(){
		return strategy.getDescriptionStrategy();
	}

	public void updateStrategy(String name){
		setStrategy(StrategyManager.getValidationStrategy(name));
	}

	public List<String> validate(Object object) {
		return strategy.validate(object);
	}

	private void setStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

}

