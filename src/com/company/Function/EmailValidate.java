package com.company.Function;

public class EmailValidate extends ValidateFunction {

    public Boolean isValid(Object value, Object[] attribute) {
        if (value == null || !value.toString().matches(attribute[0].toString())) {
            return false;
        }
        return true;
    }
}
