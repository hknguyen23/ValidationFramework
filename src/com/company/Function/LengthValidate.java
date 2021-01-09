package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class LengthValidate extends ValidateFunction {
  @Override
  public Boolean isValid(Object value, AttributeObject attribute) {
    int number = (int)attribute.getAttribute("value");
    String message = (String)attribute.getAttribute("message");

    if (!message.equals("Input length must be exact equal to value")) {
      // check if not equal to default
      setMessage(attribute, message);
    }
    else setMessage(attribute, "String length must be equal to " + number);

    return ((String)value).length() == number;
  }
}
