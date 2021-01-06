package com.company.validationStrategy;

import java.util.List;

public interface ValidationStrategy {

    List<String> validate(Object input);
}
