package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class SizeValidate extends ValidateFunction {
    @Override
    public Boolean isValid(Object value, AttributeObject attribute) {
        int min = (int) attribute.getAttribute("min");
        int max = (int) attribute.getAttribute("max");
        if(value instanceof Integer) {
            setMessage(attribute, "Value must be between " + min + " and " + max);
            return ((((int) value) >= min) && ((int) value <= max));
        } else if(value instanceof String) {
            setMessage(attribute, "String length must be between " + min + " and " + max);
            return ((value.toString().length() >= min) && (value.toString().length() <= max));
        }
        return false;
    }
}
