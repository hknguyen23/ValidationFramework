package com.company.Function;

import java.util.HashMap;

public class ValidateFunction {

    private static HashMap <String, ValidateFunction> functionList = new HashMap<String, ValidateFunction>();

    static {
        functionList.put("Larger", new LargerValidate());
        functionList.put("Less", new LessValidate());
        functionList.put("Equal", new EqualValidate());
        functionList.put("NotNull", new NotNullValidate());
        functionList.put("NotBlank", new NotBlankValidate());
        functionList.put("NotEmpty", new NotEmptyValidate());
        functionList.put("Email", new EmailValidate());
    }

    public static ValidateFunction getFunction(String name) {
        if (functionList.containsKey(name)) {
            return functionList.get(name);
        }
        else {
            return null;
        }
    }

    public static boolean isAnnotationExisted(String name){
        if(functionList.containsKey(name)){
            return true;
        }
        return false;
    }

    public Boolean isValid(Object value, Object[] attribute) {
        return true;
    };
}