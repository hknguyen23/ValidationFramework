package com.company.Function;

import com.company.FunctionManager.AttributeObject;

public class DigitValidate extends ValidateFunction {
  @Override
  public Boolean isValid(Object value, AttributeObject attribute) {

    if(value == null)
      return true;
    return value.toString().matches((String)attribute.getAttribute("value"));
  }
}
