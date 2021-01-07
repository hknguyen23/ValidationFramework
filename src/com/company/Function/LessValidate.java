package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class LessValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        int number = (int)attribute.getAttribute("value");
        setMessage(attribute, "Value is not less than " + number);
        if (value == null) {
            return true;
        }
        return (int)value < number;
    }
}
