package com.company.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CheckDate {
    public String dateFormat() default "yyyy-MM-dd";
    public String message() default "Date is not match the format or is an invalid date";
}
