package com.company.Function;

public class NotEmptyValidate extends ValidateFunction {
    public Boolean isValid(Object value, Object[] attribute) {
        if (value == null || value.toString().length() == 0) {
            return false;
        }
        return true;
    }
}
