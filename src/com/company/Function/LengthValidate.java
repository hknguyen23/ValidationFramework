package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class LengthValidate extends ValidateFunction {
  @Override
  public Boolean isValid(Object value, AttributeObject attribute) {
    return ((String)value).length() == (int)attribute.getAttribute("value");
  }
}
