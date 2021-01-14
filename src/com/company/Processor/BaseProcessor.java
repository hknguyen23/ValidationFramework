package com.company.Processor;

import com.company.Function.ValidateFunction;
import com.company.Function.ValidateFunctionManager;
import com.company.FunctionManager.AttributeObject;
import com.company.Object.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseProcessor {
    private static int nextID = 1;
    private int id = nextID++;
    protected BaseProcessor nextInChain;

    public void add(BaseProcessor next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public String execute(Field field, Object object) throws InvocationTargetException, IllegalAccessException, CloneNotSupportedException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        return "";
    }
}
