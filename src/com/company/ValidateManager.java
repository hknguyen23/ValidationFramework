package com.company;

import com.company.Annotation.Equal;
import com.company.Annotation.Larger;
import com.company.Function.ValidateFunction;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidateManager {
    public void validate(Object object) {
        try {
            // check if object is null
            if (Objects.isNull(object)) {
                throw new Exception("The object to serialize is null");
            }

            List<String> Message = new ArrayList<>();
            Class<?> objectClass = object.getClass();
            // check each field of class
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);

                // check if annotation of field is one of validate annotation
                if (field.isAnnotationPresent(Larger.class)) {
                    // get validate function
                    ValidateFunction temp = ValidateFunction.getFunction("Larger");
                    if (temp != null) {
                        // args = {input value, value on annotation}
                        Object[] args = {field.get(object), field.getAnnotation(Larger.class).value()};
                        Boolean result = temp.isValid(args);
                        if (result) {
                            Message.add(field.getName() + " is valid");
                        }
                        else {
                            Message.add(field.getName() + " isn't valid");
                        }
                    }
                }
                if (field.isAnnotationPresent(Equal.class)) {
                    ValidateFunction temp = ValidateFunction.getFunction("Equal");
                    if (temp != null) {
                        // args = {input value, value on annotation}
                        Object[] args = {field.get(object), field.getAnnotation(Equal.class).value()};
                        Boolean result = temp.isValid(args);
                        if (result) {
                            Message.add(field.getName() + " is valid");
                        }
                        else {
                            Message.add(field.getName() + " isn't valid");
                        }
                    }
                }
            }

            // print all message
            System.out.println("In " + object.getClass());
            for (int i=0; i<Message.size(); i++) {
                System.out.println("    " + Message.get(i));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

