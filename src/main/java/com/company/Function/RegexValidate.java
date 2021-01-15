package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class RegexValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        if (value == null) {
            return true;
        }
        return value.toString().matches(attribute.getAttribute("value").toString());
    }
}