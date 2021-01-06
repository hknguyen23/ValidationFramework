package com.company.CustomFunction;

import com.company.Annotation.CustomFunction;
import com.company.FunctionManager.AttributeObject;

public class NotNegative {
    @CustomFunction(value = "NotNegative")
    public Boolean isValid(Object value, AttributeObject attribute) {
        if (value == null) {
            return true;
        }
        return (int) value >= 0;
    }
}
