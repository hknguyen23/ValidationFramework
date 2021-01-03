package com.company;

import com.company.Annotation.Equal;
import com.company.Annotation.Larger;
import com.company.Function.ValidateFunction;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidateManager {
    private List<String> messages = new ArrayList<String>();

    public List<String> getMessages() {
        return messages;
    }

    public Boolean validate(Object object) {
        try {
            // clear old error message
            messages.clear();

            // check if object is null
            if (Objects.isNull(object)) {
                throw new Exception("The object to serialize is null");
            }

            Class<?> objectClass = object.getClass();

            // check each field of class
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);


                // check annotation of field
                Annotation[] anno = field.getDeclaredAnnotations();
                if (anno.length != 0) {
                    Class<? extends Annotation> type = anno[0].annotationType();

                    // get name of annotation
                    String AnnotationName = type.getSimpleName();

                    // get value of annotation's attribute
                    Method[] methods = type.getDeclaredMethods();
                    Object[] attributes = new Object[methods.length];
                    for (int i = 0; i < methods.length; i++) {
                        attributes[i] = methods[i].invoke(anno[0], (Object[]) null);
                    }

                    // get function of annotation
                    ValidateFunction temp = ValidateFunction.getFunction(AnnotationName);
                    if (temp != null) {
                        try {
                            Boolean result = temp.isValid(field.get(object), attributes);
                            if (result) {
                                this.messages.add(field.getName() + " is valid\n");
                            } else {
                                this.messages.add(field.getName() + " isn't valid\n");
                            }
                        }
                        catch (Exception e) {
                            this.messages.add(field.getName() + " has unexpected error: " + e.getMessage() + '\n');
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return messages.size() == 0 ? true : false;
    }

}

