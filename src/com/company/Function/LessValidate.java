package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class LessValidate extends ValidateFunction {
    public Boolean isValid(Object value, AttributeObject attribute) {
        int number = (int)attribute.getAttribute("value");

        String message = (String)attribute.getAttribute("message");
        if (!message.equals("Not less")) {
            // check if not equal to default
            setMessage(attribute, message);
        }
        else setMessage(attribute, "Value is not less than " + number);

        if (value == null) {
            return true;
        }
        return (int)value < number;
    }
}
