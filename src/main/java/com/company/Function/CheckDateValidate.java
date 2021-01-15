package com.company.Function;

import com.company.FunctionManager.AttributeObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDateValidate extends ValidateFunction {
    private boolean validate(String dateString, String dateFormat) {
        boolean valid = true;
        if (dateString.length() == 0){
            return true;
        }

        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            dateString = dateString.trim();
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            valid = false;
        }

        return valid;
    }

    public Boolean isValid(Object value, AttributeObject attribute) {
        return value == null || validate((String)value, (String)attribute.getAttribute("dateFormat"));
    }
}
