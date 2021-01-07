package com.company.Function;

import com.company.FunctionManager.AttributeObject;

import java.util.HashMap;

public class ValidateFunction implements Cloneable {
    private static HashMap<String, ValidateFunction> functionList = new HashMap<String, ValidateFunction>();
    static {
        functionList.put("Larger", new LargerValidate());
        functionList.put("Less", new LessValidate());
        functionList.put("Equal", new EqualValidate());
        functionList.put("NotNull", new NotNullValidate());
        functionList.put("NotBlank", new NotBlankValidate());
        functionList.put("NotEmpty", new NotEmptyValidate());
        functionList.put("Email", new EmailValidate());
        functionList.put("Regex", new RegexValidate());
        functionList.put("Length", new LengthValidate());
        functionList.put("Digit", new DigitValidate());
        functionList.put("Size", new SizeValidate());
        functionList.put("Password", new PasswordValidate());
        functionList.put("CheckDate", new CheckDateValidate());
    }

    public static ValidateFunction getFunction(String name) throws CloneNotSupportedException {
        if (functionList.containsKey(name)) {
            return (ValidateFunction) functionList.get(name).clone();
        } else {
            return null;
        }
    }

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