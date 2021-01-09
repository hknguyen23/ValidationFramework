package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class LargerValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        int number = (int)attribute.getAttribute("value");
        setMessage(attribute, "Value is not larger than " + number);
        if (value == null) {
            return true;
        }
        return (int)value > number;
    }
}
