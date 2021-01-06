package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class SizeValidate extends ValidateFunction {
    @Override
    public Boolean isValid(Object value, AttributeObject attribute) {
        if(value instanceof Integer){
            return ((((int) value) >= (int) attribute.getAttribute("min")) &&
                    ((int) value <= (int) attribute.getAttribute("max")));
        } else if(value instanceof String){
            return ((value.toString().length() >= (int) attribute.getAttribute("min")) &&
                    (value.toString().length() <= (int) attribute.getAttribute("max")));
        }
        return false;
    }
}
