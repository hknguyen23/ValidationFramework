package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class LengthValidate extends ValidateFunction {
  @Override
  public Boolean isValid(Object value, AttributeObject attribute) {
    int number = (int)attribute.getAttribute("value");
    setMessage(attribute, "String length must be equal to " + number);
    return ((String)value).length() == number;
  }
}
