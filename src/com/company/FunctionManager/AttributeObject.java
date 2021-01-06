package com.company.FunctionManager;

import java.util.HashMap;
import java.util.Set;

public class AttributeObject {

    private static HashMap<String, Object> attributes = new HashMap<String, Object>();

    public Set<String> getAllAttributes() {
        return attributes.keySet();
    }

    public Object getAttribute(String name) {
        if (attributes.containsKey(name))
            return attributes.get(name);
        return null;
    }

    public Boolean setAttribute(String name, Object newValue) {
        attributes.put(name, newValue);
        return true;
    }
}