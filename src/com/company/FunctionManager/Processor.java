package com.company.FunctionManager;

import com.company.Function.ValidateFunction;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Processor {
    private static int nextID = 1;
    private int id = nextID++;
    private Processor nextInChain;
    private Annotation annotation;

    public Processor(Annotation annotation) {
        this.annotation = annotation;
    }

    public void add(Processor next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public String execute(Field field, Object object) throws InvocationTargetException, IllegalAccessException {
        field.setAccessible(true);


        Class<? extends Annotation> type = this.annotation.annotationType();

        // get name of annotation
        String AnnotationName = type.getSimpleName();

        // get value of annotation's attribute
        Method[] methods = type.getDeclaredMethods();
        Object[] attributes = new Object[methods.length];
        for (int i = 0; i < methods.length; i++) {
            attributes[i] = methods[i].invoke(this.annotation, (Object[]) null);
        }

        // get function of annotation
        ValidateFunction temp = ValidateFunction.getFunction(AnnotationName);
        if (temp != null) {
            try {
                Boolean result = temp.isValid(field.get(object), attributes);
                if (result && nextInChain == null) {
                    return "Valid";
                } else if (result) {
                    return nextInChain.execute(field, object);
                } else {
                    return "Not Valid";
                }
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        }

        return nextInChain.execute(field, object);
    }
}
