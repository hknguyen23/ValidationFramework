package com.company.FunctionManager;

import com.company.Constant.ValidatorStrategy;
import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;
import com.company.validationStrategy.ValidationStrategy;

import java.util.HashMap;

public class StrategyManager {

    private static HashMap<ValidatorStrategy, ValidationStrategy> list = new HashMap<>();

    static {
        list.put(ValidatorStrategy.NORMAL_VALIDATOR, NormalValidationStrategy.getInstance());
        list.put(ValidatorStrategy.FAST_VALIDATOR, FailFastValidationStrategy.getInstance());
    }

    public static ValidationStrategy getValidationStrategy(String name){
        ValidatorStrategy validatorStrategy = ValidatorStrategy.isValid(name);
        if(list.containsKey(validatorStrategy)){
            return list.get(validatorStrategy);
        }
        return list.get(ValidatorStrategy.NORMAL_VALIDATOR);
    }
}
