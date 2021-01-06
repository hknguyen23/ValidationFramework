package com.company.FunctionManager;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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

                // create chain of processor
                if (anno.length != 0) {

                    Processor proc = new Processor(anno[0]);
                    for (int i = 1; i < anno.length; i++) {
                        proc.add(new Processor(anno[i]));
                    }

                    String result = proc.execute(field, object);
                    if (!result.equals("Valid")) {
                        this.messages.add(field.getName() + ": " + result + "\n");
                    }
                }
                /*
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
                                this.messages.add(field.getName() + ": Valid\n");
                            } else {
                                this.messages.add(field.getName() + ": Not Valid\n");
                            }
                        }
                        catch (Exception e) {
                            this.messages.add(field.getName() + ": Unexpected Error: " + e.getMessage() + '\n');
                        }
                    }
                }
                 */
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return messages.size() == 0 ? true : false;
    }

}

