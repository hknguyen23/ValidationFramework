package com.company.Function;

public class LessValidate extends ValidateFunction {
    public Boolean isValid(Object value, Object[] attribute) {
        if (value == null) {
            return true;
        }
        return (int)value < (int)attribute[0];
    }
}
