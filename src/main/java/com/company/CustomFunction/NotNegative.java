package com.company.CustomFunction;

import com.company.Function.ValidateFunction;
import com.company.FunctionManager.AttributeObject;

public class NotNegative extends ValidateFunction {
    @Override
    public Boolean isValid(Object value, AttributeObject attribute) {
        if (value == null) {
            return true;
        }
        return (int) value >= 0;
    }
}
