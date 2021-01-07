package com.company.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {
    public int min() default 6;
    public int max() default 15;
    public boolean isContainLetter() default false;
    public String message() default "Password length must be between 6 and 15";
}
