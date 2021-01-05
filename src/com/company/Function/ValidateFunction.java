package com.company.Function;

import java.util.HashMap;

public class ValidateFunction implements Cloneable {

    private static HashMap <String, ValidateFunction> functionList = new HashMap<String, ValidateFunction>();

    static {
        functionList.put("Larger", new LargerValidate());
        functionList.put("Less", new LessValidate());
        functionList.put("Equal", new EqualValidate());
        functionList.put("NotNull", new NotNullValidate());
        functionList.put("NotBlank", new NotBlankValidate());
        functionList.put("NotEmpty", new NotEmptyValidate());
        functionList.put("Email", new EmailValidate());
        functionList.put("Regex", new RegexValidate());

    }

    public static ValidateFunction getFunction(String name) throws CloneNotSupportedException {
        if (functionList.containsKey(name)) {
            return (ValidateFunction) functionList.get(name).clone();
        }
        else {
            return null;
        }
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Boolean isValid(Object value, Object[] attribute) {
        return true;
    };
    public String getMessage(Object[] attribute) {
        return (String) attribute[attribute.length - 1];
    };
}