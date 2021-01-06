package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class NotNullValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
