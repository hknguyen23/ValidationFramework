package com.company.Function;

import java.util.HashMap;

public class ValidateFunction {

    private static HashMap <String, ValidateFunction> functionList = new HashMap<String, ValidateFunction>();

    static {
        functionList.put("Larger", new LargerValidate());
        functionList.put("Equal", new EqualValidate());
    }

    public static ValidateFunction getFunction(String name) {
        if (functionList.containsKey(name)) {
            return functionList.get(name);
        }
        else {
            return null;
        }
    }

    public Boolean isValid(Object[] args) {
        return true;
    };
}