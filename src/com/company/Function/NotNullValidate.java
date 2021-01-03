package com.company.Function;

public class NotNullValidate extends ValidateFunction {
    public Boolean isValid(Object value, Object[] attribute) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
