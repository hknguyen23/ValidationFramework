package com.company.Function;

public class RegexValidate extends ValidateFunction {
    public Boolean isValid(Object value, Object[] attribute) {
        if (value == null) {
            return true;
        }
        return value.toString().matches(attribute[0].toString());
    }
}