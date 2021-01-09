package com.company.validationStrategy;

import com.company.FunctionManager.Processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FailFastValidationStrategy implements ValidationStrategy {

    private static FailFastValidationStrategy instance;// singleton pattern

    private static final Object LOCK = new Object();

    private FailFastValidationStrategy(){ }

    public static ValidationStrategy getInstance() {
        synchronized (LOCK) {
            if (Objects.isNull(instance)) {
                instance = new FailFastValidationStrategy();
            }
            return instance;
        }
    }

    @Override
    public List<String> validate(Object object) {
        List<String> messages = new ArrayList<>();
        try {
            // clear old error message
            //messages.clear();

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

                // create chain of processor
                if (anno.length != 0) {

                    Processor proc = new Processor(anno[0]);
                    for (int i = 1; i < anno.length; i++) {
                        proc.add(new Processor(anno[i]));
                    }

                    String result = proc.execute(field, object);
                    if (!result.equals("Valid")) {
                        messages.add(field.getName() + ": " + result + "\n");
                        return messages;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return messages;
    }

    @Override
    public String nameStrategy() {
        return "Fast validation.";
    }

    @Override
    public String description() {
        return "Fast validation will return error immediately when first meet an invalid field.";
    }
}
