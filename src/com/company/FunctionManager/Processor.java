package com.company.FunctionManager;

import com.company.Function.ValidateFunction;
import com.company.Object.Person;

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

        Class aClass = Person.class;

        Annotation[] anno = aClass.getAnnotations();

        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public String execute(Field field, Object object) throws InvocationTargetException, IllegalAccessException, CloneNotSupportedException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        field.setAccessible(true);


        Class<? extends Annotation> type = this.annotation.annotationType();

        // get name of annotation
        String AnnotationName = type.getSimpleName();

        // get value of annotation's attribute
        Method[] methods = type.getDeclaredMethods();

        AttributeObject AttributeManager = new AttributeObject();
        for (int i = 0; i < methods.length; i++) {
            Object attribute = methods[i].invoke(this.annotation, (Object[]) null);
            AttributeManager.setAttribute(methods[i].getName(), attribute);
        }

        // get function of annotation
        String message = "Valid";
        ValidateFunction temp = ValidateFunction.getFunction(AnnotationName);
        if (temp != null) {
            try {
                Boolean result = temp.isValid(field.get(object), AttributeManager);
                if (result) {
                    message = "Valid";
                } else {
                    message = temp.getMessage(AttributeManager);
                }
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        } else if (AttributeManager.getAttribute("validatedBy") != null) {
            Boolean result = false;

            // get class that has custom method
            String className = (String) AttributeManager.getAttribute("validatedBy");
            Class<?> cls = Class.forName(className);

            // check if class has method with "CustonFunction" annotation
            Method method = findAndGetCustomMethod(cls, type.getSimpleName());
            if (method != null && ValidateFunction.class.isAssignableFrom(cls)) {
                result = (Boolean) method.invoke(cls.getDeclaredConstructor().newInstance(), field.get(object), AttributeManager);
                if (result == true) {
                    message = "Valid";
                }
                else if (result == false){
                    if (AttributeManager.getAttribute("message") != null) {
                        message = (String) AttributeManager.getAttribute("message");
                    }
                    else {
                        message = "Not Valid";
                    }
                }
            }
            else {
                message = "Custom validate function not found";
            }

        }

        if (nextInChain == null) {
            return message;
        } else if (!message.equals("Valid")) {
            return message;
        } else {
            return nextInChain.execute(field, object);
        }
    }


    private Method findAndGetCustomMethod(Class<?> cls, String annotationName) throws InvocationTargetException, IllegalAccessException {
        // find custom function with marked annotation
        Method validateMethod = null;

        Method[] methods = cls.getDeclaredMethods();                                                 // get all method in class
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (method.getName().equals("isValid")) {
                return method;
            }
        }
        return null;
    }


}
