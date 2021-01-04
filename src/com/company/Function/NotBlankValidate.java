package com.company.Function;

public class NotBlankValidate extends ValidateFunction {
    public Boolean isValid(Object value, Object[] attribute) {
        if (value == null || value.toString().trim().length() == 0) {
            return false;
        }
        return true;
    }
}
