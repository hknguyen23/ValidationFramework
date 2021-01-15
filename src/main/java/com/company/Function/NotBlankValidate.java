package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class NotBlankValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        if (value == null || value.toString().trim().length() == 0) {
            return false;
        }
        return true;
    }
}
