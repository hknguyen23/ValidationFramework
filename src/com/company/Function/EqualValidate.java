package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class EqualValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        int number = (int)attribute.getAttribute("value");
        setMessage(attribute, "Value is not equal to " + number);
        if (value == null) {
            return true;
        }
        return (int)value == number;
    }
}
