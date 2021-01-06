package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class SizeValidate extends ValidateFunction {
    @Override
    public Boolean isValid(Object value, AttributeObject attribute) {
        return ((((int) value) >= (int) attribute.getAttribute("min")) &&
                  ((int) value <= (int) attribute.getAttribute("max")));
    }
}
