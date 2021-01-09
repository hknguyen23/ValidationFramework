package com.company.Constant;

public enum ValidatorStrategy {
    FAST_VALIDATOR("FAST_VALIDATOR"),
    NORMAL_VALIDATOR("NORMAL_VALIDATOR");

    private String name;

    ValidatorStrategy(String name) {
        this.name = name;
    }

    public static ValidatorStrategy isValid(String name){
        for(ValidatorStrategy validatorStrategy: values()){
            if(validatorStrategy.name.equals(name)){
                return validatorStrategy;
            }
        }
        return null;
    }
}
