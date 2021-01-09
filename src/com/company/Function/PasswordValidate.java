package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class PasswordValidate extends ValidateFunction {
    private boolean validate(String password, int min, int max, boolean isContainLetter) {
        if (password == null || password.length() == 0) {
            return true;
        } else if (password.length() < min || password.length() > max) {
            return false;
        }
        
        boolean result = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                result = true;
            } else if (Character.isSpaceChar(c)) {
                // password contains no white space character
                return false;
            }
        }

        return result == isContainLetter;
    }

    public Boolean isValid(Object value, AttributeObject attribute) {
        int min = (int)attribute.getAttribute("min");
        int max = (int)attribute.getAttribute("max");
        boolean isContainLetter = (boolean)attribute.getAttribute("isContainLetter");
        setMessage(attribute, "Password length must be between " + min + " and " + max +
                (isContainLetter ? " and must contain at least a letter" : ""));
        return value == null || validate((String)value, min, max, isContainLetter);
    }
}
