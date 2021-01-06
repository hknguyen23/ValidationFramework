package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class EqualValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        if (value == null) {
            return true;
        }
        return (int)value == (int)attribute.getAttribute("value");
    }
}
