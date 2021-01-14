package com.company.Function;

import com.company.FunctionManager.AttributeObject;

import java.util.HashMap;

public class ValidateFunction implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Boolean isValid(Object value, AttributeObject attribute) {
        return true;
    }

    public String getMessage(AttributeObject attribute) {
        return (String)attribute.getAttribute("message");
    }

    // use to custom message error to be shown
    public void setMessage(AttributeObject attribute, String message) {
        attribute.setAttribute("message", message);
    }
}