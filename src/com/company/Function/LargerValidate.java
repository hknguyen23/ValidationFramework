package com.company.Function;

public class LargerValidate extends ValidateFunction {
    public Boolean isValid(Object[] args) {
        return (int)args[0] > (int)args[1];
    }
}
